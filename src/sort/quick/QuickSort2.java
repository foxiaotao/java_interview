package sort.quick;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author:tao
 * @create: 2019-12-28 11:18
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int []array = {43, 22, 49, 6, 5, 2, 50, 65};
        System.out.println("原数组:" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);


        System.out.println("排序数组:" + Arrays.toString(array));
    }

    private static void quickSort(int []array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {

            int equalIndex = getEqualIndex(array, leftIndex, rightIndex);

            quickSort(array, leftIndex, equalIndex - 1);

            quickSort(array, equalIndex + 1, rightIndex);
        }
        // else 退出递归
    }

    private static int getEqualIndex(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && array[rightIndex] > temp) {
                rightIndex --;
            }
            // rightIndex 静止，把array[rightIndex] 赋值给 leftIndex位置
            if (leftIndex != rightIndex) {
                array[leftIndex] = array[rightIndex];
            }

            while (leftIndex < rightIndex && array[leftIndex] < temp) {
                leftIndex++;
            }
            if (leftIndex != rightIndex) {
                array[rightIndex] = array[leftIndex];
            }
        }
        // 此时 leftIndex = rightIndex
        array[leftIndex] = temp;
        return leftIndex;
    }


}
