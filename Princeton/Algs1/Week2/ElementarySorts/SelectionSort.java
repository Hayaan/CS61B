import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    private static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!isLess(arr[i], arr[i + 1])) { return false; }
        }
        return true;
    }

    public static void sort(Comparable[] arr) {
        int smallestIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            smallestIndex = i;
            for (int j = i; j < arr.length; j++) {
                smallestIndex = (isLess(arr[j], arr[smallestIndex])) ? j : smallestIndex;
            }
            exchange(arr, smallestIndex, i);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(24) + 1;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
        System.out.println("Pre sort:\t" + Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println("Post sort:\t" + Arrays.toString(arr));
        System.out.println("Sorted check:\t" + SelectionSort.isSorted(arr));
    }
}
