package com.epam.rd.autotasks;



import static com.epam.rd.autotasks.Direction.*;

public class main {
    public static void main(String[] args) {
        /*arguments(45, N, NW),
                arguments(45, N, NE),
                arguments(45, NE, N),

                arguments(45, S, SE),
                arguments(45, SE, E),
                arguments(45, E, SE),*/

        System.out.println(NE.differenceDegreesTo(NW));
        System.out.println(NW.differenceDegreesTo(NE));

    }
}
