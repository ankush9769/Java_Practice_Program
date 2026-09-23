import { Component, signal } from '@angular/core';
import { Product, ProductCart } from '../product-cart/product-cart';

@Component({
  imports: [ProductCart],
  selector: 'app-product-list',
  styleUrl: './product-list.css',
  templateUrl: './product-list.html',
})
export class ProductList {
  product = signal<Product>({id:101,name:"pen",price:10});


}
