import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Employee } from '../model/Employee';

@Service()
export class EmployeeService {
    private http = inject(HttpClient);
    private baseUrl = 'http://localhost:8080/employee';

    getEmployees():Observable<Employee[]> {
        return this.http.get<Employee[]>(this.baseUrl);
    }   

    addEmployee(employee : Employee):Observable<Employee>{
        return this.http.post<Employee>(this.baseUrl,employee)
    }

    deleteEmployee(id:number):Observable<void>{
        return this.http.delete<void>(`${this.baseUrl}/${id}`);
    }
}
