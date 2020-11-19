import { Component, OnInit } from '@angular/core';
import { Buyer } from '../buyer';
import { BuyerService } from '../buyer.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-buyer',
  templateUrl: './create-buyer.component.html',
  styleUrls: ['./create-buyer.component.css']
})
export class CreateBuyerComponent implements OnInit {

  buyer : Buyer =  new Buyer;
  submited=false;

  constructor(private buyerService: BuyerService,
    private router: Router) { }

  ngOnInit(): void {
  }

  newBuyer(): void {
    this.submited= false;
    this.buyer= new Buyer();
  }

  save() {
    this.buyerService
      .createBuyer(this.buyer).subscribe(data =>{
        console.log(data)
        this.buyer = new Buyer();
        this.gotoList();
      },
      error=> console.log(error)
      );  
    }

    onSubmit() {
      this.submited=true;
      this.save();
    }
  
    gotoList() {
      this.router.navigate(['/buyersList'])
    }
  
      
}
