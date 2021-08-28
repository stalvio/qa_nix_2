package ua.com.alevel.entity;

import ua.com.alevel.service.Planet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BasePlanet implements Planet {

    private BigDecimal planetMass;
    private BigDecimal planetRadius;
    protected final BigDecimal GRAVITATION_CONST = new BigDecimal(6.67 * Math.pow(10, -11));

    public BasePlanet(BigDecimal mass, BigDecimal radius) {
        this.planetMass = mass;
        this.planetRadius = radius;
    }

    public BigDecimal getMASS() {
        return planetMass;
    }

    public BigDecimal getRADIUS() {
        return planetRadius;
    }

    public BigDecimal getGravitationConst() {
        return GRAVITATION_CONST;
    }

    public BigDecimal getAccelerationOfGravity() {
        BigDecimal accOfGrav = getMASS().multiply(GRAVITATION_CONST).divide(getRADIUS().pow(2), 2, RoundingMode.HALF_UP);
        return accOfGrav;
    }
}
