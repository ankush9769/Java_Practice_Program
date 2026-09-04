import { Component, signal } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-events',
  styleUrl: './events.css',
  templateUrl: './events.html',
})
export class Events {
  // count = 0;
  count = signal(0);
  username ="";

  increment() {
    // this.count++;
    this.count.update(c => c+1);
  }
  decrement(){
    // this.count--;
    this.count.update(c => c-1);

  }
  reset(){
    // this.count=0;
    this.count.update(c => 0);
  }

  

  updateusername(value:string){
    this.username = value;
  }
}
