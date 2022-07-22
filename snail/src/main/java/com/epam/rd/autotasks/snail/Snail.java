package com.epam.rd.autotasks.snail;


import java.util.Scanner;

public class Snail
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();
            if ( a > b || a >= h) {
            int i = 0;
            while (h > 0) {
                i++;
                h = h - a;
                if (h <= 0){
                    break;
                }
                h = h + b;
            }
            System.out.println(i);
        } else {
            System.out.println("Impossible");
        }


    }
}
