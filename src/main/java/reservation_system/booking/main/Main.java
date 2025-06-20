package reservation_system.booking.main;

import java.util.Scanner;
import reservation_system.passenger.Passenger;
import reservation_system.reservation.Reservation_System;
import reservation_system.train.Train;

public class Main {

    /**
     * Allows the admin to add a train using the shared Reservation_System instance.
     */
    public static String adminAddTrain(Reservation_System system) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n[Admin Access Required] Enter the Admin Password: ");
        String admin = scanner.next();

        // Clear leftover newline
        scanner.nextLine();

        if (admin.equals("admin")) {
            System.out.println("Enter Train Number: ");
            int trainNo = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            System.out.println("Enter Train Name: ");
            String trainName = scanner.nextLine();

            System.out.println("Enter Source Place: ");
            String sourcePlace = scanner.nextLine();

            System.out.println("Enter Destination Place: ");
            String destinationPlace = scanner.nextLine();

            System.out.println("Enter Number of Available Seats: ");
            int seats = scanner.nextInt();

            system.addTrain(new Train(trainNo, trainName, sourcePlace, destinationPlace, seats));
            return "Train Added Successfully!";
        }

        return "Invalid Admin Password.";
    }

    public static void main(String[] args) {
        int passengerCounter = 1;
        Scanner scanner = new Scanner(System.in);
        Reservation_System system = new Reservation_System(); // Shared instance

        while (true) {
            System.out.println("\n===== Railway Reservation System =====");
            System.out.println("1. Add Train (Admin Only)");
            System.out.println("2. Show Available Trains");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Show Booked Passengers");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    String result = adminAddTrain(system);
                    System.out.println(result);
                    break;
                }
                case 2: {
                    system.showAvailableTrains();
                    break;
                }
                case 3: {
                    System.out.println("Enter Train Number to Booking your seats: ");
                    int trainNo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Passenger Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Passenger Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Passenger Gender: ");
                    String gender = scanner.nextLine();

                    Passenger p = new Passenger(name, age, gender, passengerCounter++);
                    system.bookTicket(trainNo, p);
                    break;
                }
                case 4: {
                    System.out.println("Enter Train Number: ");
                    int cancelTrainNo = scanner.nextInt();

                    System.out.println("Enter Passenger ID: ");
                    int pid = scanner.nextInt();

                    system.cancelTicket(cancelTrainNo, pid);
                    break;
                }
                
                case 5:
                {
                    System.out.println("Train No to list passengers: ");
                    int listTrainNo = scanner.nextInt();
                    system.showPassengersForTrain(listTrainNo);
                    break;
                }
                case 6: {
                    System.out.println("Thank you for using the Railway Reservation System.");
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
