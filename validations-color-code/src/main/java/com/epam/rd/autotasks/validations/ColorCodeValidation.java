package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color != null){
        Pattern colorCode = Pattern.compile("#[\\dA-Fa-f]{3}|#[\\dA-Fa-f]{6}");
        return colorCode.matcher(color).matches();} else return false;


        // Put your code here

    }

    public static void main(String[] args) {
        System.out.println(validateColorCode("#abc"));

    }
}





