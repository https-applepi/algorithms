import java.util.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    public boolean testIfSorted(int[] a){
        for (int j = 1; j < 10; j++) { // Start from index 1, comparing with the previous element
            if (a[j] < a[j - 1]) { // If current element is smaller than previous
                return false;
            }
        }
        return true; //if no inconsistencies found, return true
    }
    int USTL = 100;
    boolean partitionOnly = false;
    public void PTPSort(int[] a, int beg, int end){
        if((end - beg +1)<USTL){
            if(!partitionOnly){
                Arrays.sort(a);
                return;
            }
            else{
                int len = (beg - end)/2;
                int lowPivot, MedPivot,HighPivot;
            }
        }
    }
    int [] Sampling(int [] a, int begin, int end ){
        int [] array = new int[3];
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int index = rand.nextInt(end - begin + 1) + begin;
            while (contains(array, index)) {
                index = rand.nextInt(end - begin + 1) + begin;
            }
            array[i] = index;

        }
        Arrays.sort(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        return array;
    }
    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private int hoare(int[] array, int start, int end, int pivot) {
        int i = start, j = end, swap;
        while (true) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] >= pivot) {
                j--;
            }
            if (i > j) {
                return j-1;
            }
            swap = i;
            i = j;
            j = swap;
        }
    }

    public static void main(String[] args) throws Exception {
        int arraySize, i = 0;
        File csv = new File("integers.csv");
        Scanner in = new Scanner(csv);
        in.useDelimiter(",");
        arraySize = Integer.parseInt(in.next());
        int[] array = new int[arraySize];
        while (in.hasNext()) {
            array[i++] = Integer.parseInt(in.next());
        }
        in.close();

        //ptpSort(a);
        //test if is sorted, test array below.
        int[] testArray = {10, 2, 3, 4, 5, 6, 7, 7, 7, 10};
        Main main = new Main();
        main.PTPSort(testArray,0,10);
        main.Sampling(testArray,0,10);
        System.out.println(main.testIfSorted(testArray));
    }
}

