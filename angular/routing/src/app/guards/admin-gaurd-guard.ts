import { CanMatchFn, Router } from '@angular/router';
import { Authservice } from '../service/authservice';
import { inject } from '@angular/core';

export const adminGaurdGuard: CanMatchFn = (route, segments) => {
  const authService=inject(Authservice);
  const router=inject(Router);
  if(authService.IsAdmin()){
    return true;
  }
  router.createUrlTree(['/login']);
  return true;
};
