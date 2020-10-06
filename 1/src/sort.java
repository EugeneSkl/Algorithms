import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class sort {


    public static void main(String[] args) {

        int a = (int) Math.pow(2, 8);
        int[] arr1 = new int[a];
        for (int i=0; i<a;i++){
            arr1[i]= 1 + (int)( Math.random()*100000);
        }


        int b = (int) Math.pow(2, 17);
        int[] arr2 = new int[b];
        for (int i=0; i<b;i++){
            arr2[i]= 1 + (int)( Math.random()*100000);
        }


        int c=(int) Math.pow(2, 17);
        int[] arr3 = new int[c];
        arr3[0]=1;
        for (int i=1; i<c;i++){
            arr3[i]= 1 + arr3[i-1];
        }
        for (int i=0; i<10; i++){
            int randInd= (int) (Math.random()*(c-2));
            //System.out.println(randInd);
            int tmp = arr3[randInd];
            arr3[randInd] = arr3 [ randInd+2];
            arr3[randInd+2] = tmp;
        }

        int d=(int) Math.pow(2, 17);
        int[] arr4 = new int[d];
        for (int i=0; i<d;i++){
            arr4[i]= 1 + (int)( Math.random()*100);
        }

        long time = System.nanoTime();

        bubbleSort(arr4);
        //insertionSort(arr1, 0, arr1.length-1);

        time = System.nanoTime() - time;
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);
        //printArray(arr1);


    }
    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {     //Сортировка пузырьком
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }

        }
    }
    public static void insertionSort(int[] arr, int left, int right) { //Сортировка вставками
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
