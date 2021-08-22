package ua.com.alevel.entity;

public class Venus extends BasePlanet {

    public Venus() {
        setMass(4.9 * Math.pow(10, 24));
        setRadius(6051500);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
