import { Routes } from '@angular/router';
import { AlleyListComponent } from './alley-list/components/alley-list.component';
import { AlleyDetailsComponent } from './alley-detail/components/alley-details.component';
import { LoginComponent } from './login/login.component';
import { isAuthenticated, isNotAuthenticated } from './app.authentication.guard';

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    title: 'Login',
    canActivate: [isNotAuthenticated],
  },
  {
    path: '',
    component: AlleyListComponent,
    title: 'All alleys',
    canActivate: [isAuthenticated],
  },
  {
    path: 'alley/:id',
    component: AlleyDetailsComponent,
    title: 'Alley details',
    canActivate: [isAuthenticated],
  },
];
