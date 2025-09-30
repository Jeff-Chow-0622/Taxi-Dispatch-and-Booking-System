
import java.util.Scanner;
import java.util.*;

/**
 * This class simulates a user Zoomer system
 *
 * @author Zhao Zhong Chow (Jeff)
 * @version ver 1.2.0
 */
public class ZoomerSystem
{   ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<ZoomerVehicle> vehicles = new ArrayList<>();  //using polymorphism
    ArrayList<RideBooking> rideBookings = new ArrayList<RideBooking>();

    /**
     * This is the main method which begins the program execution.
     *
     * @param args An array of Strings representing command line arguments.
     */
    public static void main(String[] args)
    {

        ZoomerSystem a2 = new ZoomerSystem(); // instantiate class Assignment2Driver
        a2.task();

    }

    /**
     * This method executes task
     * it allows users to select an option from main menu and execute it.
     * Notice that in this assignment I assume the booking time is the time they want to have a ride immediately, so we can't
     * make a reservation in advance
     * So, it won’t happen that the next booking time is earlier than the previous booking time
     * In order to simulate the real world situation, I use distance divided by
     * the car speed to get the time taken to transport passengers to the destination.
     * In this way, I know the returning time of all booking rides,
     * which helps me better allocate vehicles and reuse them efficiently
     */
    public void task()
    {


        Scanner console = new Scanner(System.in);

        int selection = 0;
        int customerID = 0;
        int registrationID = 0;
        int rideID = 0;
        while (selection != 6)
        {
            System.out.println("Main menu");
            System.out.println("1. Register a new customer.");
            System.out.println("2. Register a new Zoomer vehicle. ");
            System.out.println("3. Book a new ride.");
            System.out.println("4. Display a report of all rides booked for the day.");
            System.out.println("5. Present a summary report for the month, that for each vehicle in the system \n" +
                    "shows how many rides were taken, total kilometres driven, and how much \n" +
                    "money was made. ");
            System.out.println("6. Exit the program.");
           // selection = console.nextInt();

            try {
                selection = console.nextInt();
                while (selection < 1 || selection > 6) {  // this while loop makes sure no numbers other than 1~6 are typed
                    System.out.println("Please select between option 1 to 6");
                    selection = console.nextInt();
                }

            } catch (InputMismatchException e)
            {
                System.out.println("please enter valid number(must be an integer)");
                console.next();
            }


            switch (selection)
            {
                case 1:
                    customerID++;
                    System.out.println("please enter customer's name:");
                    String customerName = console.next();
                    ArrayList<RideBooking> customerBookings = new ArrayList<RideBooking>();
                    Customer customer = new Customer(customerID, customerName,customerBookings);  // only register a customer, not a ride yet
                    customers.add(customer);
                    break;
                case 2:
                    registrationID++;

                    System.out.println("Please enter the vehicle make:");
                    String make = console.next();
                    VehicleCategory type = chooseType();
                    ZoomerVehicle vehicle = null; //initialise the vehicle
                    if (type == VehicleCategory.LITE)
                    {
                        vehicle = new ZoomerLite(registrationID, make, type);
                    }
                    else if (type == VehicleCategory.STANDARD)
                    {
                        vehicle = new ZoomerStandard(registrationID, make, type);
                    }
                    else if (type == VehicleCategory.PRO)
                    {
                        vehicle = new ZoomerPro(registrationID, make, type);
                    }
                    // = new ZoomerLite();  //
                    vehicles.add(vehicle);
                    System.out.println(vehicle.toString());
                    break;

                case 3:
                    rideID++;
                    boolean flag = false;
                    boolean validInput = false;
                    System.out.println("Please enter the customer ID of whom has made the booking:");
                    int ID = getcheckedInteger();
                    type = chooseType();  // customer can choose the type they want
                    System.out.println("Please enter the month, date and time you want to book the texi: ");
                    System.out.println("Month: ");
                    int month = getcheckedInteger();
                    System.out.print("date: ");
                    int date = getcheckedInteger();
                    System.out.print("hour(24-hour clock): ");
                    int hour = getcheckedInteger();
                    System.out.print("minute: ");
                    int minute = getcheckedInteger();
                    MonthDateTime bookingTime = new MonthDateTime(month, date, hour, minute);
                    ZoomerVehicle availableVehicle = validateVehicle(bookingTime, type);  // check if there's any available vehicles

                    boolean flagForAvailable = true;
                    if (availableVehicle == null)
                    {
                        flagForAvailable = false;
                    }
                    Iterator<Customer> it = customers.iterator();
                    while (it.hasNext() && !flag && flagForAvailable)  // this loop traverses whole arraylist that contains registeredUser
                        // only meet all the conditions above can instantiate a ridebooking object
                    {
                        Customer val = it.next(); // notice variable val is a single variable, not an arraylist like it
                        if (val.getCustomerNumber() == ID)
                        {
                            flag = true;  // check if the customer exists( already registered)

                            System.out.println("Please enter the starting and destination:");
                            String startingLocation = console.next();
                            String destination = console.next();

                            System.out.println("Please enter the riding distance:");
                            int distance = getcheckedInteger();
                            while ((distance > 10 && type == VehicleCategory.LITE) || distance > 20 && type == VehicleCategory.STANDARD)
                            {
                                System.out.println("there's a limitation of the distance of the trip(Lite up to 10km and Standard up to 20km). Please choose again:");
                                distance = getcheckedInteger();
                            }

                            System.out.println("Please enter the number of passengers:");
                            int numberOfPeople = getcheckedInteger();
                            if (type == VehicleCategory.LITE && numberOfPeople >1)  // check the limitation
                            {
                                System.out.println("ZoomerLite is only for one passenger. Please choose other types");
                                type = chooseType();
                            }



                            RideBooking rideBooking = new RideBooking(rideID, val, availableVehicle, bookingTime, startingLocation, destination, distance, numberOfPeople);
                            rideBookings.add(rideBooking);  // the moment you book, you will know the returning time as well.
                            rideBooking.getVehicle().setTotalKmDriven(distance, month);   //record the distance driven
                            rideBooking.getVehicle().setTimeOfUsage(1, month);  // set how many rides were taken
                            rideBooking.getCustomer().setRideBookings(rideBooking);  // set the ridebooking record into customer

                            System.out.printf("the cost$: \n");
                            int numberOfLargeBag = 0; // initialize
                            if (rideBooking.getVehicle().getVehicleType() == VehicleCategory.PRO)
                            {
                                System.out.println("how many large bag do u have?");
                                numberOfLargeBag = getcheckedInteger();
                            }

                            rideBooking.getVehicle().setEarnMoney(rideBooking.totalCostPerRide(numberOfLargeBag), month);  // set how much money was made in the ride
                        }
                    }







                    break;
                case 4:
                    System.out.println("please enter the date you want to see the rides records: ");
                    System.out.print("Month: ");
                    int reportMonth = getcheckedInteger();
                    System.out.print("date: ");
                    int reportDate = getcheckedInteger();
                    //rideBookings.forEach(rideBooking ->
                    for (RideBooking rideBooking : rideBookings)
                    {
                            if (rideBooking.getbookingTime().getMonth() == reportMonth && rideBooking.getbookingTime().getDate() == reportDate)
                            {

                                System.out.println(rideBooking.toString());
                                System.out.print("\n");
                            }
                    }
                    break;
                case 5:
                    System.out.println("please enter the month you want to see the rides records: ");
                    System.out.print("Month: ");
                    reportMonth = getcheckedInteger();
                    vehicles.forEach(vehicleSummary ->
                            {
                                int id = vehicleSummary.getRegistrationNumber();
                                int ridesTaken = vehicleSummary.getTimeOfUsage()[reportMonth - 1];
                                double kmDriven = vehicleSummary.getTotalKmDriven()[reportMonth - 1];
                                double moneyEarned = vehicleSummary.getEarnMoney()[reportMonth - 1];

                                System.out.printf("Month: %d; texiID: %d; number of rides taken: %d times; " +
                                        "total km driven: %f; money made: $%f", reportMonth, id, ridesTaken, kmDriven, moneyEarned);
                                System.out.print("\n");
                            }
                            );
                    break;
                case 6:
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * this method checks for an available vehicle based on the booking time and the category of the vehicle
     * it first asks user to choose the type by entering 1, 2 or 3 corresponding to Lite, Standard or Pro.
     *
     * @return the type of the vehicle (Lite, Standard or Pro)
     */
    public VehicleCategory chooseType()
    {
        System.out.println("please enter the type(1 for Lite, 2 for Standard and 3 for Pro):");
        Scanner console = new Scanner(System.in);
        int selection = 0;
        try {
            selection = console.nextInt();
            while (selection < 1 || selection > 3) {  // this while loop makes sure no numbers other than 1~6 are typed
                System.out.println("Please select between option 1 to 3");
                selection = console.nextInt();
            }

        } catch (InputMismatchException e) {
            System.out.println("please enter valid number(must be an integer)");
            console.next();
        }

        VehicleCategory type = VehicleCategory.LITE;
        switch (selection)
        {
            case 1:
                type = VehicleCategory.LITE;

                break;
            case 2:
                type = VehicleCategory.STANDARD;
                break;
            case 3:
                type = VehicleCategory.PRO;
            default:
                break;
        }
        return type;
    }

    /**
     * This method check whether the input is integer or not
     * initially I wanted to use try catch on each input, but it's too redundant.
     * @return the valid integer
     */
    public int getcheckedInteger()
    {

        Scanner console = new Scanner(System.in);
        int integer = 0;
        boolean validInput = false;
        while (!validInput)
        {
            try
            {
                integer = console.nextInt();
                validInput = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid number (must be an integer):");
                console.next();
            }
        }
        return integer;

    }

    /**
     * this method checks for an available vehicle based on the booking time and the category of the vehicle
     * this method iterates all vehicles list and bookingRide list to make sure no schedule overlap in each month
     * this method ensure that even if the car has been used before, we stll can reuse it as long as the current booking time and
     * the returning time of the previous ride are not overlapped.
     * @param bookingTime the customer's booking time
     * @param type the vehicle's category
     * @return the available vehicle
     */
    public ZoomerVehicle validateVehicle(MonthDateTime bookingTime, VehicleCategory type)   // parameter is the current bookingTime
    {
        ArrayList<ZoomerVehicle> availableVehicles = new ArrayList<>();

        int count = 0;
        //vehicles.forEach(vehicle ->
        for (ZoomerVehicle vehicle : vehicles)
            {

                //double sum = Arrays.stream(vehicle.getTotalKmDriven()).sum();
                if(vehicle.getTimeOfUsage()[bookingTime.getMonth() - 1] == 0 &&  vehicle.getVehicleType() == type)  //
                {
                    availableVehicles.add(vehicle);

                }
                else
                    {


                        for (RideBooking bookingRide : rideBookings)
                                {
                                   // System.out.println(returnTime(bookingRide));
                                    double previousHours = bookingRide.getRideDistance() / vehicle.getVehicleSpeed();
                                    MonthDateTime returnTime = bookingRide.getbookingTime().addition(previousHours);  // returnTime here means the returning time of the vehicle in previous booking records
                                    //double estimateHours = estimateDistance / vehicle.getVehicleSpeed();
                                    //if(bookingTime.ValidateNotOverlap(bookingRide.getbookingTime(), previousHours, estimateHours) && bookingRide.getVehicle().getVehicleType() == type)
                                    if(bookingTime.validateNotOverlap(returnTime) && bookingRide.getVehicle().getVehicleType() == type)
                                    { // returnTime(bookingRide) will return the return time of the specific ride

                                        availableVehicles.add(bookingRide.getVehicle());
                                        //availableVehicles.add(bookingRide.getVehicle());
                                    }

                                }

                    }
                count++;

            }



        ZoomerVehicle availableVehiclesFirst = null;  // randomly initialize a vehicle
        try
        {
            availableVehiclesFirst = availableVehicles.get(0);

        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("there's no available vehicles at the moment");
            availableVehiclesFirst = null;
        }
        return availableVehiclesFirst;

    }



}
