/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a04;

import cgg.*;

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
     image.sample(new Raytracer(480, 270));
    
     // Write the image to disk.
     final String filename = "doc/a04-scene.png";
     image.write(filename);
    System.out.println("Wrote image: " + filename);
   }
}
