package src;

public abstract class Vehicle implements Rentable,Loyalty,Rating{
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        if (vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be an empty string ");
        }
        if (model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be an empty string");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than zero");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId1) {
        if (vehicleId1.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be an empty string ");
        }
        this.vehicleId = vehicleId1;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be an empty string");
        }
        this.model = model;
    }


    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than zero");
        }
        this.baseRentalRate = baseRentalRate;
    }


    public boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    @Override
    public abstract void rent(Customer customer, int days);

    @Override
    public abstract void returnVehicle(Customer customer);

    @Override
    public abstract double getBonusCost(int history);

    @Override
    public  abstract  void addRating(int star);

    public  abstract  double getRating();
}
