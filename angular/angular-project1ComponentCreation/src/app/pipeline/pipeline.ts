import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { CustompipePipe } from '../pipe/custompipe-pipe';
import { CustomroleconverisonPipe } from '../pipe/customroleconverison-pipe';
import { CustomfullnamesplitterPipe } from '../pipe/customfullnamesplitter-pipe';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [CommonModule,CustompipePipe,CustomroleconverisonPipe,CustomfullnamesplitterPipe,FormsModule],
  selector: 'app-pipeline',
  styleUrl: './pipeline.css',
  templateUrl: './pipeline.html',
})
export class Pipeline {
  upper = "ANKUSH";
  lower = "pal";

  price = 87;
  perc = 0.88;

  objects ={
    name:"ankush",
    age:67
  }

username='abcdef';
role='admin';

fullname = "ankush pal"


//two way binding
// username2='ankush';
username2=signal<string>('ankush');

}
