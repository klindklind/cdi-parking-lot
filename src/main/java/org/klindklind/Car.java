package org.klindklind;

public class Car {

    private ILicensePlate driver;

    private EngineRoom engineRoom;

    public Car(ILicensePlate driver, EngineRoom engineRoom) {
        this.driver = driver;
        this.engineRoom = engineRoom;
    }

    public ILicensePlate getDriver() {
        return driver;
    }

    public EngineRoom getEngineRoom() {
        return engineRoom;
    }

    @Override
    public String toString() {
        return "Car [driver=" + driver + ", engineRoom=" + engineRoom + "]";
    }

}
