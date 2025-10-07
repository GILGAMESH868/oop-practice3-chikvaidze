package ua.registry;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry();

        Owner owner1 = new Owner("OWN-001", "Georgiy", "Chikvaidze", "DL-123456",
                LocalDate.of(2008, 1, 7), "Odesa, UA");
        Owner owner2 = new Owner("OWN-002", "Iryna", "Koval", "DL-654321",
                LocalDate.of(1999, 3, 12), "Kyiv, UA");

        Car car1 = new Car("VF1AA000000000001", "Toyota", "Supra", 2020, "Black");
        Car car2 = new Car("VF1AA000000000002", "BMW", "M3", 2022, "Blue");

        registry.registerOwner(owner1);
        registry.registerOwner(owner2);
        registry.registerCar(car1);
        registry.registerCar(car2);

        registry.assignOwnerToCar(owner1.getId(), car1.getVin());
        registry.assignOwnerToCar(owner2.getId(), car2.getVin());

        registry.issuePlate(car1.getVin(), "BH1234AA");
        registry.issuePlate(car2.getVin(), "AA7777BB");

        car2.repaint("Dark Blue");
        owner1.updateAddress("Odesa, UA (new district)");

        Garage garage = new Garage("Central Depot");
        garage.park(car1);
        garage.park(car2);

        System.out.println(owner1);
        System.out.println(car1);
        System.out.println(registry);
        System.out.println("Find by plate AA7777BB -> " + registry.findCarByPlate("AA7777BB").orElse(null));
        System.out.println("Garage -> " + garage);
    }
}
