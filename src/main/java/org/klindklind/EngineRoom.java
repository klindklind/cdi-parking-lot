package org.klindklind;

import javax.inject.Inject;

public class EngineRoom {

    @Inject
    private Piston piston;

    @Inject
    private SparkPlug sparkPlug;

    public Piston getPiston() {
        return piston;
    }

    public SparkPlug getSparkPlug() {
        return sparkPlug;
    }
}
