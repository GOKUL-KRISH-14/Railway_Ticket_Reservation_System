package reservation_system.booking.main;

import java.util.Scanner;
import reservation_system.passenger.Passenger;
import reservation_system.reservation.Reservation_System;
import reservation_system.train.Train;

public class Main {

    /*
     * Allows admin to add a train at runtime.
     */
    public static String adminAddTrain(Reservation_System system) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Admin Access Required]");
        System.out.print("Enter the Admin Password: ");
        String admin = scanner.next();

        if (admin.equals("admin")) 
        {
            System.out.print("\n Enter Train Number: ");
            int trainNo = scanner.nextInt();

            System.out.print("\n Enter Train Name: ");
            String trainName = scanner.next();

            System.out.print("\n Enter Source Place: ");
            String sourcePlace = scanner.next();

            System.out.print("\n Enter Destination Place: ");
            String destinationPlace = scanner.next();

            System.out.print("\n Enter Number of Available Seats: ");
            int seats = scanner.nextInt();

            system.addTrain(new Train(trainNo, trainName, sourcePlace, destinationPlace, seats));
            return "Train Added Successfully!";
        }

        return "Invalid Admin Password.";
    }

    public static void main(String[] args) 
    {
        int passengerCounter = 1;
        Scanner scanner = new Scanner(System.in);
        Reservation_System system = new Reservation_System();

        while (true) 
        {
            System.out.println("\n===== Railway Reservation System =====");
            System.out.println("1. Add Train (Admin Only)");
            System.out.println("2. Show Available Trains");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1: 
                {
                    String result = adminAddTrain(system);
                    System.out.println(result);
                    break;
                }
                case 2: 
                {
                    system.showAvailableTrains();
                    break;
                }
                case 3: {
                    System.out.print("Enter Train Number: ");
                    int trainNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();

                    Passenger p = new Passenger(name, age, gender, passengerCounter++);
                    system.bookTicket(trainNo, p);
                    break;
                }
                case 4: 
                {
                    System.out.print("Enter Train Number: ");
                    int cancelTrainNo = scanner.nextInt();

                    System.out.print("Enter Passenger ID: ");
                    int pid = scanner.nextInt();

                    system.cancelTicket(cancelTrainNo, pid);
                    break;
                }
                case 5: 
                {
                    System.out.println("Thank you for using Railway Reservation System.");
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
