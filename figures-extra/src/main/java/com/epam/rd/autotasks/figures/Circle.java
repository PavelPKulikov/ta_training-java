package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    public double rad;
    Point center;

    public Circle(Point center, double rad) {
        this.rad = rad;
        this.center = center;
        if (this.rad > 0 && this.center != null ) {//Circle Ok
        } else throw new IllegalArgumentException(); //degenerative or the area = 0
    }
    @Override
    public Point centroid(){
        return center;

    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(getClass() == figure.getClass() && Math.abs(rad - ((Circle) figure).rad ) < ERROR_DELTA && Math.abs(center.getX()- ((Circle) figure).center.getX()) < ERROR_DELTA && Math.abs(center.getY()- ((Circle) figure).center.getY()) < ERROR_DELTA) return true; else return false;
    }




    double area(){
        return Math.PI * rad*rad;
    }


}