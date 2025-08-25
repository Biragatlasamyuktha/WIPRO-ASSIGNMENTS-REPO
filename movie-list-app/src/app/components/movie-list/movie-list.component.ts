import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MovieCardComponent } from '../movie-card/movie-card.component';

@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule,
    MovieCardComponent
  ],
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent {
  movies = [
    {
      title: 'Sita Ramam',
      genre: 'Love',
      description:
        'Sita Ramam is a 2022 Telugu romantic drama that follows two intersecting love stories across different time periods.',
      rating: 5,
      poster: 'https://upload.wikimedia.org/wikipedia/en/3/3b/Sita_Ramam.jpg'
    },
    {
      title: 'RRR',
      genre: 'Action',
      description:
        'RRR is a 2022 Indian Telugu-language epic action drama film directed by S. S. Rajamouli.',
      rating: 4,
      poster: 'https://upload.wikimedia.org/wikipedia/en/d/d7/RRR_Poster.jpg'
    }
  ];

  genres = ['All', 'Love', 'Action'];
  selectedGenre = 'All';

  get filteredMovies() {
    if (this.selectedGenre === 'All') {
      return this.movies;
    }
    return this.movies.filter(m => m.genre === this.selectedGenre);
  }

  get averageRating() {
    const total = this.movies.reduce((acc, m) => acc + m.rating, 0);
    return (total / this.movies.length).toFixed(1);
  }
}