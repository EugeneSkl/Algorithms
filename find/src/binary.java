import java.util.Arrays;

public class binary {
    public static void main(String[] args) {
        int a = (int) Math.pow(2, 20);
        int[] arr1 = new int[a];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1 + (int) (Math.random() * 10000);
        }
        int element = 1 + (int) (Math.random() * 10000);

        Arrays.sort(arr1);

        int index;
        long time1 = System.nanoTime();
        index = binarySearch(arr1, element);
        time1 = System.nanoTime() - time1;
        System.out.printf("Elapsed %,9.3f ms\n", time1/1_000_000.0);

        System.out.println(index);

    }

    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    static int binarySearch(int[] arr, int element){ //Бинарный поиск
        int left = 0;
        int right = arr.length - 1;
        while( (left+right)>0 ) {
            int mid = (left + right) / 2;
            if (arr[mid] == element) {
                return mid;
            }
            else {
                if (arr[mid] < element) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}