import { Component } from '@angular/core';
import { AuthService, Credentials } from '../auth.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
})
export class LoginComponent {
  credentials: Credentials = { username: '', password: '' };

  constructor(private authService: AuthService, private router: Router) {
  }

  login() {
    this.authService.authenticate(this.credentials)
      .subscribe(
        () => {
          this.router.navigate(['/']);
        }
      );
  }
}
