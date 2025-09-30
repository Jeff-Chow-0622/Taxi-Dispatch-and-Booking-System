/**
 * ZoomerPro is a child class of ZoomerVehicle
 * it has no limited distance but can only accommodate up to four passengers.
 * It has specific fees based on usual and peak times ( $3 for usual and $5 for peak time).
 */
public class ZoomerPro extends ZoomerVehicle
{
    private final static int ususalFee = 3; // $ per Km
    private final static int peakFee = 5; // $ per Km


    /**
     * Default constructor which creates the object of the class ZoomerPro.
     */
    public ZoomerPro()
    {
        super();
    }

    /**
     * Non-Default constructor which creates the object of the class ZoomerPro.
     *
     * @param registrationNumber  Accepts the car ID as an integer.
     * @param make    Accepts the brands of the vehicle.
     * @param vehicleType Accepts the category of the vehicle.
     *
     */
    public ZoomerPro(int registrationNumber, String make, VehicleCategory vehicleType)
    {
        super(registrationNumber, make, vehicleType);
    }

    /**
     * Accessor method to get the category
     * @return vehicle category(Pro)
     */
    @Override
    public VehicleCategory getVehicleType()
    {
        return VehicleCategory.PRO;
    }

    /**
     * Accessor method to get the usual fee per km(non peak time)
     *
     * @return usual fee
     */
    @Override
    public int getUsualFee() {
        return ususalFee;
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
     * method that returns a string including the attributes of the object.
     *
     * @return a string including the information of vehicle
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
