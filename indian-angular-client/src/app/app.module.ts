import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { CarouselComponent } from './carousel/carousel.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponentComponent } from './home-component/home-component.component';
import { BuyerComponent } from './buyer/buyer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreateBuyerComponent } from './create-buyer/create-buyer.component';
import { BuyerListComponent } from './buyer-list/buyer-list.component';
import { UpdateBuyerComponent } from './update-buyer/update-buyer.component';
import { PreviousOrdersComponent } from './previous-orders/previous-orders.component';
import { AddInvoiceComponent } from './add-invoice/add-invoice.component';
import { GenerateInvoiceComponent } from './generate-invoice/generate-invoice.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { CartComponent } from './cart/cart.component';
import { MatSelectModule } from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    CreateProductComponent,
    ProductListComponent,
    UpdateProductComponent,
    CarouselComponent,
    HomeComponentComponent,
    BuyerComponent,
    CreateBuyerComponent,
    BuyerListComponent,
    UpdateBuyerComponent,
    PreviousOrdersComponent,
    AddInvoiceComponent,
    GenerateInvoiceComponent,
    EditOrderComponent,
    CartComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSelectModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
