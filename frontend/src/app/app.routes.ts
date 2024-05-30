import { Routes } from '@angular/router';
import { AlleyListComponent } from './alley-list/components/alley-list.component';
import { AlleyDetailsComponent } from './alley-detail/components/alley-details.component';

export const routes: Routes = [
  {
    path: '',
    component: AlleyListComponent,
    title: 'All alleys',
  },
  {
    path: 'alley/:id',
    component: AlleyDetailsComponent,
    title: 'Alley details',
  },
];
