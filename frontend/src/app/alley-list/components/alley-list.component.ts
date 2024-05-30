import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Alley } from '../models/alley';
import { AlleyComponent } from './alley.component';

@Component({
  selector: 'app-alley-list',
  standalone: true,
  imports: [CommonModule, AlleyComponent],
  templateUrl: './alley-list.component.html',
  styleUrl: './alley-list.component.css'
})
export class AlleyListComponent {
  @Input() alleyList!: Alley[];
}
