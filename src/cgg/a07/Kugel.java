package cgg.a07;

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
                    Point position = r.pointAt(t1);
                    Direction normal = divide(subtract(position, cf), radius);
                    double inclination = Math.acos(normal.y());
                    double azimuth = Math.PI + Math.atan2(normal.x(), normal.z());
                    double u = azimuth / (2* Math.PI);
                    double v = inclination / Math.PI;
                    return new Hit(t1, r.pointAt(t1),normalize( n),u,v, material);
                }
                if(t2<t1 && r.isValid(t2)){
                    Direction n = divide(subtract(r.pointAt(t2), cf),radius);
                    Point position = r.pointAt(t2);
                    Direction normal = divide(subtract(position, cf), radius);
                    double inclination = Math.acos(normal.y());
                    double azimuth = Math.PI + Math.atan2(normal.x(), normal.z());
                    double u = azimuth / (2* Math.PI);
                    double v = inclination / Math.PI;
                    return new Hit(t2,r.pointAt(t2), normalize(n),u,v, material);
                }
            }
            else if (dis == 0) {
            double t3 = (-b)/(2*a);
                if(t3 >= r.tmin() && t3 <= r.tmax()){
                    Direction n = divide(subtract(r.pointAt(t3), cf),radius);
                    Point position = r.pointAt(t3);
                    Direction normal = divide(subtract(position, cf), radius);
                    double inclination = Math.acos(normal.y());
                    double azimuth = Math.PI + Math.atan2(normal.x(), normal.z());
                    double u = azimuth / (2* Math.PI);
                    double v = inclination / Math.PI;
                    return new Hit(t3, r.pointAt(t3),normalize( n),u,v, material);
                }
            }
            return null;
          }
}
