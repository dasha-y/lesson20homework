package num2;

import java.util.Arrays;

public class BubbleSortThread extends Thread {
    int[] arr;
    int[] sortedArr;

    public BubbleSortThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        sortedArr = Arrays.copyOf(arr, arr.length);
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < sortedArr.length - j; i++) {
                if (sortedArr[i] > sortedArr[i + 1]) {
                    int temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        System.out.println("Сортировка пузырьком: " + Arrays.toString(sortedArr));
    }

    }

