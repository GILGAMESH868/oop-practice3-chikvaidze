package ua.registry;

import java.util.*;

public class Registry {
    private final Map<String, Owner> ownersById = new HashMap<>();
    private final Map<String, Car> carsByVin = new HashMap<>();
    private final Map<String, Car> carsByPlate = new HashMap<>();

    Registry() { }

    void registerOwner(Owner owner) {
        if (owner == null || owner.getId() == null) return;
        ownersById.put(owner.getId(), owner);
    }

    void registerCar(Car car) {
        if (car == null || car.getVin() == null) return;
        carsByVin.put(car.getVin(), car);
        if (car.getPlate() != null) carsByPlate.put(car.getPlate(), car);
    }

    void assignOwnerToCar(String ownerId, String vin) {
        Car car = carsByVin.get(vin);
        Owner owner = ownersById.get(ownerId);
        if (car != null && owner != null) {
            car.setOwner(ownerId);
        }
    }

    void issuePlate(String vin, String plate) {
        Car car = carsByVin.get(vin);
        if (car != null && plate != null && !plate.isBlank()) {
            car.assignPlate(plate.trim());
            carsByPlate.put(plate.trim(), car);
        }
    }

    public Optional<Car> findCarByPlate(String plate) {
        return Optional.ofNullable(carsByPlate.get(plate));
    }

    public Optional<Owner> findOwnerById(String ownerId) {
        return Optional.ofNullable(ownersById.get(ownerId));
    }

    public int ownersCount() { return ownersById.size(); }
    public int carsCount() { return carsByVin.size(); }

    @Override
    public String toString() {
        return "Registry{" +
                "owners=" + ownersById.size() +
                ", cars=" + carsByVin.size() +
                '}';
    }
}
