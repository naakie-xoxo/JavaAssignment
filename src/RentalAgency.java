package src;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    // Add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    // Process a rental
    public boolean rentVehicle(String vehicleId, int days, Customer customer) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                vehicle.rent(customer, days);
                return true;
            }
        }
        System.out.println("Vehicle not available for rental.");
        return false;
    }



    // Return a vehicle
    public boolean returnVehicle(String vehicleId, Customer customer, int rating) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                vehicle.returnVehicle(customer);
                vehicle.addRating(rating);
                return true;
            }
        }
        System.out.println("Vehicle not found or already available.");
        return false;
    }

    // Generate a report of all vehicles
    public void generateReport() {
        System.out.println("Fleet Report:");
        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle.getModel() + " (ID: " + vehicle.getVehicleId() + ") - " +
                    (vehicle.getAvailable() ? "Available" : "Rented")+ " - " + vehicle.getRating()+(vehicle.getRating()>1?" Stars":" Star"));
        }
    }
}