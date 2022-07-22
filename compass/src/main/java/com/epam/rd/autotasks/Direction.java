package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees>0) {
            while (degrees >= 360) degrees -=360;} else {
            while (degrees < 0) degrees +=360;}

        switch (degrees) {
            case 0:return Direction.N;
            case 45:return Direction.NE;
            case 90:return Direction.E;
            case 135:return Direction.SE;
            case 180:return Direction.S;
            case 225:return Direction.SW;
            case 270:return Direction.W;
            case 315:return Direction.NW;
            default: return null;
        }


    }


    public static Direction closestToDegrees(int degrees) {
        if (degrees>0) {
            while (degrees >= 360) degrees -=360;} else {
            while (degrees < 0) degrees +=360;}
        degrees = (int) (Math.round((double) degrees / 45.0))*45;
        switch (degrees) {
            case 0:return Direction.N;
            case 45:return Direction.NE;
            case 90:return Direction.E;
            case 135:return Direction.SE;
            case 180:return Direction.S;
            case 225:return Direction.SW;
            case 270:return Direction.W;
            case 315:return Direction.NW;
            default: return null;
        }

    }



        public Direction opposite() {

        switch (Direction.this){
            case E:return W;
            case N:return S;
            case W:return E;
            case S:return N;
            case NE:return SW;
            case SW:return NE;
            case NW:return SE;
            case SE:return NW;
        }
        return null;

    }

    public int differenceDegreesTo(Direction direction) {
        int result = Math.abs(this.degrees - direction.degrees);
        if (result > 180) result = 360 - result;
        return result;
    }
}
