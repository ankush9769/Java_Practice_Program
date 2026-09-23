import { Component, input, output } from '@angular/core';
import { Employee } from '../model/Employee';

@Component({
  imports: [],
  selector: 'app-employee-list',
  styleUrl: './employee-list.css',
  templateUrl: './employee-list.html',
})
export class EmployeeList {
  employees = input.required<Employee[]>();


  deleterequest = output<number>();
  delete(id:number){
    this.deleterequest.emit(id);
  }
}
