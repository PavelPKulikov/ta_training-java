package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {

    public static void main(String[] args) throws IOException {
        String[] strangerName = new String[100];
        Scanner scan = new Scanner(System.in);
        int qStrangers = scan.nextInt();
        if (qStrangers > 0) {
            int i = 0;
            for (i = 0; i < qStrangers; i++) {
                Scanner scan1 = new Scanner(System.in);
                strangerName[i] = scan1.nextLine();
            }
            for (i = 0; i < qStrangers; i++) {
                System.out.println("Hello, " + strangerName[i]);
            }
        } else {
            if (qStrangers == 0) {
                System.out.println("Oh, it looks like there is no one here");
            } else {
                System.out.println("Seriously? Why so negative?");
            }

        }





    }
}
