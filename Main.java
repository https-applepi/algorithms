

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
class PTPSort
{
    public int[] PTPSort(int a, int beg, int end){
        if((end - beg +1)< )
            if(!PartitionOnly){
                OpenMP Task
                STLSort(a+beg,a+end+1);
            }
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


