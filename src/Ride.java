/**
 * Created by age on 1/3/18.
 */
public class Ride{


    public int  eStart, lFinish;

    private Position startPosition, endPosition;

    public int geteStart() {
        return eStart;
    }

    public void seteStart(int eStart) {
        this.eStart = eStart;
    }

    public int getlFinish() {
        return lFinish;
    }

    public void setlFinish(int lFinish) {
        this.lFinish = lFinish;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Position endPosition) {
        this.endPosition = endPosition;
    }

    public Ride(Position startPosition, Position endPosition, int eStart, int lFinish) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.eStart = eStart;
        this.lFinish = lFinish;
    }

    public int getDistance(){
        return Math.abs(endPosition.getX()-startPosition.getX())+Math.abs(endPosition.getY()-startPosition.getY());
    }
}