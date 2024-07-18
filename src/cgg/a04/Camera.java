package cgg.a04;
import cgtools.*;

public class Camera{
    protected Point x0;
    protected double oeffnungswinkel;
    protected double width;
    protected double height;

    public Camera(double oeffnungswinkel,  double width, double height){
        this.oeffnungswinkel = oeffnungswinkel;
        this.width = width;
        this.height = height;
        x0 = new Point(0, 0, 0);
    }

    public Ray generateRay(double xp, double yp){
        double x = xp - width/2;
        double y = -(yp-height/2);
        double z = -(width/2)/ Math.tan(oeffnungswinkel/2);
        return new Ray(x0, Vector.normalize(new Direction(x,y,z)), 0, Double.POSITIVE_INFINITY);
    }
}

