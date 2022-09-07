package design.patterns.utils;

import design.patterns.strategy.*;
import design.patterns.strategy.Comparable;

import java.util.Arrays;

/**
 * 选择性排序
 * @author Ldp
 * @date 2021/11/15
 */
public class SelectionSort<T> {

    public void sort(T[] arr, Comparator<T> comparator){
        for (int i = 0; i < arr.length; i++) {
            int i1 = i;
            for (int j = i+1 ; j < arr.length; j++) {
                i1 = comparator.compareTo(arr[j],arr[i1]) == 1 ? j : i1;
            }
            swap(arr,i,i1);
        }
    }

     public void swap(T[] arr ,int i ,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
