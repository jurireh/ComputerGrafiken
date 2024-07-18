package cgg.a07;

import cgtools.*;

public class Texture implements Sampler {
    protected ImageTexture texture;
    
    public Texture(String filename){
        texture = new ImageTexture(filename);
    }

    public Color getColor(double u, double v){
        Color color = texture.getColor(u,v);
        return new Color(Math.pow(color.r(),2.2),Math.pow(color.g(),2.2),Math.pow(color.b(),2.2));
    }
}
