import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int arraySize, i = 0;
        File csv = new File("integers.csv");
        Scanner in = new Scanner(csv);
        in.useDelimiter(",");
        arraySize = Integer.parseInt(in.next());
        int[] a = new int[arraySize];
        while (in.hasNext()) {
            a[i++] = Integer.parseInt(in.next());
        }
        in.close();

        //ptpSort(a);
        //test if is sorted, test array below.
        int[] b = {1, 2, 3, 4, 5, 6, 7, 7, 7, 10};
        Main main = new Main();
        System.out.println(main.testIfSorted(b));

    }
    public boolean testIfSorted(int[] a){
        boolean isSorted = true;
        for (int j = 1; j < 10; j++) { // Start from index 1, comparing with the previous element
            if (a[j] < a[j - 1]) { // If current element is smaller than previous
                isSorted = false; // Array is not sorted
                break; // No need to continue checking, we already know it's not sorted
            }
        }
        return isSorted;
    }
}
