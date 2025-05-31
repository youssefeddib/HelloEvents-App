import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NavbarComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  upcomingEvents = [
    {
      id: 1,
      title: 'Summer Night Festival',
      date: '2024-06-15',
      location: 'Plage de la Méditerranée',
      image: 'https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?w=800'
    },
    {
      id: 2,
      title: 'Electronic Music Party',
      date: '2024-05-01',
      location: 'Club Le Velvet',
      image: 'https://images.unsplash.com/photo-1516450360452-9312f5e86fc7?w=800'
    },
    {
      id: 3,
      title: 'Festival des Arts',
      date: '2024-07-20',
      location: 'Parc Central',
      image: 'https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=800'
    },
    {
      id: 4,
      title: 'Concert Rock Underground',
      date: '2024-05-15',
      location: 'La Cave',
      image: 'https://images.unsplash.com/photo-1524368535928-5b5e00ddc76b?w=800'
    }
  ];
}
