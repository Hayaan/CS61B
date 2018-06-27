import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    private static void exchange (Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) == -1;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) == 1) { return false; }
        }
        return true;
    }

    public static void sort(Comparable[] arr) {
        int swapIndex, sortedIndex;
        for (int i = 1; i < arr.length; i++) {
            swapIndex = i;
            sortedIndex = i - 1;
            while (isLess(arr[swapIndex], arr[sortedIndex])) {
                exchange(arr, swapIndex--, sortedIndex--);
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(24) + 1;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
        System.out.println();
        System.out.println("Pre sort:\t" + Arrays.toString(arr));
        InsertionSort.sort(arr);
        System.out.println("Post sort:\t" + Arrays.toString(arr));
        System.out.println("Sorted check:\t" + InsertionSort.isSorted(arr));
    }
}