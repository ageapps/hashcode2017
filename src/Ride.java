/**
 * Created by age on 1/3/18.
 */
public class Ride{


    public int  eStart, lFinish;

    public int id;

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

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Ride(int id, Position startPosition, Position endPosition, int eStart, int lFinish) {
        this.id=id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.eStart = eStart;
        this.lFinish = lFinish;
    }
}