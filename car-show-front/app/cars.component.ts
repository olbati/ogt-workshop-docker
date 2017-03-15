import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Car } from './car';
import { CarService } from './car.service';


@Component({
  moduleId: module.id,
  selector: 'my-cars',
  templateUrl: 'cars.component.html',
  styleUrls: ['cars.component.css']
})
export class CarsComponent implements OnInit {
  cars: Car[];
  selectedCar: Car;
  addingCar = false;
  error: any;
  showNgFor = false;

  constructor(
    private router: Router,
    private carService: CarService) { }

  getCars(): void {
    this.carService
      .getCars()
      .then(cars => this.cars = cars)
      .catch(error => this.error = error);
  }

  addCar(): void {
    this.addingCar = true;
    this.selectedCar = null;
  }

  close(savedCar: Car): void {
    this.addingCar = false;
    if (savedCar) { this.getCars(); }
  }



  ngOnInit(): void {
    this.getCars();
  }

  onSelect(car: Car): void {
    this.selectedCar = car;
    this.addingCar = false;
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedCar.id]);
  }
}
