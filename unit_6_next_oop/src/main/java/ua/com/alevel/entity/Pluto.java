package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Pluto extends BasePlanet {

    public Pluto() {
        setMass(new BigDecimal(1.3 * Math.pow(10, 22)));
        setRadius(new BigDecimal(1195000));
    }
}
