import { Component, OnInit } from '@angular/core';
import { Invoice } from '../invoice';
import { Product } from '../product';
import { Buyer } from '../buyer';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  show=false;
  invoices:Invoice[];
  products : Observable<Product[]>;
  buyers : Observable<Buyer[]>;

  displayCart(cart: Invoice[], buyers: Observable<Buyer[]>, products: Observable<Product[]>) {
    this.show=true;
    this.invoices=cart;
    this.buyers=buyers;
    this.products=products;
  }

  constructor() { }

  ngOnInit(): void {
    
  }

  updateCart(){
    this.show=false;
  }

}
