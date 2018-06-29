import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
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

    /* 
    Sometimes doesn't properly sort. Switch if to while?
    */
    public static void sort(Comparable[] arr) {
        for (int h = arr.length / 2; h > 0; h--) {
            for (int i = 0; (i + h) < arr.length; i++) {
                if (isLess(arr[i + h], arr[i])) {
                    exchange(arr, i + h, i);
                }
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
        System.out.println("Pre sort:\t" + Arrays.toString(arr));
        ShellSort.sort(arr);
        System.out.println("Post sort:\t" + Arrays.toString(arr));
        System.out.println("Sorted check:\t" + ShellSort.isSorted(arr));
    }
}
