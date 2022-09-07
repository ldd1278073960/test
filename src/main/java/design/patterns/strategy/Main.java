package design.patterns.strategy;

import design.patterns.utils.SelectionSort;

import java.util.Arrays;

/**
 * @author Ldp
 * @date 2021/11/17
 */
public class Main {

    public static void main(String[] args) {
        Dog[] arr = {new Dog(2), new Dog(3), new Dog(1)};
        SelectionSort<Dog> selectionSort = new SelectionSort<>();
        selectionSort.sort(arr, new DogSizeComparator());
        System.out.println(Arrays.toString(arr));
    }

}
