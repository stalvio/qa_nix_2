package ua.com.alevel.entity;

public class Mars extends BasePlanet {

    public Mars() {
        setMass(6.4 * Math.pow(10, 23));
        setRadius(3397000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
