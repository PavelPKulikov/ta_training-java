package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        int[] argue = new int[2];
        int i = 0;
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        for (String s: string.split(" ")) {
            argue[i] = Integer.parseInt(s);
            i++;
        }
        int quantityPizza = 1;
        while (quantityPizza * argue[1] % argue[0] != 0){
            quantityPizza++;
        }
        System.out.println(quantityPizza);


    }
}
