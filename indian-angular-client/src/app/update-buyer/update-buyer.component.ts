import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Buyer } from '../buyer';
import { BuyerService } from '../buyer.service';

@Component({
  selector: 'app-update-buyer',
  templateUrl: './update-buyer.component.html',
  styleUrls: ['./update-buyer.component.css']
})
export class UpdateBuyerComponent implements OnInit {
  id: string;
  buyer: Buyer;

  constructor(private route: ActivatedRoute, private router: Router,
    private buyerService: BuyerService) { }

  ngOnInit() {
    this.buyer= new Buyer();

    this.id= this.route.snapshot.params['id'];

    this.buyerService.getBuyer(this.id)
      .subscribe(data => {
        console.log(data);
        this.buyer=data;
      },
      error=> console.log(error)
      );
  }

  updateBuyer() {
    this.buyerService.updateBuyer(this.id, this.buyer)
      .subscribe( data=> {
        console.log(data);
        this.buyer = new Buyer();
        this.gotoList();
      },error=> console.log(error)
      );
  }

  onSubmit() {
    this.updateBuyer();
  }

  gotoList(){
    this.router.navigate(['/buyersList']);
  }

}
