
/**
 * this is a class that represent a ride booking in Zoomer system.
 * it has attributes of a unique ride ID, a reference to the customer who has made the booking,
 * a reference to the vehicle that has been booked, the date and time of the ride
 * The start location and the destination
 * The ride distance (in km), the number of passengers
 *
 */
public class RideBooking
{
    private int rideID;
    private Customer customer;
    private ZoomerVehicle vehicle;
    private MonthDateTime bookingTime;
    private String startLocation;
    private String destination;
    private double rideDistance;
    private int numberOfPassengers;

    /**
     * Default constructor which creates the object of the class RideBooking.
     */
    public RideBooking()
    {
        this.rideID = 0;
        this.customer = null;
        this.vehicle = null;
        this.bookingTime = null;
        this.startLocation = "Clayton";
        this.destination = "the glen";
        this.rideDistance = 0.0;
        this.numberOfPassengers = 0;

    }

    /**
     * non default constructor which instantiate the class RideBooking
     * @param rideID A unique ride ID .
     * @param customer A reference to the customer who has made the booking.
     * @param vehicle A reference to the vehicle that has been booked.
     * @param bookingTime The date and time of the ride.
     * @param startLocation The start location.
     * @param destination The destination.
     * @param rideDistance The ride distance (in km).
     * @param numberOfPassengers The number of passengers.
     *
     */
    public RideBooking(int rideID, Customer customer, ZoomerVehicle vehicle, MonthDateTime bookingTime, String startLocation, String destination, double rideDistance, int numberOfPassengers)
    {
        this.rideID = rideID;
        this.customer = customer;
        this.vehicle = vehicle;
        this.bookingTime = bookingTime;
        this.startLocation = startLocation;
        this.destination = destination;
        this.rideDistance = rideDistance;
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * Accessor method to get a unique ride ID.
     * @return rideID.
     */
    public int getRideID() {
        return rideID;
    }

    /**
     * Accessor method to get a reference to the customer who has made the booking.
     * @return customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Accessor method to get a reference to the vehicle that has been booked.
     * @return vehicle.
     */
    public ZoomerVehicle getVehicle() {
        return vehicle;
    }

    /**
     * Accessor method to get the date and time of the ride.
     * @return bookingTime.
     */
    public MonthDateTime getbookingTime() {
        return bookingTime;
    }

    /**
     * Accessor method to get the start location.
     * @return startLocation.
     */
    public String getStartLocation() {
        return startLocation;
    }

    /**
     * Accessor method to get the destination.
     * @return destination.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Accessor method to get the riding distance.
     * @return rideDistance.
     */
    public double getRideDistance() {
        return rideDistance;
    }

    /**
     * Accessor method to get the number of passengers.
     * @return numberOfPassengers.
     */
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Mutator method to set ride ID.
     *
     * @param rideID The ride ID to be set.
     */
    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    /**
     * Mutator method to set customer.
     *
     * @param customer The customer to be set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    /**
     * Mutator method to set vehicle.
     *
     * @param vehicle The vehicle to be set.
     */
    public void setVehicle(ZoomerVehicle vehicle) {
        this.vehicle = vehicle;
    }


    /**
     * Mutator method to set booking time.
     *
     * @param bookingTime The booking time to be set.
     */
    public void setbookingTime(MonthDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    /**
     * Mutator method to set start location.
     *
     * @param startLocation The startLocation to be set.
     */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Mutator method to set destination.
     *
     * @param destination The destination to be set.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }


    /**
     * Mutator method to set rideDistance.
     *
     * @param rideDistance The rideDistance to be set.
     */
    public void setRideDistance(double rideDistance) {
        this.rideDistance = rideDistance;
    }


    /**
     * Mutator method to set numberOfPassengers.
     *
     * @param numberOfPassengers The numberOfPassengers to be set.
     */
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * Calculate the total cost of each ride based on the number of passengers, booking time, riding distance,
     * vehicle type.
     * @return cost.
     */
    public double totalCostPerRide( int numberOfLargeBag)
    {
        double cost = 0.0; //initialise the cost

        if (this.bookingTime.validatePeakTime())
        {
            cost = getVehicle().getPeakFee() * getRideDistance() * getNumberOfPassengers();

        }
        else
        {
            cost = getVehicle().getUsualFee() * getRideDistance() * getNumberOfPassengers();
        }

        cost += numberOfLargeBag * 5;  // a surcharge of $5 for each large bag.

        return cost;
    }

    /**
     * method that returns a string including the attributes of the ride booking class.
     *
     * @return a string including the information of ridebooking
     */
    @Override
    public String toString() {
        return "RideBooking{" +
                "rideID=" + rideID +
                ", customerID=" + customer.getCustomerNumber() + ", customer name=" + customer.getCustomerName() +
                ", vehicle=" + vehicle +
                ", bookingTime=" + bookingTime +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                ", rideDistance=" + rideDistance +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
