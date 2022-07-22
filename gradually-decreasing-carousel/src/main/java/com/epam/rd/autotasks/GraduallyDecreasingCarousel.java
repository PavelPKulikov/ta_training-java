package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
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
