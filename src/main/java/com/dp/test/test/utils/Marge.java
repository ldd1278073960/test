package com.dp.test.test.utils;

import java.util.Arrays;

/**
 * @author Ldp
 * @date 2020/8/31
 * 归并算法
 */
public class Marge {

    // 迭代算法
    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        // 将数组的长度分为2个
        int middle = arr.length / 2;

        // 将数组从0索引到 arr.length/2索引 复制成一个新的数组
        int[] left = Arrays.copyOfRange(arr, 0, middle);

        //将arr.length/2索引 到 arr.length索引复制成一个新的数组
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        // 通过递归将两个数组进行比较并且从小到大排序
        return merge(sort(left), sort(right));
    }

    protected static int[] merge(int[] left, int[] right) {
        // 将两个数组的长度加起来,获得一个总长度的空数组
        int[] result = new int[left.length + right.length];
        int i = 0;
        // 判断左数组和右数组的长度都不等于0才符合条件
        while (left.length > 0 && right.length > 0) {
            // 判断左数组0索引的值是否小于等于右数组索引0的值
            if (left[0] <= right[0]) {
                // 将左数组的0索引的值赋值给 i++ 索引的位置
                result[i++] = left[0];
                // 将左数组从1索引到总长度索引截取赋值给左数组
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                // 将右数组的0索引的值赋值给 i++ 索引的位置
                result[i++] = right[0];
                // 将右数组从1索引到总长度索引截取赋值给右数组
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        // 如果左数组的长度大于0
        while (left.length > 0) {
            // 把左数组0索引位置的值赋值给result[i++] 的索引位置
            result[i++] = left[0];
            // 将左数组从1索引到总长度索引截取赋值给左数组
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        // 如果右数组的长度大于0
        while (right.length > 0) {
            // 把右数组0索引位置的值赋值给result[i++] 的索引位置
            result[i++] = right[0];
            // 将右数组从1索引到总长度索引截取赋值给右数组
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }



    // 递归法
    public static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {

        // 开始索引: 从哪个索引的位置开始
        // 结束索引: 到哪个索引的位置结束

        // 如果开始索引大于结束索引,则终止递归
        if (start >= end){
            return;
        }

        // 计算出 结束索引 - 开始索引 的值
        int len = end - start;
        //
        int mid = (len/2) + start;
        int start1 = start;
        int start2 = mid + 1;
        merge_sort_recursive(arr, result, start1, mid);
        merge_sort_recursive(arr, result, start2, end);
        int k = start;

        while (start1 <= mid && start2 <= end){
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }

        while (start1 <= mid){
            result[k++] = arr[start1++];
        }

        while (start2 <= end){
            result[k++] = arr[start2++];
        }

        for (k = start; k <= end; k++){
            arr[k] = result[k];
        }
    }

    public static void merge_sort1(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }


}
