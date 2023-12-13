// TODO: add general project description.

import java.util.ArrayList;

abstract class Aircraft {

    public String seatsConfig;

    abstract void setSeatsConfig(String config);
    abstract int[] loadAircraft();
}

class Cessna172 extends Aircraft {

    public void setSeatsConfig(String config) {
        seatsConfig = config;
    }

    public int[] loadAircraft() {
        int[] onlyForTest = {1, 2, 3};
        return onlyForTest;
    }
}

class Cessna152 extends Aircraft {

    public void setSeatsConfig(String config) {
        seatsConfig = config;
    }

    public int[] loadAircraft() {
        int[] onlyForTest = {1, 2, 3};
        return onlyForTest;
    }
}

public class WeightAndBalance {
    public static void main(String[] args) {
        // TODO: read aircraft data for moments computation.

        // TODO: read user case data from text file.
        //      The text file should specify seating configuration,
        //      BEW information, fuel tanks capacity, total payload,
        //      and fuel consumed by starting, run-up and taxi.

        // TODO: load the the aircraft with the corresponding payload.

        // TODO: compute moments and C.G location.

        // TODO: plot results and generate warnings if required.
    }
}