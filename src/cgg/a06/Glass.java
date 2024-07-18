package cgg.a06;

import cgtools.Color;
import cgtools.Direction;
import cgtools.*;
import static cgtools.Vector.*;

public class Glass implements Material {
    protected double n1;
    protected double n2;
    protected Color albedo;

    public Glass( double n1,double n2, Color albedo){
        this.n1 = n1;
        this.n2 = n2;
        this.albedo = albedo;
    }

    @Override
    public Color albedo(Ray r, Hit h) {
       return albedo;
    }

    @Override
    public Color emmission(Ray r, Hit h) {
        return new Color(0,0,0);
    }

    @Override
    public Ray reflectedRay(Ray r, Hit h) {
        Direction n = h.n();
        if(dotProduct(h.n(), r.d())> 0){
            double nswap = n1;
            n = negate(n);
            n1 = n2;
            n2 = nswap;
        }
        if(refract(r.d(), n, n1, n2) != null){
            if(Random.random() > schlick(r.d(), n, n1, n2)){ 
                return new Ray(h.x(), refract(r.d(), n,n1,n2), 0.001, r.tmax());
            }
            else{
                return new Ray(h.x(), reflect(r.d(), n), 0.001, r.tmax());
            }
        }
        else {
            return new Ray(h.x(), reflect(r.d(), n), 0.001, r.tmax());
        }
    }

    public Direction refract(Direction d, Direction n, double n1, double n2){
        double r = n1/n2;
        double c = dotProduct(negate(n),d);
        double dis = 1- (r*r) * (1-c*c);
        if(dis<0){
            return null;
        }
        return add(multiply(r,d),multiply((r*c-Math.sqrt(dis)),n));
        }

    public double schlick(Direction d, Direction n, double n1, double n2){
      double r0 = Math.pow((n1-n2)/(n1+n2), 2);
      return r0 + ((1-r0) * Math.pow((1+ dotProduct(n, d)), 5));
    }

    public Direction reflect( Direction d , Direction n){
        Direction ra =subtract(d,multiply((2 *(dotProduct(d, n))),n));
        double x = 1;
        double y = 1;
        double z = 1;
        Direction di = new Direction(x,y,z);
        boolean whiles = false;
        Direction rs = ra;
       while(whiles == false){                 // Streuungsfaktor noch drinnen
           x = Random.random() * 2 -1 ;
           y = Random.random()* 2 -1 ;
           z = Random.random()* 2 -1 ;
           di = new Direction(x,y,z);
           rs = add(multiply(0, di),ra);
            if(Vector.length(di)> 1 ){
                if(dotProduct(rs, n) >= 0){
                whiles = true;
                }
           }
           
       }
        return rs;
    }
}
