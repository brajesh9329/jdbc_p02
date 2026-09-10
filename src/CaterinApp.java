import Entity.Booking;
import Entity.Customer;
import Entity.FoodItems;
import Service.BookingService;
import Service.CustomerService;
import Service.FoodService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CaterinApp {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        FoodService foodService = new FoodService();
        BookingService bookingService = new BookingService();


        while (true) {

            System.out.println("\n========== FOOD CATERING SYSTEM ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. Show Customers");
            System.out.println("3. Find Customer By Phone");
            System.out.println("4. Add Food");
            System.out.println("5. Show Food Menu");
            System.out.println("6. create booking ");
            System.out.println("7. Add Food to Booking");
            System.out.println("8. Show All Bookings");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                // ---------------- CUSTOMER ----------------

                case 1:

                    System.out.println("Enter customer name:");
                    String name = sc.next();

                    System.out.println("Enter phone:");
                    String phone = sc.next();

                    System.out.println("Enter address:");
                    String address = sc.next();

                    Customer customer =
                            new Customer(0, name, phone, address);

                    customerService.addCustomer(customer);

                    System.out.println("Customer added successfully!");

                    break;


                case 2:

                    List<Customer> customers =
                            customerService.getAllCustomer();

                    System.out.println("\n---------- CUSTOMERS ----------");

                    for (Customer c : customers) {
                        System.out.println(c);
                    }

                    break;


                // ---------------- FIND CUSTOMER ----------------

                case 3:

                    System.out.println("Enter customer phone number:");
                    String customerPhone = sc.next();

                    Customer foundCustomer =
                            customerService.getCustomerBasedOnNumber(customerPhone);

                    if (foundCustomer != null) {
                        System.out.println("\nCustomer Found:");
                        System.out.println(foundCustomer);
                    } else {
                        System.out.println("Customer not found!");
                    }

                    break;


                // ---------------- FOOD ----------------

                case 4:

                    System.out.println("Enter food name:");
                    String foodName = sc.next();

                    System.out.println("Enter price per plate:");
                    int price = sc.nextInt();

                    FoodItems food =
                            new FoodItems(0, foodName, price);

                    foodService.addFood(food);

                    System.out.println("Food added successfully!");

                    break;


                case 5:

                    List<FoodItems> foods =
                            foodService.getAllFood();

                    System.out.println("\n---------- FOOD MENU ----------");

                    for (FoodItems f : foods) {
                        System.out.println(f);
                    }

                    break;


                // ---------------- BOOKING FOOD ----------------



                // ---------------- CREATE BOOKING ----------------

                case 6:

                    System.out.println("Enter customer ID:");
                    int customerId = sc.nextInt();

                    System.out.println("Enter event date (yyyy-mm-dd):");
                    String dateInput = sc.next();

                    Date eventDate = Date.valueOf(dateInput);

                    System.out.println("Enter number of guests:");
                    int guestCount = sc.nextInt();

                    System.out.println("Enter total amount:");
                    double totalAmount = sc.nextDouble();

                    Booking booking =
                            new Booking(
                                    0,
                                    customerId,
                                    eventDate,
                                    guestCount,
                                    totalAmount
                            );

                    bookingService.addBooking(booking);

                    System.out.println("Booking created successfully!");

                    break;

                case 7:

                    System.out.println("Enter booking ID:");
                    int bookingId = sc.nextInt();

                    System.out.println("Enter food ID:");
                    int foodId = sc.nextInt();

                    System.out.println("Enter quantity:");
                    int quantity = sc.nextInt();

                    bookingService.addFoodToBooking(
                            bookingId,
                            foodId,
                            quantity
                    );

                    System.out.println("Food added to booking successfully!");

                    break;


                // ---------------- SHOW BOOKINGS ----------------

                case 8:

                    List<Booking> bookings =
                            bookingService.getAllBookings();

                    System.out.println("\n---------- BOOKINGS ----------");

                    for (Booking b : bookings) {
                        System.out.println(b);
                    }

                    break;


                // ---------------- EXIT ----------------

                case 9:

                    System.out.println(
                            "Thank you for using Food Catering System!"
                    );

                    sc.close();
                    System.exit(0);

                    break;


                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}