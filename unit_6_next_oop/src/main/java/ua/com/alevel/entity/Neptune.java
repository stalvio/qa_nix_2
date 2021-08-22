package ua.com.alevel.entity;

public class Neptune extends BasePlanet {

    public Neptune() {
        setMass(1.02 * Math.pow(10, 26));
        setRadius(24766000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
