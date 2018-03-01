import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int bonus;

    public static BigInteger steps;
    public static List<Ride> availableRides;
    public static Vehicle[] vehiclesArray;
    public static int[][] streets;


    public static void main(String[] args) {
        String fileName = "lines.txt";

        availableRides = new ArrayList<Ride>();

        populateAll(fileName);
        for (BigInteger bi = BigInteger.ZERO;
             bi.compareTo(steps) < 0;
             bi = bi.add(BigInteger.ONE)) {

             int lastAsignedRide = 0;
            // asignar rides a coches
            for (int i = 0; i < availableRides.size(); i++) {

                Vehicle closestVehicle = getClosestVehicle(i);

                closestVehicle.setCurrentRide(availableRides.get(i));
                lastAsignedRide = i+1;
            }

            // clean assigned rides
            int oldRides = availableRides.size();
            int ind = 0;
            while (availableRides.size() >  (oldRides-(lastAsignedRide))){
                availableRides.remove(0);
                ind++;
            }


            // mover coches
            for (int j = 0; j < vehiclesArray.length; j++) {
                if (vehiclesArray[j].isBusy()){
                    vehiclesArray[j].move();
                }
            }


        }




        System.out.println("Done, bitches");

    }

    private static void populateAll(String fileName) {
        File file = new File(fileName);
        FileReader input = null;
        try {
            input = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufRead = new BufferedReader(input);
        Scanner scanner = null;
        try {
            scanner = new Scanner(bufRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        streets = new int[rows][columns];

        vehiclesArray = new Vehicle[scanner.nextInt()];
        int  numRides = scanner.nextInt();;
        bonus = scanner.nextInt();
        steps = scanner.nextBigInteger();

        for(int j=0; j<= vehiclesArray.length; j++) {
            vehiclesArray[j]=new Vehicle(new Position(0,0));
        }

        for (int i=0; i< numRides; i++) {
            try {
                scanner = new Scanner(bufRead.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

            Position start = new Position(x1,y1);
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            Position end = new Position(x2,y2);

            int eStart = scanner.nextInt();
            int lFinish = scanner.nextInt();
            availableRides.add(new Ride(start,end,eStart,lFinish));
        }
    }


    public static Vehicle getClosestVehicle(int i){
        int[] distances = new int[vehiclesArray.length];
        int minDistance = 10001;
        int carIndex = vehiclesArray.length;

        for (int j = 0; j < vehiclesArray.length; j++) {
            // calcular minima distancia


        }
        for (int j = 0; j < vehiclesArray.length; j++) {
            // calcular minima distancia
            if (distances[i] < minDistance){
                minDistance = distances[i];
                carIndex = i;
            }
        }
        Vehicle closestVehicle = vehiclesArray[carIndex];

        return closestVehicle;
    }
}
