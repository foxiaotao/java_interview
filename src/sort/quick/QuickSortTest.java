package sort.quick;

import java.util.Arrays;

/**
 * @description: 快速排序 交换次数
 * @author:tao
 * @create: 2019-12-28 11:18
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int []array = {5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原数组:" + Arrays.toString(array));

        int []swapTimes = {0};
        quickSort(array, 0, array.length - 1, swapTimes);

        System.out.println("排序数组:" + Arrays.toString(array));
        System.out.println("交换次数=" + swapTimes[0]);
    }

    private static void quickSort(int[] array, int low, int high, int[] swapTimes) {
        if (low < high) {
            int index = getEqualIndex(array, low, high, swapTimes);
            quickSort(array, low, index - 1, swapTimes);
            quickSort(array, index + 1, high, swapTimes);
        }

    }

    private static int getEqualIndex(int[] array, int low, int high, int[] swapTimes) {
        int temp = array[low];
        while (low < high) {
            // 后往前
            while (low < high && temp <= array[high]) {
                high--;
            }
            // 交换(temp 比最后大)
            array[low] = array[high];
            swapTimes[0]++;
            while (low < high && temp >= array[low]) {
                low ++;
            }
            array[high] = array[low];
            swapTimes[0]++;
        }
        array[high] = temp;
        return high;
    }


}
