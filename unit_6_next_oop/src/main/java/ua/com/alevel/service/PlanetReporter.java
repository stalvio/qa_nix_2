package ua.com.alevel.service;

import ua.com.alevel.entity.*;

import java.util.ArrayList;

public class PlanetReporter {

    public static void print(Planet planet) {
        System.out.println(planet.getClass().getSimpleName() +
                "'s 'Acceleration Of Gravity' is: " + planet.getAccelerationOfGravity());
    }

    public static void printAll() {
        ArrayList<Planet> allPlanets = getAllPlanets();
        for (Planet planet : allPlanets) {
            print(planet);
        }
    }

    private static ArrayList<Planet> getAllPlanets() {
        ArrayList<Planet> planets = new ArrayList<Planet>();
        planets.add(new Mercury());
        planets.add(new Venus());
        planets.add(new Earth());
        planets.add(new Mars());
        planets.add(new Jupiter());
        planets.add(new Saturn());
        planets.add(new Uranus());
        planets.add(new Neptune());
        planets.add(new Pluto());

        return planets;
    }
}
