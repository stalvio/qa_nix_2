package ua.com.alevel.service;

public class PlanetReporter {

    public static void print(Planet planet) {
        System.out.println(planet.getClass().getSimpleName() + "'s "+ planet.getAccelerationOfGravity() + "\n");
    }
}
