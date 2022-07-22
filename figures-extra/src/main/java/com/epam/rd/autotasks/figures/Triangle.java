package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle extends Figure {
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;

        if (nullCheck() && isntDegenerate() && area() != 0){
            //Triangle don't degenerative & the area isn't 0
        } else throw new IllegalArgumentException();
    }
    private boolean isntDegenerate(){
        double AB = sqrt(pow((pointB.getX()- pointA.getX()), 2)+pow((pointB.getY()- pointA.getY()), 2));
        double BC = sqrt(pow((pointC.getX()- pointB.getX()), 2)+pow((pointC.getY()- pointB.getY()), 2));
        double CA = sqrt(pow((pointA.getX()- pointC.getX()), 2)+pow((pointA.getY()- pointC.getY()), 2));
        if (AB+BC > CA && BC+CA > AB && CA+AB > BC) return true; else return false;
    }

    double area() {
        return Math.abs((pointB.getX()-pointA.getX()) * (pointC.getY()-pointA.getY()) - (pointC.getX()-pointA.getX()) * (pointB.getY()-pointA.getY()))/2;
    }
    @Override
    public Point centroid(){
        return new Point((pointA.getX()+ pointB.getX()+pointC.getX())/3,(pointA.getY()+ pointB.getY()+pointC.getY())/3);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        double areaDelta = Math.abs(area() - ((Triangle) figure).area());
        double centroidDeltaX = Math.abs(centroid().getX() - figure.centroid().getX());
        double centroidDeltaY = Math.abs(centroid().getY() - figure.centroid().getY());
        if(getClass() == figure.getClass() &&  areaDelta < ERROR_DELTA && centroidDeltaX < ERROR_DELTA && centroidDeltaY < ERROR_DELTA) return true; else return false;
    }


    private boolean nullCheck(){
        if(pointA != null && pointB != null && pointC != null) return true; else return false;
    }

}
