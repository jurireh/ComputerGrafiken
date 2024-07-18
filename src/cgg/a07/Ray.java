package cgg.a07;
import cgtools.*;
import static cgtools.Vector.*;

public record Ray(Point x0,Direction d, double tmin, double tmax ) {

    public Point pointAt(double t){
       return add(multiply(d, t),x0);  
    }

    public boolean isValid(double t){
        if(t<= tmax && t>= tmin)
            return true;
        return false;
    }
    
}
