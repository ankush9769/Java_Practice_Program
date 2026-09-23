import { CanActivateFn, Router } from '@angular/router';
import { Authservice } from '../service/authservice';
import { inject } from '@angular/core';


export const coursesGuard: CanActivateFn = (route, state) => {
  const authService=inject(Authservice);
  const router=inject(Router);
  if(authService.isloggedIn()){
    return true;
  }
  return router.createUrlTree(['/']);
  return true;
};
