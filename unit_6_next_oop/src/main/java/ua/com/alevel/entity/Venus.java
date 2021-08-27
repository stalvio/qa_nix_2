package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Venus extends BasePlanet {

    public Venus() {
        super(new BigDecimal(3.3 * Math.pow(10, 23)), new BigDecimal(2439000));
    }
}
