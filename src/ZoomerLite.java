/**
 * ZoomerLite is a child class of ZoomerVehicle
 * it has a limited distance up to 10 km and can only accommodate one passenger.
 * It has specific fees based on usual and peak times ( $2 for usual and $4 for peak time).
 */
public class ZoomerLite extends ZoomerVehicle
{
    private final static int limitKm = 10;
    private final static int usualFee = 2; // $ per Km
    private final static int peakFee = 4; // $ per Km

    /**
     * Default constructor which creates the object of the class ZoomerLite.
     */
    public ZoomerLite()
    {
        super();
    }

    /**
     * Non-Default constructor which creates the object of the class ZoomerLite.
     *
     * @param registrationNumber  Accepts the car ID as an integer.
     * @param make    Accepts the brands of the vehicle.
     * @param vehicleType Accepts the category of the vehicle.
     *
     */
    public ZoomerLite(int registrationNumber, String make, VehicleCategory vehicleType)
    {
        super(registrationNumber, make, vehicleType);
    }

    /**
     * Accessor method to get the usual fee per km(non peak time)
     *
     * @return usual fee
     */
    @Override
    public int getUsualFee() {
        return usualFee;
    }

    /**
     * Accessor method to get the peak fee per km(peak time)
     *
     * @return peak fee
     */
    @Override
    public int getPeakFee() {
        return peakFee;
    }

    /**
     * Accessor method to get the category
     * @return vehicle category(Lite)
     */
    @Override
    public VehicleCategory getVehicleType()
    {
        return VehicleCategory.LITE;
    }

    /**
     * method that returns a string including the attributes of the object.
     *
     * @return a string including the information of vehicle
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
