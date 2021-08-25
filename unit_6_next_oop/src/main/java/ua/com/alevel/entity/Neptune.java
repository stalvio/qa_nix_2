package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Neptune extends BasePlanet {

    public Neptune() {
        setMass(new BigDecimal(1.02 * Math.pow(10, 26)));
        setRadius(new BigDecimal(24766000));
    }
}
