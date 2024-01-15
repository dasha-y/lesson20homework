package num2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSortThread extends Thread {
    int[] arr;
    int[] sortedArr;

    public SelectionSortThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        sortedArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < sortedArr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedArr.length; j++) {
                if (sortedArr[j] < sortedArr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = sortedArr[i];
            sortedArr[i] = sortedArr[minIndex];
            sortedArr[minIndex] = temp;
        }
        System.out.println("Сортировка выбором: " + Arrays.toString(sortedArr));

    }

}
