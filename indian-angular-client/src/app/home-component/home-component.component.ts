import { Component } from '@angular/core';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrls: ['./home-component.component.css']
})
export class HomeComponentComponent  {
  public slides=[
    {src: "./assets/img1.jpg"},
    {src: "./assets/img2.jpg"},
    {src: "./assets/img3.jpg"},
    {src: "./assets/img4.jpg"},
    {src: "./assets/img5.jpg"}
  ]

  constructor() { }

 

}
