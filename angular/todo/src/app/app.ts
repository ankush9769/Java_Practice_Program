import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { single } from 'rxjs';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('todo');
  todo = signal('');
  todos = signal<{text:string;done:boolean}[]>([]);

  addtodo(){
    const text = this.todo().trim();
    if(text===""){
      return;
    }
    this.todos.update(list=>[...list,{text,done:false}])
    this.todo.set('');
  }

  toggletodo(index:number){
    this.todos.update(list=>
      list.map((item,i)=>
        i===index?{...item,done: !item.done}:item
      )
    )
  }

  deletetodo(index:number){
    this.todos.update(list=>
      list.filter((_,i)=>i!==index)
    )
  }

}
