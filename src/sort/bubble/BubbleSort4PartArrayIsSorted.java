package sort.bubble;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author:tao
 * @create: 2019-12-26 12:28
 */
public class BubbleSort4PartArrayIsSorted {


    // ============================= 第三版 开始 ======================

    @Test
    public void sort31() {
        int []arr = {1, 2, 5, 6, 50, 22, 23, 43, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第三版 冒泡排序(遍历到无序和有序的边界)");
        sortArrayWithPartyArrayIsSorted(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }
    @Test
    public void sort32() {
        int []arr = {2, 5, 6, 1, 22, 23, 43, 50, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第三版 冒泡排序(遍历到无序和有序的边界)");
        sortArrayWithPartyArrayIsSorted(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }

    @Test
    public void sort33() {
        int []arr = {2, 5, 6, 22, 23, 43, 50, 65, 78, 88, 1};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第三版 冒泡排序(遍历到无序和有序的边界)");
        sortArrayWithPartyArrayIsSorted(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }


    /**
     * 遍历到无序和有序的边界
     * 判断目标是 部分(前半无序,后半有序 会减少if)
     * @param array
     */
    private void sortArrayWithPartyArrayIsSorted(int[] array) {

        int ifTimes = 0;
        int swapTimes = 0;

        // 最后一次发生交换的地方
        int lastSwapIndex = 0;

        // 无序部分长度, 每次比较只需要比到这里为止
        int unSortBorder = array.length -1;

        for (int i = 0; i < array.length; i++) {
            // 是否已经排序好了(是否发生互换 否定)
            boolean isSorted = true;
            for (int j = 0; j < unSortBorder; j++) {
                // for次数
                ifTimes ++;

                if (array[j] > array[j+1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    isSorted = false;
                    // 当本轮for完成 j 到 array.length 的位置元素已经排序,下轮不需要遍历
                    lastSwapIndex = j;

                    swapTimes ++ ;
                }
            }
            System.out.println("第" + i+ "次后结果为:" + Arrays.toString(array) + ",isSorted=" + isSorted);
            // 如果没有互换 说明已经排序完成
            // 更新边界
            unSortBorder = lastSwapIndex;

            if (isSorted) {
                break;
            }

        }
        System.out.println("if判断次数ifTimes = " + ifTimes);
        System.out.println("发生交换次数swapTimes = " + swapTimes);
    }
    // ============================= 第三版 结束 ======================

    /**
     * 原始数组:[1, 2, 5, 6, 50, 22, 23, 43, 65, 78, 88]
     * 第三版 冒泡排序(遍历到无序和有序的边界)
     * 第0次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88],isSorted=false
     * 第1次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88],isSorted=true
     * if判断次数ifTimes = 16
     * 发生交换次数swapTimes = 3
     * 排序后数组[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     */
}
