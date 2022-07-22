package com.epam.rd.autotasks.words;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if(sample != null && !sample.isEmpty() && words != null ){
            int i = 0;
            for (String word:words){
                    if (word.strip().compareToIgnoreCase(sample.strip()) == 0) i++;            }
            return i;} else return 0;
    }

    public static String[] splitWords(String text) {
        if (text != null){
        text = text.replaceFirst("^[ ,.;:?!]+", "");
        Pattern patForSplit = Pattern.compile("[ ,.;:?!]+");
        String [] result =  patForSplit.split(text);
        if (result[0].isEmpty()) return null; else return result;} else return null;
    }
    static Boolean pathHasError(String path) {
        Pattern rightPath = Pattern.compile("^[~/(C:)a-zA-Z.]");
        if (rightPath.matcher(path).find())
          if (!path.contains("/") || !path.contains("\\")) { //file don't has symbols /&\ at same time
                if (path.indexOf("C:", 2) == -1 && path.indexOf("~", 1) == -1) { //Symbols C: & ~ don't have in the middle
                    if (!path.matches("C:(.*)~|~(.*)\\\\(.*)|C:(.*)/"))
                        return path.matches("(.*)/{2}(.*)");
                }
          //  }
        }
        return true;
    }

    static String convertUnixWin (String path){
        if(path.indexOf("~") == 0) {
            path = path.replaceFirst("~","C:\\\\User");
        } else path = path.replaceFirst("^(/)","C:\\\\");
        path = path.replace("/","\\");
        return path;
    }

    static String convertWinUnix(String path){
        path = path.replace("C:\\User","~");
        path = path.replace("C:\\","/");
        path = path.replace("\\","/");
        return path;
    }

    public static String convertPath(String path, boolean toWin) {
        if(path != null && !path.isEmpty() && !pathHasError(path)){
        if (path.matches("[/~](.*)") || path.matches("(.*)/(.*)")){
            if (toWin){
                return convertUnixWin(path);
            } else return path;
        }else {
            if (!toWin){
                return convertWinUnix(path);
            } else return path;
        }

        } else return null;
    }

    public static String joinWords(String[] words) {
        StringBuilder joinWords = new StringBuilder("[");
        if (words != null && words.length > 0 ){
            for (String word:words) if (!word.isEmpty()){
                joinWords.append(word).append(", ");
            }
            if (joinWords.length() > 1) {
                joinWords.delete(joinWords.length()-2, joinWords.length());
                joinWords.append("]");} else return null;
            return String.valueOf(joinWords);} else return null;
    }

    public static void main(String[] args) {
        class A{
            public void f() throws IOException {}
        }
        class B extends A{
            @Override
            public void f() throws FileNotFoundException, InternalError {}
        }

//        String unixPath2 = "~\\folder";
//        String convertResult2 = convertPath(unixPath2, false);
//        System.out.println("Result: " + convertResult2);
//        String unixPath3 = "~";
//        String convertResult3 = convertPath(unixPath3, true);
//        System.out.println("Result: " + convertResult3);
//
//
//        String[] words = new String[]{"sch ool", "SCHOO L", "\tschool\t", "     schoo", "s c h o o l"};
//
//        String sample = "scHooL";
//        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
//        System.out.println("Result: " + countResult);


    }
}