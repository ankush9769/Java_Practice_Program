import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customfullnamesplitter',
})
export class CustomfullnamesplitterPipe implements PipeTransform {
  transform(value: string): string {
   const array = value.split(' ');
    const first = array[0].charAt(0).toUpperCase(); 
    const last = array[1].charAt(0).toUpperCase();  
    return `${first}.${last}`;
  }
}
