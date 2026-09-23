import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'custompipe',
})
export class CustompipePipe implements PipeTransform {
  transform(value: string): unknown {
    return value.split('').reverse().join();
  }
}
