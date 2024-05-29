// TODO: include Class docstring.

import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import com.opencsv.*;

import static java.lang.Integer.parseInt;

public class AircraftData {

    public HashMap<String, List<String[]>> readFilesIntoHashMap() {
        String path = scanDataFolderPath();
        List<String> fileNames = readDataFilenames(path);
        HashMap<String, List<String[]>> aircraftData = new HashMap<>();
        for (String fileName : fileNames) {
            CSVReader csvReader = initializeCSVReader(path + "\\" + fileName);
            List<String[]> csvData = readCSVFile(csvReader);
            aircraftData.put(fileName, csvData);
        }
        return aircraftData;
    }

    private List<String> readDataFilenames(String path) {
        List<String> fileNames = new ArrayList<>();
        File folder = new File(path);
        for (File fileEntry : folder.listFiles()) {
            String[] ext = {".txt", ".csv"};
            if (checkIfFileHasExtension(fileEntry.getName(), ext)) {
                fileNames.add(fileEntry.getName());
            }
        }
        return fileNames;
    }

    public static boolean checkIfFileHasExtension(String filename, String[] ext) {
        return Arrays.stream(ext).anyMatch(filename::endsWith);
    }

    public String scanDataFolderPath() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the path for the Data folder: ");
        return scn.next();
    }

    public CSVReader initializeCSVReader(String filename) {
        try {
            FileReader filereader = new FileReader(filename);
            CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
            return new CSVReaderBuilder(filereader).withCSVParser(csvParser).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> readCSVFile(CSVReader csvReader) {
        List<String[]> csvData = new ArrayList<>();
        try {
            csvData = csvReader.readAll();
            return csvData;
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return csvData;
    }

    public String selectAircraftModel() {
        Scanner scn = new Scanner(System.in);
        List<String> validModels = Arrays.asList("152", "172", "172N");
        boolean validAircraftModel = false;
        String userModel;
        do {
            System.out.print("Specify the aircraft model (152 / 172N): ");
            userModel = scn.nextLine().toUpperCase();
            if (validModels.contains(userModel)) {
                validAircraftModel = true;
            }
            else {
                System.out.print("Error: invalid aircraft model.");
            }
        } while (!validAircraftModel);

        return userModel;
    }

    public String selectSeatingConfig() {
        Scanner scn = new Scanner(System.in);
        boolean validSeatConfig = false;
        String userSeatConfig;
        do {
            System.out.print("Seating Configuration. Write 1 for Standard OR 2 for Optional: ");
            userSeatConfig = scn.nextLine();
            if (userSeatConfig.equals("1") || userSeatConfig.equals("2")) {
                validSeatConfig = true;
            }
            else {
                System.out.print("Error: invalid seating configuration.");
            }
        } while(!validSeatConfig);

        return userSeatConfig;
    }

    public int selectBasicEmptyWeight() {
        Scanner scn = new Scanner(System.in);
        boolean validBasicEmptyWeight = false;
        String userBasicEmptyWeight;
        do {
            System.out.print("Basic Empty Weight in lbs: ");
            userBasicEmptyWeight = scn.nextLine();
            try {
                int intBasicEmptyWeight = Integer.parseInt(userBasicEmptyWeight);
                if (intBasicEmptyWeight > 1081 && intBasicEmptyWeight < 1500) {
                    validBasicEmptyWeight = true;
                }
                else {
                    System.out.print("Error: Basic Empty Weight outside limits.");
                }
            }
            catch(NumberFormatException e) {
                System.out.print("Error: invalid Basic Empty Weight.");
            }


        } while(!validBasicEmptyWeight);

        return userBEW;
    }

    public int selectBasicEmptyWeightMoment() {
        Scanner scn = new Scanner(System.in);
        System.out.print("BEW Moment in lbs-in (/1000): ");
        String basicEmptyWeightMoment = scn.next();
        return parseInt(basicEmptyWeightMoment);
    }
}