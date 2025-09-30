import java.util.ArrayList;

/**
 * this is a class that represent a customer in Zoomer system.
 * it has attributes of customer number, name, and a collection of all rides that the customer has taken
 *
 */
public class Customer
{
    private int customerNumber;
    private String customerName;
    private ArrayList<RideBooking> rideBookings;  // Since a customer can have multiple ride bookings, rideBooking is an arraylist that store the rides

    /**
     * Default constructor which creates the object of the class Customer.
     */
    public Customer()
    {
        this.customerNumber = 0;
        this.customerName = "Jeff";
        this.rideBookings = new ArrayList<RideBooking>();
    }

    /**
     * non default constructor which instantiate the class Customer
     * @param customerNumber A unique customer number .
     * @param customerName The customer’s name .
     * @param rideBookings A collection(arrayList) of all rides that the customer has taken.
     */
    public Customer(int customerNumber, String customerName, ArrayList<RideBooking> rideBookings) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.rideBookings = rideBookings;
    }

    /**
     * Accessor method to get a unique customer number.
     * @return customerNumber.
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Accessor method to get customer's name.
     * @return customerName.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Accessor method to get a collection(arrayList) of all rides that the customer has taken.
     * @return  an arrayList that contain all rideBookings.
     */
    public ArrayList<RideBooking> getRideBookings() {
        return rideBookings;
    }

    /**
     * Mutator method to set customer number.
     *
     * @param customerNumber The unique number for each customer to be set.
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Mutator method to set customer name.
     *
     * @param customerName The name of customer to be set.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Mutator method to add ride booking into ride bookings list.
     *
     * @param rideBooking The ride booking to be added.
     */
    public void setRideBookings(RideBooking rideBooking) {
        this.rideBookings.add(rideBooking);
    }

    /**
     * method that returns a string including the attributes of the object.
     *
     * @return a string including the information of customer
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", rideBookings=" + rideBookings +
                '}';
    }
}
