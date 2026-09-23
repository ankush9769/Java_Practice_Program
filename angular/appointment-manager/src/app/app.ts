import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Appoinment } from '../model/Appoinment';


@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('appointment-manager');
  description = signal('');
  date = signal('');
  appoinment = signal<Appoinment[]>([])

  ngOnInit(){
    const savedappoinment = localStorage.getItem('savedappoinment');
    if(savedappoinment){
      this.appoinment.set(JSON.parse(savedappoinment));
    }
  }    
  addappoinment(){
    if(this.description().trim() && this.date()){
      const newappoinment : Appoinment = {
        id : Date.now(),
        description : this.description(),
        date : this.date()
      }
      this.appoinment.update(currentappoinment =>[ ...currentappoinment,newappoinment]);

      this.saveappoinment();

      this.description.set('');

      this.date.set('');
    } 
  }

  deleteappoinment(id:number){
    this.appoinment.update(currentappoinment => currentappoinment.filter(
      singleappoinment => singleappoinment.id !== id
    ))
    this.saveappoinment();
  };
  saveappoinment(){
        localStorage.setItem(
          'savedappoinment',JSON.stringify(this.appoinment())
        )
  }
}
