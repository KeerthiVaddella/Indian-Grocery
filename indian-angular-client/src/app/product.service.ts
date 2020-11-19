import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8181/product';
  constructor(private http: HttpClient) { }

  getProductList(): Observable<any>{
    console.log(this.baseUrl+'/allProducts');
      return this.http.get(this.baseUrl+'/allProducts');
  }

  updateProduct(id:string, value: any): Observable<Object>{
    return this.http.put(this.baseUrl+'/updateProduct/'+id,value);
  } 

  createProduct(product: Object): Observable<Object>{
    return this.http.post(this.baseUrl+'/addProduct',product);
  }

  deleteProduct(id:string): Observable<any>{
    return this.http.delete(this.baseUrl+'/deleteProduct/'+id,{responseType:'text'});
  }

  getProduct(id:string): Observable<any>{
    console.log(id);
    return this.http.get(this.baseUrl+'/getProductName/'+id);
  }
}
