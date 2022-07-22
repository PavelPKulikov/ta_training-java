package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {

        super(capacity);
        this.actionLimit = actionLimit;
    }


        @Override
        public CarouselRun run () {
            if (!carouselGo) {
                carouselGo = true;
                return new CarouselRun(actionLimit);
            }
            return super.run();
        }

}
