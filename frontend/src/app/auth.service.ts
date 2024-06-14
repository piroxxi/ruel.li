import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, shareReplay } from 'rxjs';
import { Router } from '@angular/router';

export type Credentials = {
  username: string;
  password: string;
}
export type User = {
  username: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly USER_INFOS = 'user_infos';
  private user: User | undefined;


  constructor(private http: HttpClient, private router: Router) {
    let user = localStorage.getItem(this.USER_INFOS)
    if (user) {
      this.user = JSON.parse(user);
    }
    this.http
      .get<User>('api/auth/whoami')
      .subscribe({
        next: result => this.storeUser(result),
        error: error => {
          console.warn('Error during token validation. Not authenticated anymore.', error)
          this.user = undefined;
          localStorage.removeItem(this.USER_INFOS);
          this.router.navigate(['/login'], { queryParams: { expired: true } });
        }
      });
  }

  isLoggedIn() {
    return !!this.user;
  }

  authenticate(credentials: Credentials) {
    console.log('try to authenticate {username:"' + credentials.username + '", password: "*******"}')
    return this.http
      .post<User>('api/auth/login', credentials)
      .pipe(
        map(res => {
          this.storeUser(res);
          return res;
        }),
        shareReplay(1)
      );
  }

  private storeUser(user: User) {
    this.user = user;
    localStorage.setItem(this.USER_INFOS, JSON.stringify(user));
  }
}
