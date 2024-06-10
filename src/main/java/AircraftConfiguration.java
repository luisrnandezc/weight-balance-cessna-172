// TODO: include Class docstring.

import java.util.*;

public class AircraftConfiguration {

    private int setSeatsConfiguration() {
        Scanner scn = new Scanner(System.in);
        String seatsConfig;
        do {
            System.out.print("Specify the seating configuration. Type 1 for Standard OR 2 for Optional: ");
            seatsConfig = scn.nextLine();
            if (seatsConfig.equals("1") || seatsConfig.equals("2")) {
                return Integer.parseInt(seatsConfig);
            }
            else {
                System.out.print("Error: invalid seating configuration.\n");
            }
        } while(true);
    }

    private int setBasicEmptyWeight() {
        Scanner scn = new Scanner(System.in);
        int minWeight = 1397;
        int maxWeight = 2307;
        do {
            System.out.print("Basic Empty Weight in lbs: ");
            try {
                int userBasicEmptyWeight = Integer.parseInt(scn.nextLine());
                if (minWeight < userBasicEmptyWeight && userBasicEmptyWeight < maxWeight) {
                    return userBasicEmptyWeight;
                }
                else {
                    System.out.print("Error: Basic Empty Weight out of bounds.\n");
                }
            }
            catch(NumberFormatException e) {
                System.out.print("Error: invalid Basic Empty Weight.\n");
            }
        } while(true);
    }

    private int setBasicEmptyWeightMoment() {
        Scanner scn = new Scanner(System.in);
        int minMoment = 51;
        int maxMoment = 70;
        do {
            System.out.print("Basic Empty Weight Moment in lbs-in (/1000): ");
            try {
                int userBasicEmptyWeightMoment = Integer.parseInt(scn.nextLine());
                if (minMoment < userBasicEmptyWeightMoment && userBasicEmptyWeightMoment < maxMoment) {
                    return userBasicEmptyWeightMoment;
                }
                else {
                    System.out.print("Error: Basic Empty Weight Moment out of bounds.\n");
                }
            }
            catch(NumberFormatException e) {
                System.out.print("Error: invalid Basic Empty Weight Moment.\n");
            }
        } while(true);
    }

    public HashMap<String, Integer> setAircraftConfiguration() {
        HashMap<String, Integer> aircraftConfiguration = new HashMap<>();
        aircraftConfiguration.put("seatsConfig", setSeatsConfiguration());
        aircraftConfiguration.put("emptyWeight", setBasicEmptyWeight());
        aircraftConfiguration.put("emptyMoment", setBasicEmptyWeightMoment());
        return aircraftConfiguration;
    }
}