package ua.com.alevel.util;

import ua.com.alevel.entity.Planet;

public class PlanetReporter {

    public static void print(Planet planet) {
        System.out.println(planet.getAccelerationOfGravity());
    }
}
