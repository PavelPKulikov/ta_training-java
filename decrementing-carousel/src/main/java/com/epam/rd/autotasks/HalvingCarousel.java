package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    int position = 0;

    public HalvingCarousel(int capacity) {
        super(capacity);
    }


//    public int next() {
//
//        //Looking for not zero element
//        while (DecrementingCarousel.carousel[position] == 0 && !isFinished()){
//            position = carouselReposit(position);
//        }
//
//        int element = DecrementingCarousel.carousel[position];
//
//        if (!isFinished() ) {
//            int next = element;
//            next = next % 2;
//            DecrementingCarousel.carousel[position] = next;
//            position = carouselReposit(position);
//        } else element = -1;
//        return element;
//
//    }
}
