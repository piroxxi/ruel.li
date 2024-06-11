import { Component } from '@angular/core';
import { AlleyListComponent } from './alley-list/components/alley-list.component';
import { RouterModule } from '@angular/router';
import { VersionComponent } from './version/version.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, AlleyListComponent, VersionComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'home';
}
