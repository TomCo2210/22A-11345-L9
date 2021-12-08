package dev.tomco.firebaseexample;

public class Car {
    private String model = "";
    private String licensePlate = "";
    private String color = "";
    private int year = 0;
    private double fuel = 0.0;
    private boolean isManual = false;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Car setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Car setYear(int year) {
        this.year = year;
        return this;
    }

    public double getFuel() {
        return fuel;
    }

    public Car setFuel(double fuel) {
        this.fuel = fuel;
        return this;
    }

    public boolean isManual() {
        return isManual;
    }

    public Car setManual(boolean manual) {
        isManual = manual;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", fuel=" + fuel +
                ", isManual=" + isManual +
                '}';
    }
}
