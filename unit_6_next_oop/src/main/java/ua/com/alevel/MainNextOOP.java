package ua.com.alevel;

import ua.com.alevel.entity.*;
import ua.com.alevel.util.PlanetReporter;

public class MainNextOOP {

    public static void main(String[] args) {

        PlanetReporter.print(new Earth());
        PlanetReporter.print(new Mercury());
        PlanetReporter.print(new Venus());
        PlanetReporter.print(new Mars());
        PlanetReporter.print(new Jupiter());
        PlanetReporter.print(new Saturn());
        PlanetReporter.print(new Uranus());
        PlanetReporter.print(new Neptune());
        PlanetReporter.print(new Pluto());
    }
}
