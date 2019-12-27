package sort.bubble;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author:tao
 * @create: 2019-12-26 12:28
 */
public class BubbleSort2Halfn {


    // ============================= 第一版 开始 ======================
    @Test
    public void sort11() {
        int []arr = {1, 2, 5, 6, 22, 23, 50, 43, 65, 78, 88};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("第一版 冒泡排序");
        firstBubbleSort(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }
    @Test
    public void sort12() {
        int []arr = {43, 22, 6, 5, 23, 2, 50, 65, 78, 88, 1};
        System.out.println("原始数组:" + Arrays.toString(arr));
        firstBubbleSort(arr);
        System.out.println("排序后数组" + Arrays.toString(arr));
    }


    /**
     * 普通版 第一版冒泡
     * @param array
     */
    private void firstBubbleSort(int[] array) {
        int ifTimes = 0;
        int swapTimes = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length -i -1; j++) {
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

    /**
     * 原始数组:[1, 2, 5, 6, 22, 23, 50, 43, 65, 78, 88]
     * 第一版 冒泡排序
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
     * if判断次数ifTimes = 55
     * 发生交换次数swapTimes = 1
     * 排序后数组[1, 2, 5, 6, 22, 23, 43, 50, 65, 78, 88]
     */
}
