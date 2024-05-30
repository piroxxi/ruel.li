import { Injectable } from '@angular/core';
import { Alley } from './alley-list/models/alley';

@Injectable({
  providedIn: 'root'
})
export class AlleyService {
  alleys = [
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

  constructor() {
  }

  getAllAlleys(): Alley[] {
    return this.alleys;
  }

  getAlley(id: string): Alley|undefined {
    return this.alleys.find((a: Alley) => a.id === id);
  }
}
