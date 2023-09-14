import java.util.Random;

public class insertion {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100000);

        long startTime = System.nanoTime();
        insertionSort(arr);
        long endTime = System.nanoTime();

        double executionTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        long timestampMilliseconds = endTime / 1_000_000;

        System.out.println("\nExecution time: " + executionTimeSeconds + " seconds");
        System.out.println("Timestamp (milliseconds): " + timestampMilliseconds);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
