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
        if (nullCheck() && isConvex() && isntDegenerate() && (area() != 0) ){
            //the area isn't 0 and quadrilateral is convex
        } else throw new IllegalArgumentException();
    }
    @Override
    public Point centroid(){
        Point centrABC = new Triangle(pointA, pointB, pointC).centroid();
        Point centrADC = new Triangle(pointA, pointD, pointC).centroid();
        Point centrABD = new Triangle(pointA, pointB, pointD).centroid();
        Point centrCBD = new Triangle(pointC, pointB, pointD).centroid();

        return intersection(centrABC, centrADC, centrABD, centrCBD);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        double areaDelta = Math.abs(area() - ((Quadrilateral) figure).area());
        double centroidDeltaX = Math.abs(centroid().getX() - figure.centroid().getX());
        double centroidDeltaY = Math.abs(centroid().getY() - figure.centroid().getY());
        if(getClass() == figure.getClass() &&  areaDelta < ERROR_DELTA && centroidDeltaX < ERROR_DELTA && centroidDeltaY < ERROR_DELTA) return true; else return false;
    }

    private boolean nullCheck(){
        if(pointA != null && pointB != null && pointC != null && pointD != null) return true; else return false;
    }
    private boolean isConvex(){
        double areaABC = new Triangle(pointA, pointB, pointC).area();
        double areaADC = new Triangle(pointA, pointD, pointC).area();
        double areaABD = new Triangle(pointA, pointB, pointD).area();
        double areaCBD = new Triangle(pointC, pointB, pointD).area();
        if (areaABC + areaADC == areaABD + areaCBD) return true; else return false;
    }
    private boolean isntDegenerate(){
        double AB = sqrt(pow((pointB.getX()- pointA.getX()), 2)+pow((pointB.getY()- pointA.getY()), 2));
        double BC = sqrt(pow((pointC.getX()- pointB.getX()), 2)+pow((pointC.getY()- pointB.getY()), 2));
        double CD = sqrt(pow((pointD.getX()- pointC.getX()), 2)+pow((pointD.getY()- pointC.getY()), 2));
        double DA = sqrt(pow((pointA.getX()- pointD.getX()), 2)+pow((pointA.getY()- pointD.getY()), 2));
        if (AB+BC+CD > DA && BC+CD+DA > AB && CD+DA+AB >BC && DA+AB+BC > CD) return true; else return false;
    }






    double area() {
        return Math.abs((pointA.getX()-pointB.getX()) * (pointA.getY()+pointB.getY()) + (pointB.getX()-pointC.getX()) * (pointB.getY()+pointC.getY())+(pointC.getX()-pointD.getX()) * (pointC.getY()+pointD.getY())+(pointD.getX()-pointA.getX()) * (pointD.getY()+pointA.getY()))/2;
    }


    Point middle(Point vert1, Point vert2) {
        return new Point((vert1.getX()+ vert2.getX())/2,(vert1.getY()+ vert2.getY())/2);

    }

    Point intersection(Point midAB, Point midDC, Point midBC, Point midAD) {
        Point point;
        if ((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()) != 0){
            double xPoint = (((midAB.getX()*midDC.getY()-midAB.getY()*midDC.getX())*(midBC.getX()- midAD.getX())-(midAB.getX()-midDC.getX())*(midBC.getX()* midAD.getY()-midBC.getY()*midAD.getX())))/((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()));
            if(xPoint == -0) xPoint = 0;
            double yPoint = (((midAB.getX()*midDC.getY()-midAB.getY()*midDC.getX())*(midBC.getY()- midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()* midAD.getY()-midBC.getY()*midAD.getX())))/((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()));
            if(yPoint == -0) yPoint = 0;
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