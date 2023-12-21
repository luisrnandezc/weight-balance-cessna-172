// TODO: add general project description.

import java.util.ArrayList;
import java.util.Scanner;

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

        // TODO: read aircraft data for moments computation.
        AircraftData aircraftData = new AircraftData();
        //      Obtain aircraft model from the user (152 or 172N).
        //      Obtain B.E.W and moment.

        // TODO: read user payload data from text file.
        PayloadData userData = new PayloadData();
        //      Obtain filepath from the user.
        //      Check validity of the data.
        //      Store data in a suitable data structure.

        // TODO: compute C.G position.
        Cessna aircraft = new Cessna();
        //      Load the aircraft with the corresponding payload.
        //      compute moments and C.G location.
        //      Compare result with the C.G limits.

        // TODO: plot results and generate warnings if required.
    }
}