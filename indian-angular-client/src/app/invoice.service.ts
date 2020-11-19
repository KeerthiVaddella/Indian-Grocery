import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Invoice } from './invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private baseUrl = 'http://localhost:8181/invoice';
  constructor(private http: HttpClient) { }

  getInvoiceByNumber(invoice_num:string): Observable<any>{
      return this.http.get(this.baseUrl+'/invoiceByNumber/'+invoice_num);
  }

  addInvoice(invoice:Invoice[]): Observable<Object>{
    return this.http.put(this.baseUrl+'/addInvoiceEntry',invoice);
  } 

  getInvoiceByByer(buyer_id:number):Observable<any>{
    return this.http.get(this.baseUrl+'/getInvoiceByBuyer/'+buyer_id);
  }

}
