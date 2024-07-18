package cgg.a07;
import java.util.ArrayList;

import cgtools.*;

public class Camera{
    protected Point x0;
    protected double oeffnungswinkel;
    protected double width;
    protected double height;
    protected ArrayList<Matrix> a;
    protected Direction d;


    public Camera(double oeffnungswinkel,  double width, double height,ArrayList<Matrix> a){
        this.oeffnungswinkel = oeffnungswinkel;
        this.width = width;
        this.height = height;
        this.a = a;
        x0 = new Point(0, 0, 0);
    }

    public Ray generateRay(double xp, double yp){
        double x = xp - width/2;
        double y = -(yp-height/2);
        double z = -(width/2)/ Math.tan(oeffnungswinkel/2);
        d = Vector.normalize(new Direction(x,y,z));
        Direction u = d;
        Point v = x0;
        for(Matrix m : a){
           u =  Matrix.multiply(m,u);
           v = Matrix.multiply(m, v);
        }
        return new Ray(v, u, 0, Double.POSITIVE_INFINITY);
    }
}

