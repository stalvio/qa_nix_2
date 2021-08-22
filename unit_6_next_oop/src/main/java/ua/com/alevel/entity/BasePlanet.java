package ua.com.alevel.entity;

public abstract class BasePlanet implements Planet {

    private double mass;
    private double radius;
    static final double gravitationConst = 6.67 * Math.pow(10, -11);
    

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getGravitationConst() {
        return gravitationConst;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
