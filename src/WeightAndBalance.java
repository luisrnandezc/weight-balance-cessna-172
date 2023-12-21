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

class DataReader {};

class UserDataReader {};

class UserDataValidation {};

class ResultsPlotter {};

public class WeightAndBalance {
    public static void main(String[] args) {

        // TODO: read aircraft data for moments computation.

        // TODO: read user case data from text file.
        //      The text file should specify seating configuration,
        //      BEW information, fuel tanks capacity, total payload,
        //      and fuel consumed by starting, run-up and taxi.

        // TODO: Checks validity of user case data.

        // Initialization of the aircraft object.
        Cessna aircraft = new Cessna();

        // TODO: load the the aircraft with the corresponding payload.

        // TODO: compute moments and C.G location.

        // TODO: plot results and generate warnings if required.
    }
}