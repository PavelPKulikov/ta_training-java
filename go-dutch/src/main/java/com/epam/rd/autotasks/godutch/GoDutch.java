package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int allAmount = scan.nextInt();
        int quantityOfFr = scan.nextInt();
        if (allAmount >= 0 && quantityOfFr >0){
            int everyAmount = (int) (allAmount * 1.1)/quantityOfFr;
            System.out.println(everyAmount);
        } else if (quantityOfFr <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            System.out.println("Bill total amount cannot be negative");
        }
    }
}
