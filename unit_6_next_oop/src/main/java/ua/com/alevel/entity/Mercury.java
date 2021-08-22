package ua.com.alevel.entity;

public class Mercury extends BasePlanet {

    public Mercury() {
        setMass(3.3 * Math.pow(10, 23));
        setRadius(2439000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
