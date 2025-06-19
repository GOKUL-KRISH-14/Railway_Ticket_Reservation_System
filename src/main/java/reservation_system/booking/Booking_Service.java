package reservation_system.booking;

import reservation_system.passenger.Passenger;

/*
 * Booking_Service interface defines the core operations for the Railway Reservation System.
 * It provides method signatures for booking and canceling train tickets.
 * This interface is implemented by the Reservation_System class.
 */
public interface Booking_Service {

    /*
     * Books a ticket for the given passenger on the specified train.
     */
   public void bookTicket(int trainNo, Passenger p);

    /*
     * Cancels a booked ticket for a passenger using train number and passenger ID.
     */
    public void cancelTicket(int trainNo, int passengerId);
}
