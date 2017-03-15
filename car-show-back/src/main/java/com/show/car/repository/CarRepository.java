package com.show.car.repository;

import com.show.car.domain.Car;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Created by mmarzougui on 23/02/2017.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findOneById(long id) ;
}
