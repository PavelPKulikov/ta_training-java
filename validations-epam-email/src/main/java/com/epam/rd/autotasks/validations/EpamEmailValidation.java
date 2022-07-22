package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email != null){
        Pattern validName = Pattern.compile("[a-z]+_[a-z]+\\d*@epam.com");
        return validName.matcher(email).matches();} else return false;

    }
}





