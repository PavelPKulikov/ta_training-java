package com.epam.rd.autotasks.arrays;

import java.util.stream.IntStream;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int [] {5, 6, 7, 8, 9,5,0};

        System.out.println(sum(array));
    }

    public static int sum(int[] array) throws UnsupportedOperationException {
        int sumEven = 0;
        if (array == null) {
            return sumEven;
        } else if (array.length > 0){
            for (int arrItem:
                 array) {
                if (arrItem % 2 == 0) {
                    sumEven += arrItem;
                }
            }
        }
        return sumEven;

    }
}
