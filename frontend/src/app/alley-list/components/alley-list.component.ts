import { Component, inject, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Alley } from '../models/alley';
import { AlleyComponent } from './alley.component';
import { AlleyService } from '../../alley.service';

@Component({
  selector: 'app-alley-list',
  standalone: true,
  imports: [CommonModule, AlleyComponent],
  templateUrl: './alley-list.component.html',
  styleUrl: './alley-list.component.css'
})
export class AlleyListComponent {
  alleyList: Alley[];
  alleyService: AlleyService = inject(AlleyService);

  constructor() {
    this.alleyList = this.alleyService.getAllAlleys();
  }
}
