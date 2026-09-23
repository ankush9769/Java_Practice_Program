import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Register } from './register/register';
// import { Events } from './events/events';
import { Effects } from './effects/effects';
import { Pipeline } from './pipeline/pipeline';
import { CustompipePipe } from './pipe/custompipe-pipe';

@Component({
  imports: [RouterOutlet,Register,Effects,Pipeline,CustompipePipe],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('angular-project1ComponentCreation');

  username = 'ankushpal'
  email = 'ankush@gmail.com'
  count = 0
  isadmin = true


  getuser(){
    return this.username
  }
}
