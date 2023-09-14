import java.util.Random;

public class selection {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100000);

        long startTime = System.nanoTime();
        selectionSort(arr);
        long endTime = System.nanoTime();

        double executionTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        long timestampMilliseconds = endTime / 1_000_000;

        System.out.println("\nExecution time: " + executionTimeSeconds + " seconds");
        System.out.println("Timestamp (milliseconds): " + timestampMilliseconds);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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
