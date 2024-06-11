import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

type VersionData = {
  id: string;
  name: string;
}

@Component({
  selector: 'app-version',
  standalone: true,
  imports: [],
  templateUrl: './version.component.html',
  styleUrl: './version.component.css'
})
export class VersionComponent {
  resources: VersionData | undefined;

  constructor(private http: HttpClient) {
    http.get<VersionData>('/api/resource').subscribe(data => this.resources = data);
  }
}
