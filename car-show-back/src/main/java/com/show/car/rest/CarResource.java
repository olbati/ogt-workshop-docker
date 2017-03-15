package com.show.car.rest;

import com.show.car.domain.Car;
import com.show.car.dto.CarDto;
import com.show.car.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mmarzougui on 23/02/2017.
 */
@RequestMapping("/car")
@RestController
public class CarResource {

    private static Logger logger = LoggerFactory.getLogger(CarResource.class) ;

    @Autowired
    private CarService carService ;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarList() {

        logger.info("request get car list ");
        List<CarDto> cars =  carService.getCars();
        return  ResponseEntity.ok(cars);
    }

    @RequestMapping(value = "/{carId:.+}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarDetail(@PathVariable("carId") long carId) throws  Exception{

        logger.info("request get car detail with id :'{}' ",carId);
        Car car =  carService.getCarDetail(carId);
        return  ResponseEntity.ok(car);
    }
}
