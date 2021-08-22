package ua.com.alevel.entity;

public class Saturn extends BasePlanet {

    public Saturn() {
        setMass(5.7 * Math.pow(10, 26));
        setRadius(60268000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
