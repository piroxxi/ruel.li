import { Injectable } from '@angular/core';
import { Alley } from './alley-list/models/alley';
import { HttpClient } from '@angular/common/http';
import { Observable, Subscription } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlleyService {
  constructor(private http: HttpClient) {
  }

  getAllAlleys(): Observable<Alley[]> {
    return this.http.get<Alley[]>('api/alleys');
  }

  getAlley(id: string): Observable<Alley> {
    return this.http.get<Alley>('api/alleys/' + id);
  }
}
