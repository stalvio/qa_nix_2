package ua.com.alevel.entity;

public final class Earth extends BasePlanet {

    public Earth() {
        setMass(5.97 * Math.pow(10, 24));
        setRadius(6371000);
    }

    public double getAccelerationOfGravity() {
        return (gravitationConst * getMass()) / Math.pow(getRadius(), 2);
    }
}
