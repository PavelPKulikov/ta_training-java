package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        int[] seq = new int[100];
        int i = 0;
        Scanner scan = new Scanner(System.in);
        String sequence = scan.nextLine();
        for (String s: sequence.split(" ")) {
            seq[i] = Integer.parseInt(s);
            i++;
            if (Integer.parseInt(s) == 0) {
                break;
            }
        }
        i--;
        int maxSq = seq[0];
        int j = 1;
        while (j < i){
            if (seq[j]>maxSq){
                maxSq = seq[j];
            }
            j++;
        }
        return maxSq;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
