import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuyerService {

  private baseUrl = 'http://localhost:8181/buyer';
  constructor(private http: HttpClient) { }

  getBuyerList(): Observable<any>{
    console.log(this.baseUrl+'/allBuyers');
      return this.http.get(this.baseUrl+'/allBuyers');
  }

  updateBuyer(id:string, value: any): Observable<Object>{
    return this.http.put(this.baseUrl+'/updateBuyer',value);
  } 

  createBuyer(buyer: Object): Observable<Object>{
    return this.http.post(this.baseUrl+'/addBuyer',buyer);
  }

  deleteBuyer(id:string): Observable<any>{
    return this.http.delete(this.baseUrl+'/deleteBuyer/'+id,{responseType:'text'});
  }

  getBuyer(id:string): Observable<any>{
    console.log(id);
    return this.http.get(this.baseUrl+'/getBuyerName/'+id);
  }
}
