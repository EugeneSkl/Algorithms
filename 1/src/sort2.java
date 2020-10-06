import java.util.Arrays;

public class sort2 {

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

        //quickSort(arr1, 0, arr1.length-1);
        mergeSort(arr1, 0, arr1.length - 1);


        time = System.nanoTime() - time;
        System.out.printf("Elapsed %,9.3f ms\n", time / 1_000_000.0);

    }

    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] array, int begin, int end) {     //Сортировка быстрая
        int left = begin;
        int right = end;
        int pivot = array[(left + right) / 2]; //опорный элемент
        do { //деление на подмассивы
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    int tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < end) { // сортируем отдельно части
            quickSort(array, left, end);
        }
        if (begin < right) {
            quickSort(array, begin, right);
        }
    }

    public static void mergeSort(int[] array, int start, int end) { //Сортировка слиянием
        if (end <= start)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        int[] mas = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mas[i] = array[i];
        }
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                array[k] = mas[j];
                j++;
            } else {
                if (j > end) {
                    array[k] = mas[i];
                    i++;
                } else {
                    if (mas[j] < mas[i]) {
                        array[k] = mas[j];
                        j++;
                    } else {
                        array[k] = mas[i];
                        i++;
                    }
                }
            }
        }
    }
}


