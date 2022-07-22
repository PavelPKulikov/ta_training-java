package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }


    @Override
    public CarouselRun run() {
        if (!carouselGo ){
            carouselGo = true;
            return new CarouselRun(1);
        }
        return super.run();
    }

}
