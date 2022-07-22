package com.epam.rd.autotasks;

public class Carouse3 {
    public static void main(String[] args) {


        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(5, 12);

        carousel.addElement(7);
        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());

        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());

        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());

        System.out.println(run.isFinished());
        System.out.println(run.next());
        System.out.println(run.isFinished());

    }
}

