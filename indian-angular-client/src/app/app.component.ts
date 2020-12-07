import { Component } from '@angular/core';
import {  ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent{
 
  title = 'indian-angular-client';

  constructor( private route:ActivatedRoute,){
   
  }

  ngOnInit(){
    this.route.queryParamMap.subscribe();
  }

}
