import { Component, effect, signal } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-effects',
  styleUrl: './effects.css',
  templateUrl: './effects.html',
})
export class Effects {
   count = signal(0);
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
    this.count.set(0);
  }


  constructor() {
    effect(()=>{
      // console.log("signal updated",this.count())
      if(this.mode()){
         document.body.style.background="black";
      document.body.style.color="white";
      }else{
        document.body.style.background="white";
      document.body.style.color="black";
      }

      //temp message
      if(this.tempmessage()){
        setTimeout(()=>{
        this.tempmessage.set("");
      },2000)
      }
      

      
    })
  }


  // darkmode

  mode = signal<boolean>(true);
  modemethod(){
    this.mode.update(mode=>(mode=!mode));
  }


  //showing temp message
  tempmessage=signal<string>("");
  showtempmessage(){
    this.tempmessage.set("this is temp message");
  }


  
}
