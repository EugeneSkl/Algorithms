import java.lang.reflect.Array;
import java.util.*;

public class linear {

    public static void main(String[] args) {
        int a = (int) Math.pow(2, 20);
        int[] arr1 = new int[a];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1 + (int) (Math.random() * 10000);
        }

        int element =  1 + (int) (Math.random() * 10000);

        int index;

        long time1 = System.nanoTime();
        index = linearSearch(arr1, element);
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
    public static int linearSearch(int[] array, int element) {     //Последовательный поиск
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }
}