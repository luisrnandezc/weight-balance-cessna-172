// TODO: include Class docstring.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class AircraftWeightAndBalanceCalculator {

    protected HashMap<Integer, List<Float>>  armsData;
    protected List<String[]> payload;
    protected int seatsConfig;
    protected int emptyWeight;
    protected int emptyMoment;
}

public class CessnaCalculator extends AircraftWeightAndBalanceCalculator {

    public CessnaCalculator(HashMap<Integer, List<Float>>  arms, List<String[]> load,
                            int seats, int weight, int moment) {
        this.armsData = arms;
        this.payload = load;
        this.seatsConfig = seats;
        this.emptyWeight = weight;
        this.emptyMoment = moment;
    }

    private boolean validatePayloadFileSize() {
        return payload.size() == 8;
    }

    private boolean validatePayloadFileData() {
        for (String[] load : payload) {
            try {
                Integer.parseInt(load[0]);
            }
            catch (RuntimeException e) {
                return false;
            }
        }
        return true;
    }

    public boolean payloadDataIsValid() {
        if (!validatePayloadFileSize() || !validatePayloadFileData()) {
            System.out.print("Error: invalid payload data in payload.txt.\n");
            return false;
        }
        return true;
    }

    private int computeTotalWeight() {
        int totalWeight = emptyWeight;
        for (String[] load : payload) {
            totalWeight = totalWeight + Integer.parseInt(load[0]);
        }
        return totalWeight;
    }

    private double computeFuelMoment(double fuelArm) {
        double fuelLoaded = Double.parseDouble((payload.get(payload.size()-2))[0]);
        return fuelLoaded*fuelArm;
    }

    private double computePaxAndCargoMoments() {
        double weight;
        double arm;
        double paxAndCargoMoment = 0.0;
        List<Float> arms = armsData.get(seatsConfig);
        for (int i = 0; i < 4; i++) {
            weight = Double.parseDouble((payload.get(i))[0]);
            arm = arms.get(i);
            paxAndCargoMoment = paxAndCargoMoment + weight*arm;
        }
        return paxAndCargoMoment;
    }

    private double computeFuelConsumedMoment(double fuelArm) {
        double fuelConsumed = Double.parseDouble((payload.get(payload.size()-1))[0]);
        return fuelConsumed*fuelArm;
    }

    private double computeTotalMoment() {
        double fuelArm = 47.619;
        double basicMoment = emptyMoment*1000;
        double fuelMoment = computeFuelMoment(fuelArm);
        double paxAndCargoMoment = computePaxAndCargoMoments();
        double fuelConsumedMoment = computeFuelConsumedMoment(fuelArm);
        return basicMoment + fuelMoment + paxAndCargoMoment - fuelConsumedMoment;
    }

    public double computeCGLocation() {
        if (!payloadDataIsValid()) {
            System.exit(1);
        }
        double cglLocation = computeTotalMoment()/computeTotalWeight();
        return (double)((int)(cglLocation*100))/100.0;
    }
}

