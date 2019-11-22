package com.atkehui.arithmetic;

import java.util.Arrays;

/**
 * @author eternity
 * @create 2019-11-21 15:37
 * <p>
 * 快速排序（Quicksort）是对冒泡排序的一种改进。基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 34, 5, 2, -2, 6, -7, 9};

        System.out.println("**********排序前**********");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("**********排序后**********");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left + right) / 2];//中间值
        int temp = 0;//临时变量，用于交换
        while (l < r) {//比pivot小的值放到左边，比pivot大的值放到右边
            while (arr[l] < pivot) {//在pivot的左边一直找，找到比pivot大的或者等于pivot的值就推出循环
                l += 1;
            }
            while (arr[r] > pivot) {//在pivot的右边一直找，找到比pivot小的或者等于pivot的值就推出循环
                r -= 1;
            }
            if (l >= r) {//如果l>=r 说明pivot两边的值已经按照左边小于pivot右边大于pivot
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l] == pivot值 r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r] == pivot值 l--，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l == r ，必须l++,r--,否则会出现栈溢出；
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if (right > l){
            quickSort(arr,l,right);
        }

    }
}
