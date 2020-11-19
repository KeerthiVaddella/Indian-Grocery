import { Component, OnInit } from '@angular/core';
//import { ProductDetailsComponent } from ',,/product-details/product-details.component';
import { Observable } from 'rxjs';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { Router } from '@angular/router';
//import { UpdateProductComponent} from '../update-product/update-product.component';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : Observable<Product[]>;
  show :boolean=false;
  

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
    
  }

  reloadData(){
    this.products= this.productService.getProductList();
  }

  deleteProduct(id: string){
      this.productService.deleteProduct(id)
        .subscribe(
          data =>{
            console.log(data);
            this.reloadData();
          },
          error=> console.log(error));
  }

  updateProduct(id: string){
    this.router.navigate(['/update/'+id])    
  }

}
