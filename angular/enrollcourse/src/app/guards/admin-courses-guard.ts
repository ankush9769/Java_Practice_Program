import { CanMatchFn, Router } from '@angular/router';
import { Authservice } from '../service/authservice';
import { inject } from '@angular/core';

export const adminCoursesGuard: CanMatchFn = (route, segments) => {
  const authService=inject(Authservice);
  const router=inject(Router);
  if(authService.IsAdmin()){
    return true;
  }
  router.createUrlTree(['/']);
  return true;
};
