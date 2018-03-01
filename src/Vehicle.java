import java.util.ArrayList;

/**
 * Created by age on 1/3/18.
 */
public class Vehicle {
    private int busySteps;
    private Position currentPosition;
    private ArrayList<Ride> doneRides;
    private Ride currentRide;


    public Vehicle( Position position) {
        this.busySteps = busySteps;
        this.currentPosition = position;
        this.doneRides = doneRides;
        this.currentRide = currentRide;

        busySteps = 0;
        doneRides = new ArrayList<Ride>();
        currentRide = null;
    }

    public int getBusySteps() {
        return busySteps;
    }

    public void setBusySteps(int busySteps) {
        this.busySteps = busySteps;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public ArrayList<Ride> getDoneRides() {
        return doneRides;
    }

    public void setDoneRides(ArrayList<Ride> doneRides) {
        this.doneRides = doneRides;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public boolean isBusy(){
        return (busySteps > 0);
    }
    public void move(){
        busySteps--;
    }
}
