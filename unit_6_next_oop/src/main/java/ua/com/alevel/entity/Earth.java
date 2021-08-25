package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public final class Earth extends BasePlanet {

    public Earth() {
        setMass(new BigDecimal(5.97 * Math.pow(10, 24)));
        setRadius(new BigDecimal(6371000));
    }

}
