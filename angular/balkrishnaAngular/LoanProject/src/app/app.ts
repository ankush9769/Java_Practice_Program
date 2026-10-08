import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { First } from './first/first';
import { Calculator } from './calculator/calculator';

@Component({
  imports: [RouterOutlet,First,RouterLink,Calculator],
  selector: 'app-root',
  styleUrl: './app.scss',
  templateUrl: './app.html',
})
export class App {
  
  protected readonly title = signal('LoanProject');

  

  
}
