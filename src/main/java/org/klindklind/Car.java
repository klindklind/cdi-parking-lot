package org.klindklind;

public class Car {

    private IDriver driver;

    private EngineRoom engineRoom;

    public Car(IDriver driver, EngineRoom engineRoom) {
        this.driver = driver;
        this.engineRoom = engineRoom;
    }

    public IDriver getDriver() {
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
