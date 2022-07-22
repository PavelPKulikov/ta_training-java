package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length != 0) {
            int[] arrResult = new int[array.length];
            System.arraycopy(array, 0, arrResult, 1, array.length - 1);
            arrResult[0] = array[array.length - 1];
            System.arraycopy(arrResult, 0, array, 0, array.length);
        }



    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length != 0) {
            int[] arrResult = new int[array.length];
            System.arraycopy(array, 0, arrResult, shift, array.length - shift);
            for (int i = 0; i < shift; i++)
                arrResult[i] = array[array.length - shift + i];
            System.arraycopy(arrResult, 0, array, 0, array.length);
        }


    }
}
