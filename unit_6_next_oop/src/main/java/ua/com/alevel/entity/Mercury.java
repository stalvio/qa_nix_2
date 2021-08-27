package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Mercury extends BasePlanet {

    public Mercury() {
        super(new BigDecimal(3.3 * Math.pow(10, 23)), new BigDecimal(2439000));
    }
}
