package sort.bubble;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冒泡排序(根据原理写代码)
 * @author:tao
 * @create: 2019-12-26 12:28
 */
public class BubbleSort1Base {


    // ============================= 第0版 开始 ======================
    @Test
    public void sort01() {
        int []arr = {1, 2, 5, 6, 22, 23, 50, 43, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr) + ",数组长度" +arr.length);
        System.out.println("第0版 冒泡排序");
        firstBubbleSort0(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }


    /**
     * 普通版 第0版冒泡
     * @param array
     */
    private void firstBubbleSort0(int[] array) {
        int ifTimes = 0;
        int swapTimes = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length -1; j++) {
                // if次数
                ifTimes ++;

                if (array[j] > array[j+1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapTimes ++ ;
                }
            }
            System.out.println("第" + i+ "次后结果为:" + Arrays.toString(array));
        }
        System.out.println("if判断次数ifTimes = " + ifTimes);
        System.out.println("发生交换次数swapTimes = " + swapTimes);

    }
    // ============================= 第0版 结束 ======================

    /**
     * 原始数组:[1, 2, 5, 6, 22, 23, 50, 43, 65, 78, 88],数组长度11
     * 第0版 冒泡排序
     * 第0次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第1次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第2次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第3次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第4次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第5次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第6次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第7次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第8次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第9次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * 第10次后结果为:[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     * if判断次数ifTimes = 110
     * 发生交换次数swapTimes = 1
     * 排序后数组[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     */
}
