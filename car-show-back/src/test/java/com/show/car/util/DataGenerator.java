package com.show.car.util;

import com.show.car.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;

/**
 * Created by mmarzougui on 08/03/2017.
 */
@Component
public class DataGenerator {

    public Car createCar() {
        Car car = new Car();
        car.setName("car for test");
        car.setMiles(17);
        car.setCylinders(7);
        car.setDisplacement(200);
        car.setHorsepower(120);
        car.setWeight(4000);
        car.setAcceleration(22);
        car.setYear(1980);
        car.setOrigin("USA");
        car.setLogo("logo.png");
        return car;
    }
}
