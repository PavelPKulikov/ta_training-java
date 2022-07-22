package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Quadrilateral extends Figure{
    Point pointA;
    Point pointB;
    Point pointC;
    Point pointD;

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        if ((area() != 0) && isConvex() && isntDegenerate()){
            //the area isn't 0 and quadrilateral is convex
        } else throw new IllegalArgumentException();
    }

    private boolean isConvex(){
        double areaABC = new Triangle(pointA, pointB, pointC).area();
        double areaADC = new Triangle(pointA, pointD, pointC).area();
        double areaABD = new Triangle(pointA, pointB, pointD).area();
        double areaCBD = new Triangle(pointA, pointB, pointC).area();
        if (areaABC + areaADC == areaABD + areaCBD) return true; else return false;
    }
    private boolean isntDegenerate(){
        double AB = sqrt(pow((pointB.getX()- pointA.getX()), 2)+pow((pointB.getY()- pointA.getY()), 2));
        double BC = sqrt(pow((pointC.getX()- pointB.getX()), 2)+pow((pointC.getY()- pointB.getY()), 2));
        double CD = sqrt(pow((pointD.getX()- pointC.getX()), 2)+pow((pointD.getY()- pointC.getY()), 2));
        double DA = sqrt(pow((pointA.getX()- pointD.getX()), 2)+pow((pointA.getY()- pointD.getY()), 2));
        if (AB+BC+CD > DA && BC+CD+DA > AB && CD+DA+AB >BC && DA+AB+BC > CD) return true; else return false;
    }


        @Override
    public String pointsToString() {
        return "("+pointA.toString()+")("+pointB.toString()+")("+pointC.toString()+")("+pointD.toString()+")";
    }

    @Override
    public Point leftmostPoint() {
        double xMin = Math.min(pointD.getX(), Math.min(pointC.getX(), Math.min(pointA.getX(), pointB.getX())));
        if (xMin == pointA.getX()) return pointA;
            else if (xMin == pointB.getX()) return pointB;
               else if (xMin == pointC.getX()) return pointC;
                   else return pointD;

        }


    @Override
    public double area() {
        return Math.abs((pointA.getX()-pointB.getX()) * (pointA.getY()+pointB.getY()) + (pointB.getX()-pointC.getX()) * (pointB.getY()+pointC.getY())+(pointC.getX()-pointD.getX()) * (pointC.getY()+pointD.getY())+(pointD.getX()-pointA.getX()) * (pointD.getY()+pointA.getY()))/2;
    }

    public Point centroid(){

        Point midAB = middle(pointA, pointB);
        Point midDC = middle(pointD, pointC);
        Point midBC = middle(pointB, pointC);
        Point midAD = middle(pointA, pointD);

        return intersection(midAB, midDC, midBC, midAD);

    }

    Point middle(Point vert1, Point vert2) {
        return new Point((vert1.getX()+ vert2.getX())/2,(vert1.getY()+ vert2.getY())/2);

    }

    Point intersection(Point midAB, Point midDC, Point midBC, Point midAD) {

        Point point;
        if ((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()) != 0){
            double xPoint = (((midAB.getX()*midDC.getY()-midAB.getY()*midDC.getX())*(midBC.getX()- midAD.getX())-(midAB.getX()-midDC.getX())*(midBC.getX()* midAD.getY()-midBC.getY()*midAD.getX())))/((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()));
            double yPoint = (((midAB.getX()*midDC.getY()-midAB.getY()*midDC.getX())*(midBC.getY()- midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()* midAD.getY()-midBC.getY()*midAD.getX())))/((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()));
            int checkPoint = (int) (((xPoint-midAB.getX())*(midDC.getY()-midAB.getY()))-((yPoint-midAB.getY())*(midDC.getX()-midAB.getX())));
            int checkPointAnother = (int) (((xPoint-midBC.getX())*(midAD.getY()-midBC.getY()))-((yPoint-midBC.getY())*(midAD.getX()-midBC.getX())));
            if (checkPoint == 0 && checkPointAnother == 0){
                if(xPoint >= midAB.getX() && xPoint <= midDC.getX() || xPoint >= midDC.getX() && xPoint <= midAB.getX()){
                    if (xPoint >= midBC.getX() && xPoint <= midAD.getX() || xPoint >= midAD.getX() && xPoint <= midBC.getX()){
                        point = new Point(xPoint, yPoint); //Все проверки прошли
                    }else{
                        point = null; //Координата X 2-го отрезка не попала в диапазон
                    }
                } else {
                    point = null; //Координата X 1-го отрезка не попала в диапазон
                }
            } else {
                point = null; //Не прошла проверка двух векторов
            }
        } else {
            point = null; //Не прошла проверка знаменателя
        }
        return point;
    }

}
