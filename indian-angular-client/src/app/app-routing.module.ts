import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateProductComponent } from './create-product/create-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CreateBuyerComponent } from './create-buyer/create-buyer.component';
import { BuyerListComponent } from './buyer-list/buyer-list.component';
import { UpdateBuyerComponent } from './update-buyer/update-buyer.component';
import { AddInvoiceComponent } from './add-invoice/add-invoice.component';
import { CartComponent } from './cart/cart.component'


const routes: Routes = [
  {path: '', component:HomeComponentComponent},
  {path: 'products', component:ProductListComponent},
  {path: 'add', component: CreateProductComponent},
  {path: 'update/:id', component: UpdateProductComponent},
  {path: 'addBuyer', component: CreateBuyerComponent},
  {path: 'updateBuyer/:id', component: UpdateBuyerComponent},
  {path: 'buyersList', component:BuyerListComponent},
  {path: 'placeOrder', component:AddInvoiceComponent},
  {path: 'cart',component:CartComponent},
];



@NgModule({
    imports: [RouterModule.forRoot(routes),
    MatFormFieldModule,],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
