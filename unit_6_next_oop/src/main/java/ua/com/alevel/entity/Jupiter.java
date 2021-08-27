package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Jupiter extends BasePlanet {

    public Jupiter() {
        super(new BigDecimal(1.9 * Math.pow(10, 27)), new BigDecimal(71992000));
    }
}
