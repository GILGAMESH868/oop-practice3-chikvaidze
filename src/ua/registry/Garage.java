package ua.registry;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final String title;
    private final List<String> carVins = new ArrayList<>();

    public Garage(String title) { this.title = title; }

    public void park(Car car) {
        if (car == null) return;
        if (!carVins.contains(car.getVin())) carVins.add(car.getVin());
    }

    public List<String> listParkedVins() { return new ArrayList<>(carVins); }

    @Override
    public String toString() {
        return "Garage{" +
                "title='" + title + '\'' +
                ", parkedVins=" + carVins +
                '}';
    }
}
