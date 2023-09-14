import java.util.Random;

public class bubble {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100000);

        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();

        double executionTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        long timestampMilliseconds = endTime / 1_000_000;

        System.out.println("\nExecution time: " + executionTimeSeconds + " seconds");
        System.out.println("Timestamp (milliseconds): " + timestampMilliseconds);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
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
