package com.atkehui.arithmetic;

import java.util.Arrays;

/**
 * @author eternity
 * @create 2019-11-21 10:29
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-2, 6, 4, 10, 3, -1, 2, -3, -2};

        System.out.println("**********排序前**********");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean falg = false;//定义一个boolean变量，用来判断过程中是否还有交换，用来优化代码
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    falg = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!falg) {
                break;
            } else {
                falg = false;
            }
        }
        System.out.println("**********排序后**********");
        System.out.println(Arrays.toString(arr));
    }
}
