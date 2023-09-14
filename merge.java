import java.util.Arrays;
import java.util.Random;

public class merge {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100000);

        long startTime = System.nanoTime();
        mergeSort(arr);
        long endTime = System.nanoTime();

        double executionTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        long timestampMilliseconds = endTime / 1_000_000;

        System.out.println("\nExecution time: " + executionTimeSeconds + " seconds");
        System.out.println("Timestamp (milliseconds): " + timestampMilliseconds);
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return; 
        }

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int nLeft = left.length;
        int nRight = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nLeft && j < nRight) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < nLeft) {
            arr[k++] = left[i++];
        }

        while (j < nRight) {
            arr[k++] = right[j++];
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }
}
