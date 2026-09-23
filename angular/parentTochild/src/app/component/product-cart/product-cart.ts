import { Component,input } from '@angular/core';
 
export interface Product{
  id:number;
  name:string;
  price:number;
}

@Component({
  imports: [],
  selector: 'app-product-cart',
  styleUrl: './product-cart.css',
  templateUrl: './product-cart.html',
})
 
export class ProductCart {
  product = input.required<Product>();

}
