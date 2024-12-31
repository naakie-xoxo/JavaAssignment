package src;

public class Customer {
    private String name;
    private int age;
    private String customerID;
    private String[] rentalHistory=new String[0];

    private boolean hasRented;

    public Customer(String name, int age, String customerID) {
        this.name = name;
        this.age = age;
        this.customerID = customerID;

    }

public void setName(String name) {
        this.name = name;
}
    public String getName() {
        return name;
    }
public int getAge() {
        return age;
}
public void setAge(int age) {
        this.age = age;
}
public String getCustomerID() {
        return customerID;
}
public void setCustomerID(String customerID) {
        this.customerID = customerID;
}
public int getRentalHistory() {
        return this.rentalHistory.length;
}

public void setHasRented(boolean hasRented) {
        this.hasRented = hasRented;
}

public boolean hasRented() {

        return this.hasRented;
}

public void customerRented(String car,int daysRented,double cost) {
        this.hasRented = true;
        addToRentalHistory(car,daysRented,cost);

}

public void displayRentalHistory() {
    for (int i = 0; i < this.rentalHistory.length; i++) {
        System.out.println((i + 1) + ". " + this.rentalHistory[i]);
    }
}

public void addToRentalHistory(String car, int days,double cost) {
    String[] newRentalHistory = new String[rentalHistory.length + 1];
    System.arraycopy(rentalHistory, 0, newRentalHistory, 0, rentalHistory.length);
    newRentalHistory[newRentalHistory.length - 1] = car + "-" + days+"days"+"-GHC"+cost;;
    this.rentalHistory = newRentalHistory;
}

public void currentRental() {
        if(hasRented) {
            System.out.println(rentalHistory[rentalHistory.length - 1]);
        }
        else {
            System.out.println(name+"has no current rental");
        }
}
}
