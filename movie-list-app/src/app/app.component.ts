import { Component } from '@angular/core';
import { MovieListComponent } from './components/movie-list/movie-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MovieListComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}