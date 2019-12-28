package sort.insert;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author:tao
 * @create: 2019-12-27 17:48
 */
public class InsertSort {

    public static void main(String[] args) {
        int []array = {5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原数组:" + Arrays.toString(array));
        insertSort(array);
        System.out.println("排序数组:" + Arrays.toString(array));
    }

    private static void insertSort(int []array) {

        int forTimes = 0;
        int swapTimes = 0;

        for (int i = 0; i < array.length-1; i++) {

            int j = i + 1;
            // 每次插入的元素
            int insertValue = array[j];
            boolean isSwap = false;
            for ( ; j > 0 && insertValue < array[j-1]; j--) {
                // (比insertValue大的值)平行移动
                forTimes++;
                swapTimes++;
                array[j] = array[j-1];
                isSwap = true;
            }
            if (isSwap) {
                // 找到插入位置
                array[j] = insertValue;
            }
            System.out.println("第" + i + "轮," + Arrays.toString(array) + ",插入元素是array["+ (i+1) +"]=" + insertValue + ", 插入位置是:array.index=" + j);
        }
        System.out.println("循环次数forTimes = " + forTimes);
        System.out.println("发生交换次数swapTimes = " + swapTimes);
    }
}
