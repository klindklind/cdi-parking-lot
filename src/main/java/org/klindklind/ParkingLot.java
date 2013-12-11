package org.klindklind;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class ParkingLot {

    @Inject
    private List<Car> cars;

    @PostConstruct
    void checkCarsOnParkingLot() {
        System.out.println("Found " + cars.size() + " cars from parking lot:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
