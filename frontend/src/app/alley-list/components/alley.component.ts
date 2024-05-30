import { Component, Input } from '@angular/core';
import { Alley } from '../models/alley';

@Component({
  selector: 'app-alley',
  standalone: true,
  imports: [],
  templateUrl: './alley.component.html',
  styleUrl: './alley.component.css'
})
export class AlleyComponent {
  @Input() alley!: Alley;
}
