import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Buyer } from '../buyer';
import { BuyerService } from '../buyer.service';
import { ProductService } from '../product.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Invoice } from '../invoice';
import { CartComponent } from '../cart/cart.component';
 

const packageType:string='Bag';


@Component({
  selector: 'app-add-invoice',
  templateUrl: './add-invoice.component.html',
  styleUrls: ['./add-invoice.component.css']
})
export class AddInvoiceComponent implements OnInit {

  products : Observable<Product[]>;
  buyers : Observable<Buyer[]>;
  buyer_id:number;
  order_date:Date;
  errors:boolean=false;
  cart:Invoice[];
  maxValue=0;
  divId:number;
  tax:number;

  cartComp = new CartComponent;
  

  constructor(private productService: ProductService, private buyerService: BuyerService,
    private router: Router,) { }

  ngOnInit(): void {
    this.reloadData();
    
  }

  
  reloadData(){
    this.products= this.productService.getProductList();
    this.buyers=this.buyerService.getBuyerList();
   // this.quantity=0;
    this.errors=false;
  }

  addItem(product_id:string,quantity:number,free_items:number,price:number){
      let invoice:Invoice;
      
      invoice.order_date=this.order_date;
      invoice.buyer_id=this.buyer_id;
      invoice.product_id=product_id;
      invoice.package_type=packageType;
      invoice.quantity=quantity;
      invoice.freepacks=free_items;
      invoice.amount=price*(quantity-free_items);
      invoice.tax= parseFloat((invoice.amount *(this.tax/100)).toFixed(2));
      invoice.selling_price=invoice.amount-invoice.tax;
      this.cart.push(invoice);
    }

  onSubmit(){
    this.cartComp.displayCart(this.cart,this.buyers,this.products);
  }

  errorCheck(free_items:number,quantity:number,divId:number){
    let err=free_items>quantity;
    if(err)
    {
      this.errors=true;
      this.divId=divId;
      console.log("inside if")
    }
    else{
      this.errors=false;
      this.divId=divId;
      console.log("inside else");
    }
  }
  
}
