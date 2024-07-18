/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a06;

import cgg.*;
import cgtools.*;

public class Main {
     public static void main(String[] args) {
     System.out.println("Hallo2");
     Glass glass = new Glass(1,1.5,new Color(0,0,0));
     System.out.println(glass.schlick(new Direction(0.707, 0.707, 0), new Direction(0, 1, 0),1, 1.5));
     System.out.println(glass.refract(new Direction(0.707, 0.707, 0), new Direction(0, 1, 0),1,1.5));
    //  Ray ray = new Ray(new Point(0,0,0), new Direction(0, 0, -1), 0, Float.POSITIVE_INFINITY);
    //  Kugel kugel = new Kugel(new Point(0, -1, -2), 1, new Color(0, 0, 0));
    //  Hit hit = kugel.intersect(ray);
    //  System.out.println(hit);
     // This class instance defines the contents of the image.
     Image image = new Image(480, 270);

     // Write the image to disk.
     image.sample(new Raytracer(480, 270));
    
     // Write the image to disk.
     final String filename = "doc/a06-mirrors-glass-2.png";
     image.write(filename);
    System.out.println("Wrote image: " + filename);
   }
}
