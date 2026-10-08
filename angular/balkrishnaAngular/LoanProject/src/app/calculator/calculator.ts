import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-calculator',
  styleUrl: './calculator.scss',
  templateUrl: './calculator.html',
})
export class Calculator {
   first:any;
  second:any;
  operation:any;

  result:any;

  calc(){
    if(this.operation == '+'){
      this.result = (this.first+this.second);
    }else if(this.operation == '-'){
      this.result = (this.first - this.second); 
    }

  }
}
