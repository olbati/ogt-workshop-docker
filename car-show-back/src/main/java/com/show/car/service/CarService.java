package com.show.car.service;

import com.show.car.domain.Car;
import com.show.car.dto.CarDto;
import com.show.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mmarzougui on 23/02/2017.
 */
@Service
public class CarService {

   @Autowired
   private CarRepository  carRepository ;

    public List<CarDto> getCars() {

         return  carRepository.findAll().stream().map(car -> new CarDto(car)).collect(Collectors.toList());
    }

    public Car getCarDetail(Long id) throws  Exception {

        return  carRepository.findOneById(id)
                .map(car -> car)
                .orElseThrow(()-> new Exception("No car with id : "+id+" has been found"));

    }
}
