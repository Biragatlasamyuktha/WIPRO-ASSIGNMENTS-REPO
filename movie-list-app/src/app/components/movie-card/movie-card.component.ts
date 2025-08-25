import { Component, Input } from '@angular/core';
import { NgFor, NgClass } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-movie-card',
  standalone: true,
  imports: [NgFor, NgClass, MatCardModule],
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent {
  @Input() movie: any;
}