package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    Point pointA;
    Point pointB;
    Point pointC;
    public Triangle(Point a, Point b, Point c) {
        pointA = a;
        pointB = b;
        pointC = c;
        //TODO
        double AB = sqrt(pow((pointB.getX()- pointA.getX()), 2)+pow((pointB.getY()- pointA.getY()), 2));
        double BC = sqrt(pow((pointC.getX()- pointB.getX()), 2)+pow((pointC.getY()- pointB.getY()), 2));
        double CA = sqrt(pow((pointA.getX()- pointC.getX()), 2)+pow((pointA.getY()- pointC.getY()), 2));
        if (AB+BC > CA && BC+CA > AB && CA+AB > BC){
            //Triangle Ok
        } else throw new IllegalArgumentException();

    }


    public double area() {
        return abs((pointB.getX()-pointA.getX()) * (pointC.getY()-pointA.getY()) - (pointC.getX()-pointA.getX()) * (pointB.getY()-pointA.getY()))/2;
        //TODO
    }

    public Point centroid(){
        return new Point((pointA.getX()+ pointB.getX()+pointC.getX())/3,(pointA.getY()+ pointB.getY()+pointC.getY())/3);

    }

}
