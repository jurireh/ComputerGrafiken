package cgg.a05;

import cgtools.*;

public interface Material {

    public Color emmission(Ray r, Hit h);

    public Color albedo(Ray r, Hit h);

    public Ray reflectedRay(Ray r, Hit h);
}
