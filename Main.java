
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
        System.out.println(main.testIfSorted(testArray));
    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}



class Traverse implements Runnable {
    private final Node node;

    public Traverse(Node node) {
        this.node = node;
    }

    @Override
    public void run() {
        traverse(node);
    }

    private void traverse(Node p) {
        if (p == null)
            return;

        Thread leftThread = null;
        Thread rightThread = null;

        if (p.left != null) {
            Traverse tLeft = new Traverse(p.left);
            leftThread = new Thread(tLeft);
            leftThread.start();
        }

        if (p.right != null) {
            Traverse tRight = new Traverse(p.right);
            rightThread = new Thread(tRight);
            rightThread.start();
        }

        try {
            if (leftThread != null)
                leftThread.join(); // Wait for the left thread to finish
            if (rightThread != null)
                rightThread.join(); // Wait for the right thread to finish

            // Do whatever processing you need to do with the current node here
            System.out.println("Processed node: " + p.data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


