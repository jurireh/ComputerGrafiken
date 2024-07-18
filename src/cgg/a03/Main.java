/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a03;

import cgg.*;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public class Main {
     public static void main(String[] args) {

     System.out.println("Hallo2");

    //  Ray ray = new Ray(new Point(0,0,0), new Direction(0, 0, -1), 0, Float.POSITIVE_INFINITY);
    //  Kugel kugel = new Kugel(new Point(0, -1, -2), 1, new Color(0, 0, 0));
    //  Hit hit = kugel.intersect(ray);
    //  System.out.println(hit);
     // This class instance defines the contents of the image.
     Image image = new Image(480, 270);

     // Write the image to disk.
     image.sample(new BildKugel());
    
     // Write the image to disk.
     final String filename = "doc/a03-three-spheres.png";
     image.write(filename);
    System.out.println("Wrote image: " + filename);
   }
}
