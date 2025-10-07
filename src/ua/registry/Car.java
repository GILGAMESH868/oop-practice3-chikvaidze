package ua.registry;

public class Car extends BaseEntity {
    private String vin;
    private String plate;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String ownerId;
    private boolean stolen;

    public Car(String vin, String brand, String model, int year, String color) {
        this.vin = vin;
        this.setId(vin);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public void repaint(String newColor) {
        if (newColor == null || newColor.isBlank()) return;
        this.color = newColor.trim();
    }

    public void markAsStolen() { this.stolen = true; }
    public void scheduleInspection() { /* placeholder */ }

    // package-private
    void assignPlate(String plate) { this.plate = plate; }
    void setOwner(String ownerId) { this.ownerId = ownerId; }

    public String getVin() { return vin; }
    public String getPlate() { return plate; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public String getOwnerId() { return ownerId; }
    public boolean isStolen() { return stolen; }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", stolen=" + stolen +
                '}';
    }
}
