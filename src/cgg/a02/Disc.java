package cgg.a02;
import cgtools.*;

    public record Disc(double x, double y, double radius,Color color){

        public boolean isPointInDisc(double x2, double y2){
            double i = Math.sqrt( (x2 - x) * (x2 - x) + (y2 - y) * (y2-y));
            if(i< radius)
                return true;
            else
                return false;
        }
    }
    
