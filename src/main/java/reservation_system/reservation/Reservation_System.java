package reservation_system.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reservation_system.booking.Booking_Service;
import reservation_system.passenger.Passenger;
import reservation_system.train.Train;

/*
 * Reservation_System implements the Booking_Service interface.
 * It handles train addition, ticket booking, ticket cancellation, and viewing available trains.
 */
public class Reservation_System implements Booking_Service 
{
    // List of all trains in the system
    private List<Train> trains = new ArrayList<Train>();

    // Map of train number to list of booked passengers for that train
    private Map<Integer, List<Passenger>> bookings = new HashMap<>();

    /*
     * Adds a new train to the system and initializes its booking list.
     */
    public void addTrain(Train train) 
    {
        trains.add(train);
        bookings.put(train.getTrainNumber(), new ArrayList<Passenger>());
    }

    /*
     * Displays all available trains along with their details and available seats.
     */
    public void showAvailableTrains() 
    {
        for (Train train : trains) 
        {
            train.showTrainInfo();
        }
    }

    /*
     * Private helper method to find a train by its number.
     */
    private Train findTrain(int trainNo) 
    {
        for (Train train : trains) 
        {
            if (train.getTrainNumber() == trainNo) 
            {
                return train;
            }
        }
        return null;
    }

    /*
     * Books a ticket for the specified passenger on the given train number.
     */
    @Override
    public void bookTicket(int trainNo, Passenger p) 
    {
        Train train = findTrain(trainNo);

        // Book only if train exists and seats are available
        if (train != null && train.getAvailableSeats() > 0) 
        {
            bookings.get(trainNo).add(p);  // Add passenger to booking list
            train.reduceSeat();            // Decrease seat count
            System.out.println("\nRAIN TICKET BOOKED SUCCESSFULLY");
        }
        else 
        {
            System.out.println("\n Booking Failed: No available seats or train not found");
        }
    }

    /**
     * Cancels a ticket using train number and passenger ID.
     */
    @Override
    public void cancelTicket(int trainNo, int passengerId)
    {
        List<Passenger> passengerList = bookings.get(trainNo);
        Train train = findTrain(trainNo);

        // Proceed only if train and passenger list exist
        if (passengerList != null && train != null) 
        {
            Iterator<Passenger> iterator = passengerList.iterator();

            while (iterator.hasNext())
            {
                Passenger p = iterator.next();
                if (p.getPassengerId() == passengerId) 
                {
                    iterator.remove();    // Remove passenger from booking list
                    train.increaseSeat(); // Restore seat
                    System.out.println("\n TICKET SUCCESSFULLY CANCELLED FOR PASSENGER ID: " + passengerId);
                    return;
                }
            }
            System.out.println("\n Passenger ID not found in booking list.");
        } 
        else
        {
            System.out.println("\n Cancellation Failed: Train not found or no bookings exist.");
        }
    }
}
