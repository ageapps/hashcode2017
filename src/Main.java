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
        String fileName = "a_example.in";

        availableRides = new ArrayList<Ride>();

        populateAll(fileName);
        for (BigInteger bi = BigInteger.ZERO;
             bi.compareTo(steps) < 0;
             bi = bi.add(BigInteger.ONE)) {

             int lastAsignedRide = 0;
            // asignar rides a coches
            System.out.println("");
            System.out.println("--------------------   STEP "+ bi + "  ------------------- " );
            System.out.println("");


            for (int i = 0; i < availableRides.size(); i++) {
                int vehicleIndex = calculateClosestTo(availableRides.get(i).getStartPosition());

                if(vehicleIndex < 0) {
                    continue;
                }

                if (vehiclesArray[vehicleIndex].isBusy()){
                    continue;
                }
                System.out.println("Ride "+ availableRides.get(i).getId() + " => Vehicle " + vehicleIndex );

                vehiclesArray[vehicleIndex].setCurrentRide(availableRides.get(i));

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
        generateOutput();
    }

    public static int getDistance(Position startPosition, Position endPosition){
        return Math.abs(endPosition.getX()-startPosition.getX())+Math.abs(endPosition.getY()-startPosition.getY());
    }

    public static int calculateClosestTo(Position destination){
        int closestDistance=streets.length*streets[0].length+1;
        int closestVehicleId=0;
        for (int i=0; i<vehiclesArray.length; i++){
            int currDistance;

            if(!vehiclesArray[i].isBusy()){
                currDistance = getDistance(vehiclesArray[i].getCurrentPosition(), destination);
            } else {
                currDistance = vehiclesArray[i].getBusySteps() + getDistance(vehiclesArray[i].getCurrentRide().getEndPosition(), destination);

            }
            System.out.println("Distance Vehicle " + i + ": " + currDistance);

            if(currDistance<closestDistance){
                closestDistance=currDistance;
                closestVehicleId=i;
            }
        }

        if(closestDistance==streets.length*streets[0].length+1){
            return -1;
        }
        else{
            return closestVehicleId;
        }
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
        System.out.println("rows " + rows);
        System.out.println("columns " + columns);

        streets = new int[rows][columns];

        int vehicleNum = scanner.nextInt();
        System.out.println("vehicleNum " + vehicleNum);

        vehiclesArray = new Vehicle[vehicleNum];
        int  numRides = scanner.nextInt();;
        System.out.println("numRides " + numRides);

        bonus = scanner.nextInt();
        steps = scanner.nextBigInteger();
        System.out.println("bonus " + bonus);
        System.out.println("steps " + steps);

        for(int j=0; j< vehiclesArray.length; j++) {
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
            availableRides.add(new Ride(i,start,end,eStart,lFinish));
        }
        System.out.println(" -------------------------------    ");

    }


    public static void generateOutput(){
        try {
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            for (int i=0; i<vehiclesArray.length;i++){
                writer.print(vehiclesArray[i].getDoneRides().size());
                writer.print(" ");

                System.out.print(vehiclesArray[i].getDoneRides().size());
                System.out.print(" ");

                for(int j=0; j<vehiclesArray[i].getDoneRides().size();j++){
                    writer.print(vehiclesArray[i].getDoneRides().get(j).getId()+" ");
                    System.out.print(vehiclesArray[i].getDoneRides().get(j).getId()+" ");
                }
                writer.print("\n");
                System.out.print("\n");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
