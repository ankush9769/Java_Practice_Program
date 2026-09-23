import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customroleconverison',
})
export class CustomroleconverisonPipe implements PipeTransform {
  transform(value: string): unknown {
    switch (value) {
      case 'admin':
        return 'Administrator';
      case 'user':
        return 'Userertrator';
      case 'guest':
        return 'Guest';
      default:
    return null;
  }
}
}
