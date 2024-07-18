/** @author henrik.tramberend@beuth-hochschule.de */
package cgg.a01;

import cgtools.*;

// Represents the contents of an image. Provides the same color for all pixels.
public record PolkaDots(Color color, int groeße, int anzahl) implements Sampler {

  // Returns the color for the given position.
  public Color getColor(double x, double y) {

      Color color2 = Vector.hsvToRgb( new Color(x/480,1,1));
      int groeße2 = groeße/2;
      double i = Math.sqrt((groeße2 - x% groeße)*(groeße2 -x% groeße)+ (groeße2 -y% groeße)*(groeße2 -y% groeße));
      Color schwarz = new Color(0, 0, 0);
    
    if(i<= groeße2 -3 && x/groeße <= anzahl)
        return color2;
                
            
    return schwarz;
  }
}
