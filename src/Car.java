package src;

import java.util.ArrayList;
import java.util.List;
public class Car extends Vehicle{
    private final String[] carRules = {"Minimum age of driver must be 25 years", "Driver must have a valid drivers license ", "Driver must have insurance coverage"};
    private double mileage;
    private final double rate=33;
    private int discount;

    private List<Integer> carRatingsList=new ArrayList<>();
    private double carRating;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double mileage,int discount) {
        super(vehicleId, model, baseRentalRate*mileage, isAvailable);
        this.mileage = mileage;
    }

    public void addRating(int star) {
        int ratingStar = Math.max(0, Math.min(star, 5));
        carRatingsList.add(ratingStar);
        this.calculateRating();
    }
    private static double performRatingCalculation(List<Integer> ratings) {
        double sum = 0;

        for (Integer rating : ratings) {
            sum += rating;
        }

        return ratings.isEmpty() ? 0 : sum / ratings.size();
    }

    private void calculateRating() {
        this.carRating= performRatingCalculation(this.carRatingsList);

    }

    public double getRating() {
        return carRating;
    }


    @Override
    public double calculateRentalCost(int days){
        return   Math.round((days * getBaseRentalRate()) * 100.0) / 100.0;

    }

    public boolean isAvailableForRental(){
        return getAvailable();

    }

    public void displayCarRentalRules() {
        for (int i = 0; i < carRules.length; i++) {
            System.out.println((i + 1) + ". " + carRules[i]);
        }
    }


    // Overriding the rent method from Vehicle
    @Override
    public void rent(Customer customer, int days) {
        if(!customer.hasRented() && customer.getAge()>=25 && isAvailableForRental()){
            double rentalCost = customer.getRentalHistory()>3?getBonusCost(days):calculateRentalCost(days);
            customer.customerRented(getModel(),days,rentalCost);
            System.out.println(customer.getName() + " has rented a " + getModel() + " car for " + days + " days. #"+customer.getCustomerID()+". Price: GHC"+rentalCost);
            setAvailable(false);
        }
        else{
            System.out.println(getModel() + " isn't eligible to rent ");
        }
    }



    // Overriding the returnVehicle method from Vehicle
    @Override
    public void returnVehicle(Customer customer) {
        setAvailable(true);
        customer.setHasRented(false);
        System.out.println("Car " + getModel() + " has been returned. #"+customer.getCustomerID());
    }

    public double getBonusCost(int history) {
        double cost = calculateRentalCost(history);
        double discount = cost * this.discount/100;
        return cost - discount;
    }


}
