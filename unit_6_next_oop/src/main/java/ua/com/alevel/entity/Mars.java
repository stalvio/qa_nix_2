package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Mars extends BasePlanet {

    public Mars() {
        super(new BigDecimal(6.4 * Math.pow(10, 23)), new BigDecimal(3397000));
    }
}
