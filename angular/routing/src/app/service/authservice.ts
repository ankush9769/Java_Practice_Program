import { Service, signal } from '@angular/core';
import { single } from 'rxjs';

@Service()
export class Authservice {

    isloggedIn=signal(false);

    login(){
        this.isloggedIn.set(true);
    }
    logout(){
        this.isloggedIn.set(false);
        this.IsAdmin.set(false);
    }




    IsAdmin = signal(false);
    loginAsAdmin(){
        this.IsAdmin.set(true);
        this.isloggedIn.set(true);
    }


}
