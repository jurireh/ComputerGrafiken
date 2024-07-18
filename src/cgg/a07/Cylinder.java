/** @quelle https://www.cl.cam.ac.uk/teaching/1999/AGraphHCI/SMAG/node2.html#SECTION00023100000000000000 */
package cgg.a07;

import cgtools.*;
import static cgtools.Vector.*;


public record Cylinder(Point cf, double radius,double minhight, double maxhight,Material material) implements Shape{
   
        public Hit intersect(Ray r){
            Direction x0 = subtract(r.x0(),cf);
            Direction x02 = new Direction(x0.x(), 0, x0.z());
            Direction d2 = new Direction(r.d().x(),0, r.d().z());
            double a = dotProduct(d2, d2);
            double b = 2 * dotProduct( x02,d2);
            double c = dotProduct(x02, x02)- radius*radius;
            double dis = b*b - 4*a*c;
    
            if(dis >0){
                double t1 = ((-b + Math.sqrt(b*b - 4*a*c))/(2*a));
                double t2 = ((-b - Math.sqrt(b*b - 4*a*c))/(2*a));
                double z1 = x0.y() + t1 * r.d().y();
                double z2 = x0.y() + t2 * r.d().y();
                if(t1<t2 && r.isValid(t1) && minhight<z1 && z1<maxhight){
                    Direction n = divide(subtract(r.pointAt(t1), cf),radius);
                    return new Hit(t1, r.pointAt(t1),normalize( n),0,0, material);
                }
                if(t2<t1 && r.isValid(t2) && minhight<z2 && z2<maxhight){
                    Direction n = divide(subtract(r.pointAt(t2), cf),radius);
                    return new Hit(t2,r.pointAt(t2), normalize(n),0,0, material);
                }
            }
            else if (dis == 0) {
            double t3 = (-b)/(2*a);
            double z3 = x0.y() + t3 * r.d().y();
                if(t3 >= r.tmin() && t3 <= r.tmax() && minhight<z3 && z3<maxhight){
                    Direction n = divide(subtract(r.pointAt(t3), cf),radius);
                    return new Hit(t3, r.pointAt(t3),normalize( n),0,0, material);
                }
            }
            return null;
          }
}