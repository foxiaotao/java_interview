package sort.selection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 选择排序
 * 每一轮先选出最小元素,把最小元素放到第一个位置
 * @author:tao
 * @create: 2019-12-27 16:01
 */
public class SelectionSort {


    @Test
    public void selectionSortTest() {
        int []array = {3, 45, 7, 4, 24, 77, -2};
        System.out.println("原数组:" + Arrays.toString(array));
        selectionSort(array);
        System.out.println("排序数组:" + Arrays.toString(array));
    }

    @Test
    public void selectionSortTest2() {
        int []array = {5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原数组:" + Arrays.toString(array));
        selectionSort(array);
        System.out.println("排序数组:" + Arrays.toString(array));
    }

    private void selectionSort(int[] array) {
        int forTimes = 0;
        int swapTimes = 0;

        for (int i = 0; i < array.length; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < array.length; j++) {
                minValueIndex = array[j] < array[minValueIndex] ? j : minValueIndex;
                // forTimes test代码
                forTimes ++;
            }
            if (array[i] > array[minValueIndex]) {
                // swapTimes test代码

                soutLog(array, i, minValueIndex);
                swapTimes ++;


                int temp = array[i];
                array[i] = array[minValueIndex];
                array[minValueIndex] = temp;

            } else {
                System.out.println("第" + i + "轮," + Arrays.toString(array) + ",剩余最小数array["+ minValueIndex +"]=" + array[minValueIndex] + ".没有需要交换");
            }

        }
        System.out.println("循环次数forTimes = " + forTimes);
        System.out.println("发生交换次数swapTimes = " + swapTimes);
    }

    /**
     * 打印日志 便于观察
     * @param array
     * @param i
     * @param minValueIndex
     */
    private void soutLog(int[] array, int i, int minValueIndex) {
        List<String> sortList = new ArrayList<>();
        List<String> unSortList = new ArrayList<>();
        for (int i1 = 0; i1 < array.length; i1++) {
            if (i1 <= i-1) {
                sortList.add(array[i1] + "");
            } else {
                unSortList.add(array[i1] + "");
            }
        }
        System.out.println("第" + i + "轮[" + String.join(",", sortList) + "] - [" + String.join(",", unSortList) +
                "]剩余最小数array["+ minValueIndex +"]=" + array[minValueIndex] + ".交换" + array[i] + "和" + array[minValueIndex]);
    }

    /**
     原数组:[5, 8, 6, 3, 9, 2, 1, 7]
     第0轮[] - [5,8,6,3,9,2,1,7]剩余最小数array[6]=1.交换5和1
     第1轮[1] - [8,6,3,9,2,5,7]剩余最小数array[5]=2.交换8和2
     第2轮[1,2] - [6,3,9,8,5,7]剩余最小数array[3]=3.交换6和3
     第3轮[1,2,3] - [6,9,8,5,7]剩余最小数array[6]=5.交换6和5
     第4轮[1,2,3,5] - [9,8,6,7]剩余最小数array[6]=6.交换9和6
     第5轮[1,2,3,5,6] - [8,9,7]剩余最小数array[7]=7.交换8和7
     第6轮[1,2,3,5,6,7] - [9,8]剩余最小数array[7]=8.交换9和8
     第7轮,[1, 2, 3, 5, 6, 7, 8, 9],剩余最小数array[7]=9.没有需要交换
     循环次数forTimes = 28
     发生交换次数swapTimes = 7
     排序数组:[1, 2, 3, 5, 6, 7, 8, 9]
     */
}
