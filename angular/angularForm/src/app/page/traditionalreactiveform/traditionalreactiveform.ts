import { Component, inject } from '@angular/core';
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from '@angular/forms';
import { email } from '@angular/forms/signals';


@Component({
  imports: [ReactiveFormsModule],
  selector: 'app-traditionalreactiveform',
  styleUrl: './traditionalreactiveform.css',
  templateUrl: './traditionalreactiveform.html',
})
export class Traditionalreactiveform {
  fb=inject(FormBuilder);
  studentForm=this.fb.group({
    name:[
      '',
      [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(20)
      ]
    ],

    email:[
      '',
      [
        Validators.required,
        Validators.email
      ]
    ],

    password:[
      '',
      [
        Validators.required,
        Validators.minLength(6)
      ]
    ]

  })
}
