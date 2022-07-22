package com.epam.rd.autotasks.figures;

abstract class Figure{
    public final double ERROR_DELTA = 0.001;

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}
