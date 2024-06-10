// TODO: include Class docstring.

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayloadReader {

    public List<String[]> readPayloadFile() {
        String fileName = "payload.txt";
        String path = scanDataFolderPath();
        CSVReader csvReader = initializeCSVReader(path + "\\" + fileName);
        return readCSVFile(csvReader);
    }

    private static String scanDataFolderPath() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the path for the Data folder: ");
        return scn.next();
    }

    private static CSVReader initializeCSVReader(String filename) {
        try {
            FileReader filereader = new FileReader(filename);
            CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
            return new CSVReaderBuilder(filereader).withCSVParser(csvParser).build();
        } catch (IOException e) {
            throw new RuntimeException("Error. File payload.txt not found", e);
        }
    }

    private static List<String[]> readCSVFile(CSVReader csvReader) {
        List<String[]> csvData = new ArrayList<>();
        try {
            csvData = csvReader.readAll();
            return csvData;
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.\n");
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return csvData;
    }
}
