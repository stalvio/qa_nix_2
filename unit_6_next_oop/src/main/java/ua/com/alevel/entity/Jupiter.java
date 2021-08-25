package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Jupiter extends BasePlanet {

    public Jupiter() {
        setMass(new BigDecimal(1.9 * Math.pow(10, 27)));
        setRadius(new BigDecimal(71992000));
    }
}
