package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Neptune extends BasePlanet {

    public Neptune() {
        super(new BigDecimal(1.02 * Math.pow(10, 26)), new BigDecimal(24766000));
    }
}
