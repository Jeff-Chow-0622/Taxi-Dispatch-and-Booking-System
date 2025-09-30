
/**
 * this is a class that represent a specific time including month, date, hour and minutes.
 *it has the method of time addition, validate time overlapping, and determine when the peak and usual time is.
 */
public class MonthDateTime
{
    public int month;
    public int date;
    public int hour;
    public int min;

    /**
     * non default constructor which instantiate the class RideBooking
     * @param month month.
     * @param date date.
     * @param hour the hour using 24-hour clock.
     * @param min the minute.
     *
     */
    public MonthDateTime(int month, int date, int hour, int min)
    {
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.min = min;
    }

    /**
     * Accessor method to get month.
     * @return month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Accessor method to get date.
     * @return date.
     */
    public int getDate() {
        return date;
    }

    /**
     * Accessor method to get hour.
     * @return hour.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Accessor method to get minute.
     * @return minute.
     */
    public int getMin() {
        return min;
    }

    /**
     * Mutator method to set the month.
     *
     * @param month The month to be set.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Mutator method to set the date.
     *
     * @param date The date to be set.
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Mutator method to set the hour.
     *
     * @param hour The hour to be set.
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Mutator method to set the minute.
     *
     * @param min The minute to be set.
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * this method add hours to the current date and time
     * it first convert hours into hours and minutes.
     * it also adds to new date if necessary
     * @param hours the hours to be added. it's a double because this hours comes from distance / vehicleSpeed
     * and distance can be double.
     * @return a new MonthDateTime object with the adjusted time.
     */
    public MonthDateTime addition(double hours)  // calculate the return time
    {
        int minute =(int)((hours - (int)hours) * 60);
        int returnMinute = minute + getMin();
        int returnHour = (int)hours + getHour();
        int returnDate = getDate();
        if (returnMinute >= 60)
        {
            returnMinute -= 60;
            returnHour++ ;
        }
        if (returnHour >= 24)
        {
            returnDate++;
            returnHour -= 24;
        }
        return new MonthDateTime(getMonth(), returnDate, returnHour,returnMinute);

    }

    /**
     * this method validates whether the current booking time doesn't overlap with another booking time's returning time
     * because if it overlaps, it means the car is still being used, we need to find another one or there's no available
     * vehicle at the moment
     * Notice that in this assignment I assume the booking time is the time they want to have a ride immediately, so we can't
     * make a reservation in advance
     * So, it won’t happen that the next booking time is earlier than the previous booking time
     * @param returnTime the return time of another booking
     * @return a new MonthDateTime object with the adjusted time.
     */
    public boolean validateNotOverlap(MonthDateTime returnTime)
    {
        boolean flag = true;
        int returnTimeDecimal = returnTime.getMonth() * 1000000 + returnTime.getDate() * 10000 + returnTime.getHour() * 100 + returnTime.getMin();
        int bookingTimeDecimal = this.month * 1000000 + this.date * 10000 + this.hour * 100 + this.min;
        // if (bookingTimeDecimal > returnTimeDecimal)  // this line is not perfect as it only consider booking time later than return time
        // maybe you reserve a texi in the future, and there is another customer who want to book it rn.

        if (bookingTimeDecimal > returnTimeDecimal)
        {
            flag = true;  // if return true, it means no time overlap, which means the booking time happens after another booking's return time

        }
        else
            flag = false;
        return flag;
    }

    /**
     * this method validates whether the current booking time falls within the peak hours
     * @return True if the time is within the peak hours, false otherwise.
     */
    public boolean validatePeakTime()
    {
        if ((this.hour >= 7 && this.hour <= 9) || (this.hour >= 17 && this.hour <=19))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * method that returns a string including the attributes of the MonthDateTime class.
     *
     * @return a string including the information of  MonthDateTime
     */
    @Override
    public String toString() {
        return "MonthDateTime{" +
                "month=" + month +
                ", date=" + date +
                ", hour=" + hour +
                ", min=" + min +
                '}';
    }
}
