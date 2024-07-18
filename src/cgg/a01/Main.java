/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a01;

import cgg.*;
import cgtools.*;

public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    System.out.println("Hallo");

    // This class instance defines the contents of the image.
    Color color = new Color(90, 66, 80);
    Kreisscheibe kreis = new Kreisscheibe(color);
    PolkaDots polka = new PolkaDots(color, 30,20);
    ConstantColor content = new ConstantColor(color);

    // Creates an image and iterates over all pixel positions inside the image.
    Image image2 = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image2.setPixel(x, y, polka.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename2 = "doc/a01-polka-dots.png";
    image2.write(filename2);
    System.out.println("Wrote image: " + filename2);

    Image image = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image.setPixel(x, y, kreis.getColor(x, y));
      }
    }
   
    // Write the image to disk.
    
    final String filename = "doc/a01-disc.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);

    Image image3 = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image3.setPixel(x, y, polka.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename3 = "doc/a01-polka-dots.png";
    image3.write(filename3);
    System.out.println("Wrote image: " + filename2);

    Image image1 = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image1.setPixel(x, y, content.getColor(x, y));
      }
    }
    final String filename1 = "doc/a01-image.png";
    image1.write(filename1);
    System.out.println("Wrote image: " + filename1);
     
  }
}
