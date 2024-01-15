package num2;

import java.util.Arrays;

public class InsertionSortThread extends Thread {
    int[] arr;
    int[] sortedArr;

    public InsertionSortThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        sortedArr = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < sortedArr.length; i++) {
            int key = sortedArr[i];
            int j = i - 1;
            while (j >= 0 && sortedArr[j] > key) {
                sortedArr[j + 1] = sortedArr[j];
                j--;

            }
            sortedArr[j + 1] = key;
        }
        System.out.println("Сортировка вставками: " + Arrays.toString(sortedArr));
    }
}
