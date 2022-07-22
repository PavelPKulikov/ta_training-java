package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

public class main {
    public static void main(String[] args) {

        Point a = new Point(0, 0);
        Point b = new Point(1, 10);
        Point c = new Point(11, 11);
        Point d = new Point(19, 2);

        final Quadrilateral abcd = new Quadrilateral(a, b, c, d);
        final Quadrilateral abcd_clone = new Quadrilateral(new Point(0, 0), new Point(1, 10), new Point(11, 11), new Point(19, 2));
        final Quadrilateral bcda = new Quadrilateral(b, c, d, a);
        final Quadrilateral badc = new Quadrilateral(b, a, d, c);
        final Quadrilateral cbad = new Quadrilateral(c, b, a, d);
        System.out.println();

        System.out.println(abcd.isTheSame(abcd_clone));
        System.out.println(abcd.isTheSame(bcda));
        System.out.println(abcd.isTheSame(badc));
        System.out.println(abcd.isTheSame(cbad));

        System.out.println(abcd_clone.isTheSame(abcd));
        System.out.println(bcda.isTheSame(abcd));
        System.out.println(badc.isTheSame(abcd));
        System.out.println(cbad.isTheSame(abcd));

    }
}
