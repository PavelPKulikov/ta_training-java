package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int secondsReal = seconds % 60;
        int minutes = ((seconds-secondsReal) / 60) % 60;
        int hours = ((seconds-secondsReal) / 3600);
        if (hours == 24) hours = 0;

        System.out.printf(hours + ":" + "%02d%s%02d", minutes,":",secondsReal);


    }
}
