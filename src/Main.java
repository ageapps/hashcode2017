import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Main {

    public int rows;
    public int columns;
    public int vehicles;
    public int rides;
    public int bonus;

    public static BigInteger steps;
    public static List rideList;
    public static Vehicle[] vehiclesArray;

    public static void main(String[] args) {
        String fileName = "lines.txt";

        for (BigInteger bi = BigInteger.ZERO;
             bi.compareTo(steps) < 0;
             bi = bi.add(BigInteger.ONE)) {

            for (int i = 0; i < rideList.size(); i++) {
                int[] distances = new int[vehiclesArray.length];


                for (int j = 0; j < vehiclesArray.length; j++) {


                }

            }
        }
    }


    public void readFile( String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
