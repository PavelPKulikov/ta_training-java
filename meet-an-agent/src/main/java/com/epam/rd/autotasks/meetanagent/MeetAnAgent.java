package com.epam.rd.autotasks.meetanagent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        int pwdIn = scanner.nextInt();
          if (pwdIn != PASSWORD) {
            System.out.println("Access denied");
        } else {
            System.out.println("Hello, Agent");
        }

    }
}
