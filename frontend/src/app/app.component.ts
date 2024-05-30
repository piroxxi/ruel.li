import { Component } from '@angular/core';
import { AlleyListComponent } from './alley-list/components/alley-list.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, AlleyListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'home';
}
