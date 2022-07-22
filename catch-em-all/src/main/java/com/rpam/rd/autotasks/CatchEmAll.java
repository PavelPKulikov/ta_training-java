package com.rpam.rd.autotasks;

import java.awt.event.FocusEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new UnsupportedOperationException();



    public static void riskyMethod() throws Exception {
       throw exception;


    }

    public static void main(String[] args) throws Exception {
        try {
        riskyMethod();
        } catch (FileNotFoundException e){
            throw new IllegalArgumentException("Resource is missing", e);
        }catch (ArithmeticException e){
            System.err.print("ar");
        }catch (NumberFormatException e){
            System.err.print("nfe");
        } catch (IOException e){
            throw new IllegalArgumentException("Resource error", e);
        }
        }
}
