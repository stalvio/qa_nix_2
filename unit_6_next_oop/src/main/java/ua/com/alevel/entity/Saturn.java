package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Saturn extends BasePlanet {

    public Saturn() {
        setMass(new BigDecimal(5.7 * Math.pow(10, 26)));
        setRadius(new BigDecimal(60268000));
    }
}
