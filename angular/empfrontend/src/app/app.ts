import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeList } from './employee-list/employee-list';
import { Employee } from './model/Employee';
import { EmployeeService } from './services/employee-service';
import { EmployeeForm } from './employee-form/employee-form';

@Component({
  imports: [RouterOutlet,EmployeeList,EmployeeForm],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  private employeeService = inject(EmployeeService);

  employees = signal<Employee[]>([]);

  ngOnInit() {
    this.loadEmployees();
  }

  loadEmployees(){
    this.employeeService.getEmployees().subscribe(data =>{
      this.employees.set(data);
    })
  }

  onEmployeeAdded(employee:Employee){
    this.employees.update(list =>[
      ...list,
      employee
    ]);
  }

  onDeleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(()=>{
      this.employees.update(list => list.filter(emp => emp.id !== id))
    });
  }

}
