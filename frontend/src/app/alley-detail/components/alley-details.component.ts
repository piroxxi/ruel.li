import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Alley } from '../../alley-list/models/alley';
import { AlleyService } from '../../alley.service';

@Component({
  selector: 'app-alley-details',
  standalone: true,
  imports: [],
  templateUrl: './alley-details.component.html',
  styleUrl: './alley-details.component.css'
})
export class AlleyDetailsComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  alleyService: AlleyService = inject(AlleyService);

  alley: Alley | undefined;
  constructor() {
    const alleyId = this.route.snapshot.params['id'];
    this.alley = this.alleyService.getAlley(alleyId);
  }
}
