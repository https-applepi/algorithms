import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


//code that creates a CSV file of specified size with random positive integers
public class CSVMaker {
    public static void main(String[] args) {
        // Define the number of integers to generate
        int numberOfIntegers = 100000;

        // Create a StringBuilder to hold CSV content
        StringBuilder csvContent = new StringBuilder();

        // Generate and append integers to the CSV content
        Random random = new Random();
        for (int i = 0; i < numberOfIntegers; i++) {
            int randomNumber = random.nextInt();
            //making negative integers positive
            if (randomNumber<0){
                randomNumber *= -1;
            }
            //writing the numbers into a stringbuilder that holds all the values
            csvContent.append(randomNumber);
            csvContent.append(",");
        }
        // Remove the last comma
        csvContent.deleteCharAt(csvContent.length() - 1);

        // Write CSV content to file
        try (FileWriter writer = new FileWriter("integers.csv")) {
            writer.write(numberOfIntegers + ",");
            writer.append(csvContent.toString());
            System.out.println("CSV file 'integers.csv' has been created successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the CSV file: " + e.getMessage());
        }
    }
}