package ua.com.alevel.entity;

public class Uranus extends BasePlanet  {

    public Uranus() {
        setMass(8.7 * Math.pow(10, 25));
        setRadius(25559000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
