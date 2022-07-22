package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int[] seq = new int[100];
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        for (String s: sequence.split(" ")) {
            seq[i] = Integer.parseInt(s);
            i++;
            if (Integer.parseInt(s) == 0) {
                break;
            }

        }
        i--;
        int sumSq = 0;
        int j = 0;
        while (j < i){
            sumSq += seq[j];
            j++;
        }
        System.out.println((int) sumSq/i);

    }

}