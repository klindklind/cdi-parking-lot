package org.klindklind;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

public class CarProducer {

    @Inject
    @Any
    private Instance<ILicensePlate> licensePlates;

    @Produces
    public List<Car> buildCarForEveryLicensePlate() {
        List<Car> cars = new ArrayList<Car>();
        Iterator<ILicensePlate> licensePlateIterator = licensePlates.iterator();
        ILicensePlate licensePlate;
        while (licensePlateIterator.hasNext()) {
            licensePlate = licensePlateIterator.next();
            cars.add(new Car(licensePlate, getEngineRoomBean()));
        }
        return cars;
    }

    private EngineRoom getEngineRoomBean() {
        return CDI.current().select(EngineRoom.class).get();
    }
}
