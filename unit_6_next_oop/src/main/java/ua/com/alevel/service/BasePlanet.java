package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BasePlanet implements Planet {

    private BigDecimal mass;
    private BigDecimal radius;
    protected static final BigDecimal GRAVITATIONCONST = new BigDecimal(6.67 * Math.pow(10, -11));


    public BigDecimal getMass() {
        return mass;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public BigDecimal getGravitationConst() {
        return GRAVITATIONCONST;
    }

    public void setMass(BigDecimal mass) {
        this.mass = mass;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public BigDecimal getAccelerationOfGravity() {
        BigDecimal accOfGrav = getMass().multiply(GRAVITATIONCONST).divide(getRadius().pow(2), 2, RoundingMode.HALF_UP);
        return accOfGrav;
    }
}
