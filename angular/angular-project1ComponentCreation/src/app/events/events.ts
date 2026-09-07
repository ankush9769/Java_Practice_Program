import { Component, computed, signal } from '@angular/core';

interface users{
  id:number,
  name:string,
  age:number
}

@Component({
  imports: [],
  selector: 'app-events',
  styleUrl: './events.css',
  templateUrl: './events.html',
})
export class Events {
  // count = 0;
  count = signal(0);
  username ="";
  useremail ="";

  increment() {
    // this.count++;
    this.count.update(c => c+1);
  }
  decrement(){
    // this.count--;
    this.count.update(c => c-1);

  }
  reset(){
    // this.count=0;
    this.count.set(0);
  }

  

  updateusername(value:string){
    this.username = value;
  }

  updateEmail(email:string){
    this.useremail = email;
  }

  isloggedIn=false;
  marks = 80;

  showmessage = true;
  toggel(){
    if(this.showmessage){
      this.showmessage = false;
    }
    else{
      this.showmessage = true;
    }
  }

  mode = true;
  modemethod(){
    if(this.mode){
      this.mode=false;
      document.body.style.background="black";
      document.body.style.color="white";
    }else{
      this.mode=true;
      document.body.style.background="white";
      document.body.style.color="black";

    }
  }



  age:number=0;


  items =["apple","banana","guavava","lichi"];
  objects = [{name:"ankush",age:20},
    {name:"shreya",age:30},
    {name:"ketan",age:40},
    {name:"chetan",age:50}
  ]

  remove(index:any){
    this.objects.splice(index,1)
  }


  numbers=[1,2,3,4,5,6,7];


  companyname = signal<string>('masstech');
  switchcompany(){
    this.companyname.set('ElitNex');
  }


  // users = signal<{id:number,name:string,age:number}>({id:19,name:"ankush",age:21});
  users = signal<users>({id:19,name:"ankush",age:21});  // instread of <{id:number,name:string,age:number}> using interface
  setobject(){
    this.users.set({id:101,name:"varron",age:20});
  }

  numbers2 = signal<number[]>([1,2,3,4,5,6,7]);
  addelement(num:number){
    this.numbers2.update(n=>[...n,num]);
  }
  setarray(){
    this.numbers2.set([10,20,30,40,50])
  }


  counts = signal<number>(10);
  double = computed<number>(()=>this.counts()*2);
  triple = computed<number>(()=>this.counts()*3);
  increments(){
    this.counts.update(n=>n+1);
  }
}
