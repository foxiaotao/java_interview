package sort.quick;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author:tao
 * @create: 2019-12-28 11:18
 */
public class QuickSort {

    public static void main(String[] args) {
        int []array = {5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原数组:" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);


        System.out.println("排序数组:" + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = getEqualIndex(array, low, high);
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }

    }

    private static int getEqualIndex(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            // 后往前
            while (low < high && temp <= array[high]) {
                high--;
            }
            // 交换(temp 比最后大)
            array[low] = array[high];
            while (low < high && temp >= array[low]) {
                low ++;
            }
            array[high] = array[low];
        }
        array[high] = temp;
        return high;
    }


}
