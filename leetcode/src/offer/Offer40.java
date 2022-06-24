package offer;

import java.util.Arrays;

public class Offer40 {

    public static void main(String[] args) {
        Offer40 offer40 = new Offer40();
        int[] arr = new int[]{4,5,1,6,2,7,3};
        System.out.println(Arrays.toString(offer40.getLeastNumbers(arr, 4)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickSort(int[] arr, int startIndex, int pivot) {
        if (startIndex >= pivot) {
            return;
        }
        int pivotValue = arr[pivot];
        int greatPivotStartIndex = startIndex;
        for (int i = startIndex; i<pivot; i++) {
            if (arr[i] < pivotValue) {
                int tmp = arr[i];
                arr[i] = arr[greatPivotStartIndex];
                arr[greatPivotStartIndex] = tmp;
                greatPivotStartIndex++;
            }
        }
        arr[pivot] = arr[greatPivotStartIndex];
        arr[greatPivotStartIndex] = pivotValue;
        quickSort(arr, startIndex, greatPivotStartIndex - 1);
        quickSort(arr, greatPivotStartIndex + 1, pivot);
    }
}
