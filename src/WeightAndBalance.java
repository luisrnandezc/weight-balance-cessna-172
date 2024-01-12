// TODO: add general project description.

import java.util.*;

abstract class Aircraft {

    public String aircraftModel;
    public String seatsConfig;

    abstract void setSeatsConfig(String config);
    abstract int[] loadPayload();
}

class Cessna extends Aircraft {

    public void setSeatsConfig(String config) {
        seatsConfig = config;
    }

    public int[] loadPayload() {
        // TODO: Maybe a dictionary could work here.
        int[] onlyForTest = {1, 2, 3};
        return onlyForTest;
    }
}

public class WeightAndBalance {
    public static void main(String[] args) {

        AircraftData aircraftData = new AircraftData();
        HashMap<String, List<String[]>> requiredAircraftData = aircraftData.readFilesIntoHashMap();
        String model = aircraftData.selectAircraftModel();
        String seatsConfig = aircraftData.selectSeatingConfig();
        int basicEmptyWeight = aircraftData.selectBasicEmptyWeight();
        int basicEmptyWeightMoment = aircraftData.selectBasicEmptyWeightMoment();

        // TODO: user data must be validated.

        // TODO: compute C.G position.
        Cessna aircraft = new Cessna();
        //      Load the aircraft with the corresponding payload.
        //      compute moments and C.G location.
        //      Compare result with the C.G limits.

        // TODO: plot results and generate warnings if required.
    }
}