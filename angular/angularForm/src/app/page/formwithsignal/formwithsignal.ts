import { Component, signal } from '@angular/core';
import { Student } from '../../model/Student';
import {form,FormField,required,email,minLength,maxLength,pattern,submit} from '@angular/forms/signals';
import { CommonModule } from '@angular/common';

@Component({
  imports: [FormField,CommonModule],
  selector: 'app-formwithsignal',
  styleUrl: './formwithsignal.css',
  templateUrl: './formwithsignal.html',
})
export class Formwithsignal {
  studentModel = signal<Student>({name:'',email:'',password:'',age:null});

  studentForm = form(this.studentModel,
    (path)=>{
      required(path.name,{
        message:'Name is required'
      });

      minLength(path.name,3,{
        message:'Minimum 3 character required'
      });

      maxLength(path.name,20,{
        message:'Maximum 20 character allowed'
      });

      pattern(
        path.name,
        /^[A-Za-z ]+$/,
        {
          message:'only letters adn spaces are allowed'
        }
      );
      required(path.email,{
        message:'Email is required'
      });
      email(path.email,{
        message:'enter a valid email'
      });
      required(path.password,{
        message:'password is required'
      })

      minLength(path.password,6,{
        message:'Password must contains at least 6 characters'
      });

      required(path.age,{
        message:'age is required'
      });
    }
  );

  onSubmit(event: Event){
    event.preventDefault();
    console.log(
      'student registered',
      this.studentModel()
    )
  }


}
