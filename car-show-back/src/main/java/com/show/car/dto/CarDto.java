package com.show.car.dto;

import com.show.car.domain.Car;

/**
 * Created by mmarzougui on 23/02/2017.
 */
public class CarDto {

    private long id ;

    private String name ;

    private String logo;

    public CarDto() {
    }

    public CarDto(Car car) {
        this.logo = car.getLogo();
        this.name = car.getName();
        this.id = car.getId() ;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
