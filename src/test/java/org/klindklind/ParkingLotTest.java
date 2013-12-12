package org.klindklind;

import static org.junit.Assert.*;

import java.util.List;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;

@RunWith(CdiRunner.class)
@AdditionalClasses({ FirstLicensePlate.class, SecondLisencePlate.class, EngineRoom.class })
public class ParkingLotTest {

    // Producers must be injected into test in order to use produced beans
    @Inject
    CarProducer carProducer;

    @Inject
    @Any
    private Instance<ILicensePlate> licensePlates;

    @Inject
    ParkingLot parkingLot;

    @Test
    public void parkingLotShouldContainCorrectAmountOfCarsWithUniqueEngineRooms() throws Exception {
        List<Car> cars = parkingLot.getCars();

        assertEquals("Parking lot should contain be one car per license plate.", Lists.newArrayList(licensePlates.iterator()).size(), cars.size());
        assertNotSame("Cars should not share same engine room.", cars.get(0).getEngineRoom(), cars.get(1).getEngineRoom());
        assertNotSame("Engine rooms should not share same piston.", cars.get(0).getEngineRoom().getPiston(), cars.get(1).getEngineRoom().getPiston());
        assertNotSame("Engine rooms should not share same spark plugs.", cars.get(0).getEngineRoom().getSparkPlug(), cars.get(1).getEngineRoom()
                .getSparkPlug());
    }

}
