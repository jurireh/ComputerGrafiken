package cgg.a07;

import cgtools.*;

public class Transform {
    protected Matrix toWorld;
    protected Matrix fromWorld;
    protected Matrix toWorldN;


    public Transform(Matrix toWorld){
        this.toWorld = toWorld;
        this.fromWorld = Matrix.invert(toWorld);
        this.toWorldN = Matrix.transpose(fromWorld);
    }

    public Ray transform(Ray r){
       return new Ray(Matrix.multiply(fromWorld, r.x0()),Matrix.multiply(fromWorld, r.d()),r.tmin(),r.tmax());
    }
    
    public Hit transform(Hit h){
        return new Hit(h.t(), Matrix.multiply(toWorld, h.x()), Matrix.multiply(toWorldN, h.n()),h.u(),h.v(),h.material());
    }
}
