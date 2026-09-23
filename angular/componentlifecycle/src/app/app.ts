import { AfterViewInit, Component, OnDestroy, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App implements OnInit,AfterViewInit,OnDestroy  {
  protected readonly title = signal('componentlifecycle');

  //construcore() runs first when angular creates the component object
  constructor() {
    console.log('constructor() called');
  } 

  //constructore = typescript/javascript object craetion
  //NG on init Angular component initialization 
  ngOnInit(){
    console.log('ngOnInit() called');
  }

  //this hook execute whenever angular performs change detection for this component.
  ngDoCheck(){
    console.log("ngDoCheck() called");
  }

  //this means the component template is now initialized.Runs only once for that
  //component
  ngAfterViewInit(){
    console.log("ngAfterViewInit() called");
  }

  //`ngDoCheck()` and `ngAfterCheck()` are called multiple times during a component. 
  //Lifecycle whenever Angular performs 
  //Change detection and checks the component's view for changes. These hooks 
  //Allow you to respond to changes 
  //In the components state our view 
  ngAfterViewChecked(){
    console.log("ngAfterViewChecked() called");
  }

  ngOnDestroy(){
      console.log("ngOnDestroy() called");
  }

  changeTitle(){
    this.title.set('Title changed!')
  }
}
