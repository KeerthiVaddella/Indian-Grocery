import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Buyer } from '../buyer';
import { BuyerService } from '../buyer.service';

@Component({
  selector: 'app-buyer-list',
  templateUrl: './buyer-list.component.html',
  styleUrls: ['./buyer-list.component.css']
})
export class BuyerListComponent implements OnInit {

  buyers : Observable<Buyer[]>;
  show :boolean=false;

  constructor(private buyerService: BuyerService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.buyers= this.buyerService.getBuyerList();
  }
  
  deleteBuyer(id: string){
    this.buyerService.deleteBuyer(id)
      .subscribe(
        data =>{
          console.log(data);
          this.reloadData();
        },
        error=> console.log(error));
  }

  updateBuyer(id: string){
  this.router.navigate(['/updateBuyer/'+id]);    
  }

  getPrevOrders(id: string){
    this.router.navigate(['/previousOrders'+id]);
  }
}
