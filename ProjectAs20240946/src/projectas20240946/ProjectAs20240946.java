/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectas20240946;

import java.util.Scanner;

/**
 *
 * @author Kalana Dasanayaka
 */
public class ProjectAs20240946 {
    static final double FUEL_PRICE = 310;
   
    public static void main(String[] args) {
        final int MAX_CITIES = 30;


        final double[][] VEHICLE_TABLE =  new double[5][5];
        /*  VEHICLE_TABLE[0][] = VAN
            VHEICALE_TABLE[1][] = TRUCK
            VEHICLE_TABLE[2][] = LORRY
         
         * VEHICLE_TABLE[][0] = CAPACITY (KG)
         * VEHICLE_TABLE[][1] = RATE PER KM (LKR)
         * VEHICLE_TABLE[][2] = AVERAGE SPEED (KM per HOUR)
         * VEHICLE_TABLE[][3] = FUEL EFFICIENCY (KM per LITER)
         
        */
        //VAN
        VEHICLE_TABLE[0][0] = 1000;
        VEHICLE_TABLE[0][1] = 30;
        VEHICLE_TABLE[0][2] = 60;
        VEHICLE_TABLE[0][3] = 12;

        //TRUCK
        VEHICLE_TABLE[1][0] = 5000;
        VEHICLE_TABLE[1][1] = 40;
        VEHICLE_TABLE[1][2] = 50;
        VEHICLE_TABLE[1][3] = 6;

        //LORRY
        VEHICLE_TABLE[2][0] = 10000;
        VEHICLE_TABLE[2][1] = 80;
        VEHICLE_TABLE[2][2] = 45;
        VEHICLE_TABLE[2][3] = 4;;

        int indexCities = 0  ;
        String cities[] = new String[MAX_CITIES];
        double distanceTable[][] = new double[MAX_CITIES][MAX_CITIES];
        double orderTable[] = new double[6];
        /* distance =       orderTable[0]
         * weight =         orderTable[1]
         * Rate per km =    orderTable[2]
         * Vehicle speed =  orderTable[3]
         * efficiency =     orderTable[4]
         * fuel price =     orderTable[5]
         */


        //for testing purposes
        cities[0]="colombo";
        cities[1]="homagama";
        cities[3]="maharagama";
        cities[2]="kottawa";
        cities[4]="nugegoda";
        cities[5]="kirulapone";
        renameCity(cities);
        System.out.println(cities[0]);
                
        
        
        

    }
    public static void menu(String[] array, int index){ 
        int choice = 0; 
        while (choice!=99) {
            
        
        System.out.print("Menu Option : ");
        switch (choice) {
            case 1:
                index = addCity(array, index);
                break;
            case 2:
                break;

            default:
                break;
        }


    }
    }
    public static int getCityIndex(String [] array,String name){
        int index = -99;
        for(int i = 0; i < 30 ; i++){
            if(array[i]!=null){
                if(name.equalsIgnoreCase(array[i])) {
                index = i;
                }
            }
         }
         return(index);
    }
public static void updateDistance(String[] city, double[][] distance) {
    int start = -1;
    int end = -1;
    Scanner input = new Scanner(System.in);
    String exit = "not exit";

    while (!exit.equals("exit")) {
        System.out.print("Departure :  ");
        String cityName = input.nextLine();
        if (cityName.equalsIgnoreCase("exit")) {
            break;
        }

        start = getCityIndex(city, cityName);
        if (start == -99) {
            System.out.println("Wrong City Name Entered !!!");
            System.out.println("Try Again!!!");
            System.out.println("(To exit the sequence type, exit)");
            continue;
        }

        while (!exit.equals("exit")) {
            System.out.print("Destination : ");
            cityName = input.nextLine();
            if (cityName.equalsIgnoreCase("exit")) {
                exit = "exit";
                break;
            }

            end = getCityIndex(city, cityName);
            if (end == -99) {
                System.out.println("Wrong City Name Entered !!!");
                System.out.println("Try Again!!!");
                continue;
            }

            System.out.print("What is the distance between " + city[start] + " and " + city[end] + " (km): ");
            double distance1 = input.nextDouble();
            input.nextLine(); // <-- consume the leftover newline
            distance[start][end] = distance1;
            distance[end][start] = distance1;

            System.out.print("Type 'exit' to stop or press 'Enter' to continue: ");
            exit = input.nextLine();
        }
    }

 
}
 




    public static int addCity(String[] array,int index){
       
        System.out.println("What is the name of the city ? ");
        Scanner input = new Scanner(System.in);
        String cityName=input.nextLine();
        array[index]=cityName.toUpperCase();
        index=index+1;
        input.close();
        return(index);
        

    }
    public static int openIndex(String[] array){
        int openIndex = 0;
        for (int i = 0; i < 30; i++) {
            if( array[i] == null || array[i].isEmpty()){
                return openIndex;
}
        }
        return(-1);
    
    
    
    }

  
public static void renameCity(String[] array){
    Scanner input = new Scanner(System.in); 
    System.out.println("What is the city you need to rename ? ");
    String city = input.nextLine();
    int index = getCityIndex(array, city);

    if (index == -99) {
        System.out.println("Wrong City Name Entered !!!");
        System.out.println("Try Again!!!");
        return;
        
    }

    System.out.println("What do you need to rename the city as ? ");
    String renamedCity = input.nextLine();
    array[index] = renamedCity.toUpperCase();
}

    
    public static void removeCity(String[] array){
        System.out.println("What city do you need removed ? ");
        Scanner input = new Scanner(System.in);
        String city = input.nextLine();
        int index = getCityIndex(array, city);
        array[index] = "";
        input.close();
    }

    public static void addOder(String[] citiyTable, double[][] distanceTable, double[][] vehicleTable, double[] orderTable){
        double cargo;
        int vehicleIndex ;

        Scanner input = new Scanner(System.in);
        
        System.out.println("What is the source city name ? ");
        String source = input.nextLine();
        int sourceIndex = getCityIndex(citiyTable, source);
        System.out.println("What is the destination city name ? ");
        String destination = input.nextLine();
        int destinationIndex = getCityIndex(citiyTable, destination);
        if (source == destination) {
            System.out.println("Souce city and Destination city cannot be the same .");
            System.out.println("Invalid input. please try again !!!");
            return;
            
        }
        while (true) {
            System.out.println("How much cargo do you want to transpot ? (in kg) ");
            cargo = input.nextDouble();
            System.out.println("What is your prefered vehicle type ? (1 = Van, 2 = Truck, 3 = Lorry)" );
            vehicleIndex = input.nextInt()-1;
            if (vehicleTable[vehicleIndex][0] < cargo ) {
                System.out.println("Your prefered vehicle doesn't allow your required cargo weight.");
                System.out.println("Invalid input. please try again !!!");
                continue;
                }
                break;
    }
        /* distance =       orderTable[0] 
         * weight =         orderTable[1]
         * Rate per km =    orderTable[2]
         * Vehicle speed =  orderTable[3]
         * efficiency =     orderTable[4]
         * fuel price =     orderTable[5]
         */
        /*  VEHICLE_TABLE[0][] = VAN
            VHEICALE_TABLE[1][] = TRUCK
            VEHICLE_TABLE[2][] = LORRY
         
         * VEHICLE_TABLE[][0] = CAPACITY (KG)
         * VEHICLE_TABLE[][1] = RATE PER KM (LKR)
         * VEHICLE_TABLE[][2] = AVERAGE SPEED (KM per HOUR)
         * VEHICLE_TABLE[][3] = FUEL EFFICIENCY (KM per LITER)
         
        */
        
        orderTable[0] = distanceTable[sourceIndex][destinationIndex];
        orderTable[1] = cargo;
        orderTable[2] = vehicleTable[vehicleIndex ][1];
        orderTable[3] = vehicleTable[vehicleIndex ][2];
        orderTable[4] = vehicleTable[vehicleIndex ][3];
        orderTable[5] = FUEL_PRICE;
    }
    public static double deliveryCost(double[] orderTable){
        /* distance =       orderTable[0]
         * weight =         orderTable[1]
         * Rate per km =    orderTable[2]
         * Vehicle speed =  orderTable[3]
         * efficiency =     orderTable[4]
         * fuel price =     orderTable[5]
         */
        
        double cost = orderTable[0] * orderTable[2] * (1+ orderTable[1]*1/10000);
        return(cost);
    }
    public static double estimatedDeliveryTime(double[] orderTable){
        double time = orderTable[0] / orderTable[3];
        return(time);
    }

    public static double fuelConsumption(double[] orderTable){
         /* distance =       orderTable[0]
         * weight =         orderTable[1]
         * Rate per km =    orderTable[2]
         * Vehicle speed =  orderTable[3]
         * efficiency =     orderTable[4]
         * fuel price =     orderTable[5]
         */
        
        double fuelUsed = orderTable[0] / orderTable[4];
        return fuelUsed;
    }

    public static double fuelCost(double[] orderTable){
        double fuelCost = fuelConsumption(orderTable) * FUEL_PRICE;
        return fuelCost;
    }

    public static double TotalOperationCost(double[] orderTable){
        double totalCost = deliveryCost(orderTable) + fuelCost(orderTable);
        return totalCost;

    }
    public static double profit(double[] orderTable){
        double profit = deliveryCost(orderTable) * 0.25;
        return profit;
    }

    public static double customerCharge(double[] orderTable){
        double customerCharge = TotalOperationCost(orderTable) + profit(orderTable);
        return customerCharge;

    }

}
