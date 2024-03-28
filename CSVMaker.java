import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
            if (randomNumber<0){
                randomNumber *= -1;
            }
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