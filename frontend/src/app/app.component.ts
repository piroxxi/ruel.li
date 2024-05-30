import { Component } from '@angular/core';
import { AlleyListComponent } from './alley-list/components/alley-list.component';
import { Alley } from './alley-list/models/alley';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [AlleyListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'home';
  alleyList: Alley[] = [
    {
      id: "a01bd3c7-8db2-43b0-a44b-2b4422892eb7",
      name: "Ruelle Boyer/Christophe-Colomb Bellechasse/Beaubien",
      shortname: "bbbcc",
      image: "/assets/blank_alley.png"
    }, {
      id: "67bc0d0e-2478-42b5-bf46-b73dfdeb0022",
      name: "Ruelle Test",
      shortname: "test",
      image: "/assets/blank_alley.png"
    }
  ];
}
