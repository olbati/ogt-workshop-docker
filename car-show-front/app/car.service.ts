import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Car } from './car';
import  {GlobalVariable} from './global'

@Injectable()
export class CarService {
  private CaresUrl = '/car';

  constructor(private http: Http) {
  }

  getCars(): Promise<Car[]> {
    let headers = new Headers({
      //'Content-Type': 'application/json'
    });
    return this.http
      .get(this.CaresUrl,{ headers: headers })
      .toPromise()
      .then(response => response.json() as Car[])
      .catch(this.handleError);
  }


  getCar(id: number): Promise<Car> {
    let headers = new Headers({
     // 'Content-Type': 'application/json'
    });
    return this.http
      .get(this.CaresUrl+'/'+id,{ headers: headers })
      .toPromise()
      .then(response => response.json() as Car)
      .catch(this.handleError);
  }




  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
