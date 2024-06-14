import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

export const isAuthenticated: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const router: Router = inject(Router);
  const oauthService: AuthService = inject(AuthService);

  if (oauthService.isLoggedIn()) {
    return true;
  }
  router.navigate(['login'], { queryParams: { returnUrl: state.url } });
  return false;
}

export const isNotAuthenticated: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const router: Router = inject(Router);
  const oauthService: AuthService = inject(AuthService);

  if (!oauthService.isLoggedIn()) {
    return true;
  }
  router.navigate(['/']);
  return false;
}
