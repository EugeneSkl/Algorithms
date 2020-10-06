public class sort3 {

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

        //сountingSort(arr1);
        timSort(arr1, arr1.length);

        time = System.nanoTime() - time;
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

    }

    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    public static int[] сountingSort(int[] array) { // Сортировка подсчетом
        int min, max; //max и min значения в массиве
        max = min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max - min + 1];        //создаем массив счетчиков
        for (int i = 0; i < array.length; i++) { //сколько раз встречается каждое число
            count[array[i] - min]++;//cколько раз встречается число
        }
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[idx++] = i + min;
            }
        }
        return array;
    }

    public static void timSort(int[] arr, int n) { //Сортировка гибридная
        int r=32; //размер подмассива
        for (int i = 0; i < n; i += r) {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }

        for (int size = r; size < n; size = 2 * size) { //начинаем объединение отсорт массивов
            for (int left = 0; left < n; left += 2 * size) {
                int right = Math.min((left + 2 * size - 1), (n - 1));
                mergeSort(arr, left, right); //соединяем массивы
            }
        }
    }

    public static void insertionSort(int[] arr, int left, int right) {
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
