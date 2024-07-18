package cgg.a06;

import cgtools.*;
import static cgtools.Vector.*;

public record Kugel(Point cf, double radius,Material material) implements Shape{
   
        public Hit intersect(Ray r){
            Direction x0 = subtract(r.x0(),cf);
            
            double a = dotProduct(r.d(), r.d());
            double b = 2 * dotProduct( x0,r.d());
            double c = dotProduct(x0, x0)- radius*radius;
            double dis = b*b - 4*a*c;
    
            if(dis >0){
                double t1 = ((-b + Math.sqrt(b*b - 4*a*c))/(2*a));
                double t2 = ((-b - Math.sqrt(b*b - 4*a*c))/(2*a));
                if(t1<t2 && r.isValid(t1)){
                    Direction n = divide(subtract(r.pointAt(t1), cf),radius);
                    return new Hit(t1, r.pointAt(t1),normalize( n), material);
                }
                if(t2<t1 && r.isValid(t2)){
                    Direction n = divide(subtract(r.pointAt(t2), cf),radius);
                    return new Hit(t2,r.pointAt(t2), normalize(n), material);
                }
            }
            else if (dis == 0) {
            double t3 = (-b)/(2*a);
                if(t3 >= r.tmin() && t3 <= r.tmax()){
                    Direction n = divide(subtract(r.pointAt(t3), cf),radius);
                    return new Hit(t3, r.pointAt(t3),normalize( n), material);
                }
            }
            return null;
          }
}