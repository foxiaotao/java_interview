package sort.bubble;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author:tao
 * @create: 2019-12-26 12:28
 */
public class BubbleSort5LeftAndRightSortedBorder {


    // ============================= 第四版 开始 ======================
    @Test
    public void sort41() {
        int []arr = {1, 2, 5, 6, 50, 22, 23, 43, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第四版 冒泡排序(考虑双向边界)");
        sortArrayWithDoublePartyArrayIsSorted(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }
    @Test
    public void sort42() {
        int []arr = {2, 5, 6, 50, 22, 23, 43, 65, 78, 88, 1};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第四版 冒泡排序(考虑双向边界)");
        sortArrayWithDoublePartyArrayIsSorted(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }
    @Test
    public void sort43() {
        int []array = {5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原始数组:" + Arrays.toString(array));
        System.out.println("第四版 冒泡排序(考虑双向边界)");
        sortArrayWithDoublePartyArrayIsSorted(array);
        System.out.println("排序后数组" + Arrays.toString(array));
    }

    /**
     * 对已经排序的  可以减少开销, 当数组已经是排序状态后 不会继续进行
     * 判断目标是 双边界(从两边观察 是否有已经排好序的部分) 数组是否已经排序好
     * @param array
     */
    private void sortArrayWithDoublePartyArrayIsSorted(int[] array) {
        int temp;
        int ifTimes = 0;
        int swapTimes = 0;

        // 最后一次发生交换的地方
        int lastLeftSwapIndex = 0;
        int lastRightSwapIndex = array.length -1;

        for (int i = 0; i < array.length; i++) {
            // 是否已经排序好了(是否发生互换 否定)
            boolean isSorted = true;

            // 每次从第个开始判断if
            int beginBorder = lastLeftSwapIndex;
            // 无序部分长度, 每次比较只需要比到这里为止
            int endBorder = lastRightSwapIndex;

            if(i % 2 == 0) {
                for (int j = beginBorder; j < endBorder; j++) {
                    // if次数
                    ifTimes ++;
                    //
                    if (array[j] > array[j+1]) {
                        temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;

                        isSorted = false;
                        // 当本轮for完成 j 到 array.lenght 的位置元素已经排序
                        lastRightSwapIndex = j;

                        // test 代码
                        swapTimes ++ ;
                    }
                }
            } else {
                for (int j = endBorder - 1; j >= 0; j--) {
                    // if次数
                    ifTimes++;
                    //
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;

                        isSorted = false;
                        // 当本轮for完成 endBorder - j 到 endBorder 的位置元素已排序排序
                        lastLeftSwapIndex = j;

                        // test 代码
                        swapTimes++;
                    }
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

    /**
     * 原始数组:[2, 5, 6, 22, 23, 43, 50, 65, 78, 88, 1]
     * 第四版 冒泡排序(考虑双向边界)
     * 第0次后结果为:[2, 5, 6, 22, 23, 43, 50, 65, 78, 1, 88],isSorted=false
     * 第1次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88],isSorted=false
     * 第2次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88],isSorted=true
     * if判断次数ifTimes = 28
     * 发生交换次数swapTimes = 10
     * 排序后数组[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     */
}
