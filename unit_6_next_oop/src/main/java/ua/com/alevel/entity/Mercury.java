package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Mercury extends BasePlanet {

    public Mercury() {
        setMass(new BigDecimal(3.3 * Math.pow(10, 23)));
        setRadius(new BigDecimal(2439000));
    }
}
