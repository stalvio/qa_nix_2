package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Venus extends BasePlanet {

    public Venus() {
        setMass(new BigDecimal(4.9 * Math.pow(10, 24)));
        setRadius(new BigDecimal(6051500));
    }
}
