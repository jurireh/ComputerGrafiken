/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a02;

import cgg.*;

public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    System.out.println("Hallo");

    // This class instance defines the contents of the image.
    Image image = new Image(width, height);

    // Write the image to disk.
    image.sample(new ColoredDiscs(50));
    
    // Write the image to disk.
    final String filename = "doc/a02-discs-supersampling.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}
