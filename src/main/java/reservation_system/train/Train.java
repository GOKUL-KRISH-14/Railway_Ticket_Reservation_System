package reservation_system.train;

/*
 * The Train class represents a train in the Railway Reservation System.
 * It encapsulates details like train number, name, source, destination,
 * total seats, and available seats.
 */
public class Train 
{

    // Unique identifier for each train
    private int trainNumber;

    // Name of the train
    private String trainName;

    // Source station
    private String source;

    // Destination station
    private String destination;

    // Total number of seats available initially
    private int totalSeats;

    // Seats currently available for booking
    private int availableSeats;

    /*
     * Constructor to initialize all fields of the train.
     * Sets available seats equal to total seats initially.
     */
    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats) 
    {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    // Getter and Setter methods for each field

    public int getTrainNumber()
    {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber)
    {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() 
    {
        return trainName;
    }

    public void setTrainName(String trainName) 
    {
        this.trainName = trainName;
    }

    public String getSource() 
    {
        return source;
    }

    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getDestination() 
    {
        return destination;
    }

    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public int getTotalSeats() 
    {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) 
    {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() 
    {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) 
    {
        this.availableSeats = availableSeats;
    }

    /**
     * Reduces available seats by 1 when a ticket is booked.
     */
    public void reduceSeat() 
    {
        availableSeats--;
    }
    
    /*
     * Increases available seats by 1 when a ticket is cancelled.
     */
    public void increaseSeat() 
    {
        availableSeats++;
    }

    /*
     * Displays the train's details in a readable format.
     */
    public void showTrainInfo() 
    {
        System.out.println("Train No: " + trainNumber + 
                           ", Name: " + trainName + 
                           ", From: " + source + 
                           ", To: " + destination + 
                           ", Seats Left: " + availableSeats);
    }
}
