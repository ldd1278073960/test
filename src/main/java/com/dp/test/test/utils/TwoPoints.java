package com.dp.test.test.utils;

/**
 * @author Ldp
 * @date 2020/8/31
 * 二分查找算法
 */
public class TwoPoints {

    // 二分查找
    public static void twoPoints(){
        // 注意: 二分查找的数组必须是有序的
        int[] arr = {1, 3, 5, 6, 8, 10, 11, 12};
        int value = 12;
        //int index = binarySearch1(value, arr);
        int index = binarySearch2(value,0,arr.length-1,arr);
        if (index == -1) {
            System.out.println("没有查到数据");
        } else {
            System.out.println("查询成功：当前索引为" + index);
        }
    }

    /**
     * 递归方式
     */
    public static int binarySearch2(int value, int fromIndex, int toIndex, int[] arr) {
        int min = fromIndex; // 从第几个索引开始
        int max = toIndex; // 最大索引是多少
        int mid = (min + max) / 2; // 将最小索引和最大索引相加等于中间索引
        int value1 = arr[mid]; // 取出中间索引

        // 传过来的值 是否小于最小索引的值   是否大于最大索引的值   最小索引是否大于最大索引
        if (value < arr[min] || value > arr[max] || min > max) {
            return -1;
        }

        // 传值是否等于中间索引的值
        if (value == value1) {
            return mid;
        } else if (value < value1) { //如果小于中间索引的值
            max = mid - 1; // 最大索引等于中间索引 -1
            return binarySearch2(value, min, max, arr);
        } else { // 如果大于中间索引的值
            min = min + 1; // 最小值等于中间索引 +1
            return binarySearch2(value, min, max, arr);
        }
    }

}
