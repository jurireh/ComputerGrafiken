/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a01;


import cgtools.*;

// Represents the contents of an image. Provides the same color for all pixels.
public record Kreisscheibe(Color color) implements Sampler {

  // Returns the color for the given position.
  public Color getColor(double x, double y) {
    double i = Math.sqrt((240 - x)*(240 -x)+ (135 -y)*(135 -y));
    Color schwarz = new Color(0, 0, 0);
    if(i<= 100)
     return color;
    else
     return schwarz;
  }
}
