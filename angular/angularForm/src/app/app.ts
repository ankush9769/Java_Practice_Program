import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Traditionalreactiveform } from './page/traditionalreactiveform/traditionalreactiveform';
import { Formwithsignal } from './page/formwithsignal/formwithsignal';

@Component({
  imports: [RouterOutlet,Traditionalreactiveform,Formwithsignal],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('angularForm');
}
