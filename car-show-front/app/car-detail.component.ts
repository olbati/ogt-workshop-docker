import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

import { Car } from './car';
import { CarService } from './car.service';
import  {GlobalVariable} from './global'

@Component({
  moduleId: module.id,
  selector: 'my-car-detail',
  templateUrl: 'car-detail.component.html',
  styleUrls: ['car-detail.component.css']
})
export class CarDetailComponent implements OnInit {
  @Input() car: Car;
  @Output() close = new EventEmitter();
  error: any;
  navigated = false; 
   logoUrl: string  = "";

  constructor(
    private carService: CarService,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.forEach((params: Params) => {
      if (params['id'] !== undefined) {
        let id = +params['id'];
        this.navigated = true;
        this.carService.getCar(id)
            .then(car => {
            this.car = car ;
            this.logoUrl = "/car/logos/" +this.car.logo;
          })

      } else {
        this.navigated = false;
        this.car = new Car();
      }
    });
  }



  goBack(): void {
    if (this.navigated) { window.history.back(); }
  }
}
