package com.atkehui.arithmetic;

import java.util.Arrays;

/**
 * @author eternity
 * @create 2019-11-21 10:29
 */

/**
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-2, 6, 4, 10, 3, -1, 2, -3, -2};

        System.out.println("**********排序前**********");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("**********排序后**********");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 如果一趟比较下
     * 来没有进行过交换，就说明序列有序，因此要在排序过程中设置
     * 一个标志flag判断元素是否进行过交换。从而减少不必要的比较。
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;//临时变量
        boolean flag = false;//定义一个boolean标识变量，用来判断过程中是否还有交换，用来优化代码
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {//在一趟排序中,一次都没有交换过
                break;
            } else {//如果交换过，将标识变量重置
                flag = false;
            }
        }
    }
}
