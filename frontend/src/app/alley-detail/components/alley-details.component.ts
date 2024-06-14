import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Alley } from '../../alley-list/models/alley';
import { AlleyService } from '../../alley.service';
import { Observable } from 'rxjs';
import { AsyncPipe, NgIf } from '@angular/common';

@Component({
  selector: 'app-alley-details',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf
  ],
  templateUrl: './alley-details.component.html',
  styleUrl: './alley-details.component.css'
})
export class AlleyDetailsComponent {
  private readonly alleyId: string;
  alleyObs: Observable<Alley>;

  constructor(private alleyService: AlleyService, private route: ActivatedRoute) {
    this.alleyId = this.route.snapshot.params['id'];
    this.alleyObs = this.alleyService.getAlley(this.alleyId);
  }
}
