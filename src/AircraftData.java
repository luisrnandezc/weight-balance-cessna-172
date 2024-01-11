// TODO: include Class docstring.

import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import com.opencsv.*;

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
            if (fileEntry.getName().endsWith(".csv")) {
                fileNames.add(fileEntry.getName());
            }
        }
        return fileNames;
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
        System.out.print("Specify the aircraft model (152 / 172): ");
        return scn.next();
    }

    public String selectSeatingConfig() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Seating Configuration. Write 1 for Standard OR 2 for Optional: ");
        return scn.next();
    }

    public int selectBasicEmptyWeight() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Basic Empty Weight in Lbs: ");
        String basicEmptyWeight = scn.next();
        return Integer.parseInt(basicEmptyWeight);
    }
}