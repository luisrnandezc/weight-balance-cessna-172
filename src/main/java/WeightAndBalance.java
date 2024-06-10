// TODO: add project description.

import java.util.*;

public class WeightAndBalance {
    public static void main(String[] args) {
        WeightAndBalance balance = new WeightAndBalance();
        System.out.println(balance.ComputeCenterOfGravityLocation());
    }

    private HashMap<String, HashMap<Integer, List<Float>>> setBasicAircraftData() {
        BasicAircraftData data = new BasicAircraftData();
        return data.loadBasicAircraftData();
    }

    private List<String[]> setAircraftPayload() {
        PayloadReader payload = new PayloadReader();
        return payload.readPayloadFile();
    }

    private HashMap<String, Integer> setAircraftSpecificConfiguration() {
        AircraftConfiguration aircraftConfig = new AircraftConfiguration();
        return aircraftConfig.setAircraftConfiguration();
    }

    private double ComputeCenterOfGravityLocation() {
        HashMap<Integer, List<Float>> armsData = setBasicAircraftData().get("armsData");
        List<String[]> payload = setAircraftPayload();
        HashMap<String, Integer> aircraftConfig = setAircraftSpecificConfiguration();
        int seatsConfig = aircraftConfig.get("seatsConfig");
        int emptyWeight = aircraftConfig.get("emptyWeight");
        int emptyMoment = aircraftConfig.get("emptyMoment");
        CessnaCalculator calculator = new CessnaCalculator(armsData, payload, seatsConfig, emptyWeight, emptyMoment);
        return calculator.computeCGLocation();
    }
}

