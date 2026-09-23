import { Component, signal } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-edit-profile',
  styleUrl: './edit-profile.css',
  templateUrl: './edit-profile.html',
})
export class EditProfile {
   name = signal('');
  unsavedchanges = signal(false);

  updatedName(val:string){
    this.name.set(val);
    this.unsavedchanges.set(true);
  }

  save(){
    alert("changes saved successfully");
    this.unsavedchanges.set(false);
    this.name.set('');
  }
}
