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
    }
}