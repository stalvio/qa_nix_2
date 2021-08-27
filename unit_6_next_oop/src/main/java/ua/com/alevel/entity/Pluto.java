package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Pluto extends BasePlanet {

    public Pluto() {
        super(new BigDecimal(1.3 * Math.pow(10, 22)), new BigDecimal(1195000));
    }
}
