package sort.quick;

import java.util.Arrays;

/**
 * @description: 快速排序 交换次数
 * @author:tao
 * @create: 2019-12-28 11:18
 */
public class QuickSortTest {

    private static int swapTimes = 0;

    public static void main(String[] args) {
        int []array = {43, 22, 49, 6, 5, 2, 50, 65};
        System.out.println("原数组:" + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("排序数组:" + Arrays.toString(array));
        System.out.println("交换次数=" + swapTimes);
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
            swapTimes++;
            while (low < high && temp >= array[low]) {
                low ++;
            }
            array[high] = array[low];
            swapTimes++;
        }
        array[high] = temp;
        return high;
    }


}
