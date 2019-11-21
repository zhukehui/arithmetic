package com.atkehui.arithmetic;

/**
 * @author eternity
 * @create 2019-11-21 11:30
 */

import java.util.Arrays;

/**
 * 选择式排序 也属于内部排序法，是从欲排序的数据中，按指定的规则选出某一元素，再依规定交换位置后达到排序的目的。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 34, 5, 2, -2, 6, -7};
        System.out.println("**********排序前**********");
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("**********排序后**********");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {//一共有多少轮排序
            int min = arr[i];//假定最小值
            int minIndex = i;//最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {//说明假定的最小值并不是最小
                    min = arr[j];//重置min
                    minIndex = j;//更新最小值的索引
                }
            }
            if (minIndex != i) {//将最小值放在arr[i],即交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
