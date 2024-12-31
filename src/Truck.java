package src;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {
    private double mileage;

    private final String[] truckRules = {"Minimum age of driver must be 26 years", "Driver must have a valid drivers license ", "Driver must have insurance coverage"};
    private int discount;
    private List<Integer> truckRatingsList=new ArrayList<>();
    private double truckRating;


    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double mileage,int discount) {
        super(vehicleId, model, baseRentalRate*mileage, isAvailable);
        this.mileage = mileage;
    }


    public void addRating(int star) {
        int ratingStar = Math.max(0, Math.min(star, 5));
        truckRatingsList.add(ratingStar);
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
        this.truckRating= performRatingCalculation(this.truckRatingsList);

    }

    public double getRating() {
        return truckRating;
    }

    @Override
    public double calculateRentalCost(int days){
        return days * getBaseRentalRate();
    }

    public boolean isAvailableForRental(){
        return getAvailable();

    }
    public void displayTruckRentalRules() {
        for (int i = 0; i < truckRules.length; i++) {
            System.out.println((i + 1) + ". " + truckRules[i]);
        }
    }


    @Override
    public void rent(Customer customer, int days) {
        if(!customer.hasRented() && customer.getAge()>=25 && isAvailableForRental()){
            double rentalCost = customer.getRentalHistory()>3?getBonusCost(days):calculateRentalCost(days);
            customer.customerRented(getModel(),days,rentalCost);
            System.out.println(customer.getName() + " has rented a " + getModel() + " truck for " + days + " days. #"+customer.getCustomerID()+". Price: GHC"+rentalCost);
            setAvailable(false);
        }
        else{
            System.out.println(getModel() + " isn't eligible to rent ");
        }
    }




    @Override
    public void returnVehicle(Customer customer) {
        setAvailable(true);
        customer.setHasRented(false);
        System.out.println("Truck " + getModel() + " has been returned. #"+customer.getCustomerID());
    }

    @Override
    public double getBonusCost(int history) {
        double cost = calculateRentalCost(history);
        double discount = cost * this.discount/100;
        return cost - discount;
    }

}
