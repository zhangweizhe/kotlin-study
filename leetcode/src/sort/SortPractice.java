package sort;

import java.util.Arrays;

public class SortPractice {

    public static void main(String[] args) {
        bubbleSort(new int[]{2,3,41,7,5,24,68,4});
        insertSort(new int[]{5,67,42,6,3,276,13,8,532});
        selectSort(new int[]{5,67,42,6,3,276,13,8,532});
        mergeSort(new int[]{5,67,42,6,3,276,13,8,532});
        quickSort(new int[]{5,67,42,6,3,276,13,8,532});
    }

    private static void bubbleSort(int[] array) {
        for (int i=0; i<array.length; i++) {
            boolean change = false;
            for (int j=0; j<array.length - i -1; j++) {
                if (array[j] > array[j+1]) {
                    change = true;
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            if (!change) {
                break;
            }
        }
        System.out.println("bubbleSort-------");
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        if (array.length <= 1) {
            System.out.println("insertSort-------");
            System.out.println(Arrays.toString(array));
            return;
        }

        for (int i=1; i<array.length; i++) {
            int value = array[i];
            int j = i-1;
            for (; j>=0; j--) {
                if (value < array[j]) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            // 插入
            array[j+1] = value;
        }

        System.out.println("insertSort-------");
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] array) {

        for (int i=0; i<array.length; i++) {
            int minIndex = i;
            for (int j=i; j<array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }

        System.out.println("selectSort-------");
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1);

        System.out.println("mergeSort-------");
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSortHelper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end)/2;
        // 左边执行合并排序
        mergeSortHelper(array, start, mid);
        // 右边
        mergeSortHelper(array, mid + 1, end);

        // 合并左右两个有序的数组，合并为一个有序数组
        int[] tmpArray = new int[end - start + 1];
        int tmpIndex = 0;
        int leftIndex = start;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= end) {
            if (array[leftIndex] <= array[rightIndex]) {
                tmpArray[tmpIndex++] = array[leftIndex++];
            }else {
                tmpArray[tmpIndex++] = array[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            tmpArray[tmpIndex++] = array[leftIndex++];
        }
        while (rightIndex <= end) {
            tmpArray[tmpIndex++] = array[rightIndex++];
        }

        for (int i=0; i<tmpArray.length; i++) {
            array[start + i] = tmpArray[i];
        }
    }

    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);

        System.out.println("quickSort-------");
        System.out.println(Arrays.toString(array));
    }

    private static void quickSortHelper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[end];
        int i = start;

        for (int j=start; j<=end; j++) {
            if (array[j] < pivot) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                i++;
            }
        }

        array[end] = array[i];
        array[i] = pivot;

        quickSortHelper(array, start, i-1);
        quickSortHelper(array, i+1, end);
    }
}
