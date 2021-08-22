package ua.com.alevel.entity;

public class Jupiter extends BasePlanet {

    public Jupiter() {
        setMass(1.9 * Math.pow(10, 27));
        setRadius(71992000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
