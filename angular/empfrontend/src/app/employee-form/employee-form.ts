import { Component, inject, output } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmployeeService } from '../services/employee-service';
import { Employee } from '../model/Employee';

@Component({
  imports: [ReactiveFormsModule],
  selector: 'app-employee-form',
  styleUrl: './employee-form.css',
  templateUrl: './employee-form.html',
})
export class EmployeeForm {
  private fb = inject(FormBuilder);
  private employeeService = inject(EmployeeService);

  employeeadded = output<Employee>();

  employeeForm = this.fb.group({
    name: ['',
      [
        Validators.required,
        Validators.minLength(3)
      ]
    ],
    email: ['',
      [
        Validators.required,
        Validators.email
      ]
    ],
    dept: ['',
      [
        Validators.required
      ]
    ]
  });

  onSubmit(){
    if(this.employeeForm.invalid){
      return;
    }
    const employee : Employee = {
      name:this.employeeForm.value.name!,
      email:this.employeeForm.value.email!,
      dept:this.employeeForm.value.dept!
    }

    this.employeeService.addEmployee(employee)
    .subscribe(savedEmployee =>{
      this.employeeadded.emit(
        savedEmployee
      );
      this.employeeForm.reset();
    })
  }
}
