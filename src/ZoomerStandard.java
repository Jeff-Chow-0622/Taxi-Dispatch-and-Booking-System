/**
 * ZoomerStandard is a child class of ZoomerVehicle
 * it has a limited distance up to 20 km and can only accommodate up to four passengers.
 * It has specific fees based on usual and peak times ( $2 for usual and $4 for peak time).
 */
public class ZoomerStandard extends ZoomerVehicle
{
    private final static int limitKm = 20;
    private final static int ususalFee = 2; // $ per Km
    private final static int peakFee = 4; // $ per Km

    /**
     * Default constructor which creates the object of the class ZoomerStandard.
     */
    public ZoomerStandard()
    {
        super();
    }

    /**
     * Non-Default constructor which creates the object of the class ZoomerStandard.
     *
     * @param registrationNumber  Accepts the car ID as an integer.
     * @param make    Accepts the brands of the vehicle.
     * @param vehicleType Accepts the category of the vehicle.
     *
     */
    public ZoomerStandard(int registrationNumber, String make, VehicleCategory vehicleType) {
        super(registrationNumber, make, vehicleType);
    }

    /**
     * Accessor method to get the category
     * @return vehicle category(Standard)
     */
    @Override
    public VehicleCategory getVehicleType()
    {
        return VehicleCategory.STANDARD;
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
}



