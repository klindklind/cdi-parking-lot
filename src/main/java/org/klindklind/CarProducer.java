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
    private Instance<IDriver> drivers;

    @Produces
    public List<Car> buildCarsForDrivers() {
        List<Car> cars = new ArrayList<Car>();
        Iterator<IDriver> driverIterator = drivers.iterator();
        IDriver driver;
        while (driverIterator.hasNext()) {
            driver = driverIterator.next();
            cars.add(new Car(driver, getEngineRoomBean()));
        }
        return cars;
    }

    private EngineRoom getEngineRoomBean() {
        return CDI.current().select(EngineRoom.class).get();
    }
}
