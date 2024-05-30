import { Component, Input } from '@angular/core';
import { Alley } from '../models/alley';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-alley',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './alley.component.html',
  styleUrl: './alley.component.css'
})
export class AlleyComponent {
  @Input() alley!: Alley;
}
