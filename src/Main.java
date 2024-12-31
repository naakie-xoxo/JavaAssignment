package src;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        RentalAgency agency = new RentalAgency();
        agency.addVehicle(new Car("CAR001", "Toyota Corolla", 34.45,true,300,15));
        agency.addVehicle(new Motorcycle("MOR0301", "Toyota Motor", 12.15,true,100,11));

        Customer customer1 = new Customer("John Doe", 25,"CU212");
        Customer customer2 = new Customer("Jane Smith", 25,"CU332");

        agency.rentVehicle("MOR0301",4,customer1);
        agency.rentVehicle("MOR0301",5,customer2);
        agency.returnVehicle("MOR0301",customer1,4);
        agency.rentVehicle("MOR0301",5,customer2);

        agency.returnVehicle("MOR0301",customer2,4);

        agency.rentVehicle("CAR001",7,customer1);
        agency.rentVehicle("CAR001",7,customer2);

        agency.returnVehicle("CAR001",customer1,3);
        agency.rentVehicle("CAR001",2,customer2);

        agency.rentVehicle("CAR001",7,customer1);
        agency.returnVehicle("CAR001",customer1,2);



        agency.generateReport();




    }
}