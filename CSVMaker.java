import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//code that creates a CSV file of specified size with random positive integers
public class CSVMaker {
    public static void makeCSV(){
        // Define the number of integers to generate
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter what you want your array size to be: ");

        int numberOfIntegers = myObj.nextInt();

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
            System.out.println("CSV file 'integers.csv' of size "+numberOfIntegers +" has been created successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the CSV file: " + e.getMessage());
        }
    }
}