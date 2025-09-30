
/**
 * this is an abstract class that represent a vehicle in Zoomer system.
 * it has attributes of a unique vehicle registration number, vehicle make, the Zoomer vehicle category (e.g. one of Lite, Standard or Pro)
 * Total kilometres driven, vehicle speed, usage times, usual fee, peak fee, money that has earned
 * In order to simulate the real world situation, I use distance divided by the car speed to get the time taken to transport passengers to the destination.
 * This class is a parent class of three sub-class.
 */
public abstract class ZoomerVehicle
{
    private int registrationNumber;
    private String make;
    private VehicleCategory vehicleType;
    private double[] totalKmDriven = new double[12]; // it has 12 elements representing 12 months
    private final static int vehicleSpeed = 35;  // km/hr
    private int[] timeOfUsage = new int[12]; // it has 12 elements representing 12 months
    private int usualFee;
    private int peakFee;
    private double[] earnMoney = new double[12]; // it has 12 elements representing 12 months

    /**
     * Default constructor which creates the object of the class ZoomerVehicle.
     */
    public ZoomerVehicle()
    {
        this.registrationNumber = 0;
        this.make = " ";
        this.vehicleType = VehicleCategory.STANDARD;
        this.totalKmDriven = new double[12];
        this.timeOfUsage = new int[12];
        this.earnMoney = new double[12];
    }

    /**
     * non default constructor which creates the type of the vehicle
     * @param vehicleType The category of the vehicle.
     */
    public ZoomerVehicle(VehicleCategory vehicleType)
    {
        this.vehicleType = vehicleType;
    }



    /**
     * Non-Default constructor which creates the object of the class ZoomerVehicle.
     *
     * @param registrationNumber  Accepts the car ID as an integer.
     * @param make    Accepts the brands of the vehicle.
     * @param vehicleType Accepts the category of the vehicle.
     *
     */
    public ZoomerVehicle(int registrationNumber, String make, VehicleCategory vehicleType)
    {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.vehicleType = vehicleType;
    }

    /**
     * Accessor method to get the array of earnings for each month
     * @return Array of earnings per month.
     */
    public double[] getEarnMoney()
    {
        return earnMoney;
    }

    /**
     * Accessor method to get the RegistrationNumber
     * @return registrationNumber
     */
    public int getRegistrationNumber()
    {
        return registrationNumber;
    }

    /**
     * Accessor method to get the brand
     * @return brand of the vehicle
     */
    public String getMake()
    {
        return make;
    }

    /**
     * Abstract method to get the category
     * @return vehicle category
     */
    public abstract VehicleCategory getVehicleType();


    /**
     * Accessor method to get the array of total km driven per month
     * @return array of totalKmDriven based on each month
     */
    public double[] getTotalKmDriven()
    {
        return totalKmDriven;
    }

    /**
     * Accessor method to get the vehicle speed
     * @return vehicle speed
     */
    public int getVehicleSpeed() {
        return vehicleSpeed;
    }

    /**
     * Accessor method to get how many times the vehicle was used per month
     * @return array of the usage time based on each month
     */
    public int[] getTimeOfUsage()
    {
        return timeOfUsage;
    }

    /**
     * Abstract method to get the usual fee per km(non peak time)
     *
     * @return usual fee
     */
    public abstract int getUsualFee();

    /**
     * Abstract method to get the peak fee per km(during peak time)
     * @return peak fee
     */
    public abstract int getPeakFee();


    /**
     * Mutator method to set registrationNumber.
     *
     * @param registrationNumber The registrationNumber to be set.
     */
    public void setRegistrationNumber(int registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Mutator method to set the brand.
     *
     * @param make The brand to be set.
     */
    public void setMake(String make)
    {
        this.make = make;
    }

    /**
     * Mutator method to set the earnings for a specific month.
     *
     * @param earnMoney The earned money to be added.
     * @param month The month that serves as an index.
     */
    public void setEarnMoney(double earnMoney, int month)
    {
        this.earnMoney[month - 1] += earnMoney;
    }

    /**
     * Mutator method to set the VehicleCategory.
     *
     * @param vehicleType The VehicleCategory to be set.
     */
    public void setVehicleType(VehicleCategory vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    /**
     * Mutator method to set the total km driven for a specific month.
     *
     * @param totalKmDriven The km to be added.
     * @param month The month that serves as an index.
     */
    public void setTotalKmDriven(double totalKmDriven, int month)
    {
        this.totalKmDriven[month - 1] += totalKmDriven;
    }

    /**
     * Mutator method to set the time of usage for a specific month.
     *
     * @param timeOfUsage The usage time to be added.
     * @param month The month that serves as an index.
     */
    public void setTimeOfUsage(int timeOfUsage, int month)
    {
        this.timeOfUsage[month - 1] += timeOfUsage;
    }

    /**
     * method that returns a string including the attributes of the object.
     *
     * @return a string including the information of vehicle
     */
    @Override
    public String toString()
    {
        return "ZoomerVehicle{" +
                "registrationNumber=" + registrationNumber +
                ", make='" + make + '\'' +
                ", vehicleType=" + vehicleType +
                ", totalKmDriven=" + totalKmDriven +
                ", timeOfUsage=" + timeOfUsage +
                '}';
    }
}
