package sort.bubble;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author:tao
 * @create: 2019-12-26 12:28
 */
public class BubbleSort3CheckAllArrayIsSorted {


    // ============================= 第二版 开始 ======================


    @Test
    public void sort21() {
        int []arr = {2, 5, 6, 1, 22, 23, 43, 50, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr));
        sortArrayWithAllArrayIsSorted(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void sort22() {
        int []arr = {1, 2, 5, 6, 22, 23, 50, 43, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第二版 冒泡排序(如果数组已经有序,结束排序)");
        sortArrayWithAllArrayIsSorted(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }
    @Test
    public void sort23() {
        int []arr = {2, 5, 6, 22, 23, 43, 50, 65, 78, 88, 1};
        sortArrayWithAllArrayIsSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 对已经排序的  可以减少开销, 当数组已经是排序状态后 不会继续进行
     * 判断目标是 整个 数组是否已经排序好
     * @param array
     */
    private void sortArrayWithAllArrayIsSorted(int[] array) {
        int ifTimes = 0;
        int swapTimes = 0;

        for (int i = 0; i < array.length; i++) {
            // 是否已经排序好了(是否发生互换 否定)
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i ; j++) {
                // if次数
                ifTimes ++;

                if (array[j] > array[j+1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    swapTimes ++ ;
                }
            }
            System.out.println("第" + i+ "次后结果为:" + Arrays.toString(array) + ",isSorted=" + isSorted);
            // 如果没有互换 说明已经排序完成
            if (isSorted) {
                break;
            }
        }
        System.out.println("if判断次数ifTimes = " + ifTimes);
        System.out.println("发生交换次数swapTimes = " + swapTimes);
    }


    // ============================= 第二版 结束 ======================

    /**
     * 原始数组:[1, 2, 5, 6, 22, 23, 50, 43, 65, 78, 88]
     * 第二版 冒泡排序(如果数组已经有序,结束排序)
     * 第0次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88],isSorted=false
     * 第1次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88],isSorted=true
     * if判断次数ifTimes = 19
     * 发生交换次数swapTimes = 1
     * 排序后数组[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     */
}
