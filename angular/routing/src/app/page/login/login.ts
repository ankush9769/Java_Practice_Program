import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Authservice } from '../../service/authservice';

@Component({
  imports: [],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {
  authService=inject(Authservice);
  router=inject(Router);

  login(){
    this.authService.login();
    this.router.navigate(['/dashboard']);
  }

  loginAsAdmin(){
    this.authService.loginAsAdmin();
    this.router.navigate(['/admin'])
  }




}
