package com.epam.rd.autotasks;

public class CarouselRun {
    int position = 0;
    int k = 1;
    int version;

    public CarouselRun(int i) {
        version=1;
    }

    public CarouselRun() {}


    public int next () {

        //Looking for not zero element
        while (DecrementingCarousel.carousel[position] == 0 && !isFinished()) {
            position = carouselReposit(position);
        }

        int element = DecrementingCarousel.carousel[position];

        if (!isFinished()) {
            int next = element;
            if(version != 1) {
                next--;
            } else{
                next = next - k;
                if (next < 0 ){next=0;}
            }
            DecrementingCarousel.carousel[position] = next;
            position = carouselReposit(position);
        } else element = -1;
        return element;

    }

    public boolean isFinished () {
        boolean result;
        int j = 0;
        for (int i = 0; i <= DecrementingCarousel.carousel.length - 1; i++) {
            if (DecrementingCarousel.carousel[i] <= 0) {
                j++;
            }
        }
        if (j == DecrementingCarousel.carousel.length) {
            result = true;
        } else result = false;
        return result;
    }

    public int carouselReposit ( int position){
        if (position + 1 == DecrementingCarousel.carousel.length) {
            position = 0;
            k++;
        } else position++;
        return position;
    }

}
