package ua.com.alevel.entity;

import ua.com.alevel.service.BasePlanet;

import java.math.BigDecimal;

public class Uranus extends BasePlanet {

    public Uranus() {
        setMass(new BigDecimal(8.7 * Math.pow(10, 25)));
        setRadius(new BigDecimal(25559000));
    }
}
