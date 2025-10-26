/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectas20240946;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kalana Dasanayaka
 */
public class ProjectAs20240946 {


    static final double FUEL_PRICE = 310; 
    static final int MAX_CITIES = 30;
    static final int MAX_RECORDS = 50;
    static final double INFINITY = 999999999; //used for methods needing a very large value
    static Scanner input = new Scanner(System.in); //singular global input for ease of programming 


    public static void main(String[] args) {
        


        final double[][] VEHICLE_TABLE =  new double[5][5];
        /*  VEHICLE_TABLE[0][] = VAN
            VEHICLE_TABLE[1][] = TRUCK
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

        
        String[] cityTable = new String[MAX_CITIES];
        double[][]  distanceMatrix= new double[MAX_CITIES][MAX_CITIES];
        for(int i=0 ; i<MAX_CITIES ; i++){
            for(int j=0 ; j<MAX_CITIES ; j++){
                distanceMatrix[i][j] = -1; //default null value
            }
        }
        double[] orderTable = new double[6];
        /* distance =       orderTable[0]
         * weight =         orderTable[1]
         * Rate per km =    orderTable[2]
         * Vehicle speed =  orderTable[3]
         * efficiency =     orderTable[4]
         * fuel price =     orderTable[5]
         */



        String[][] deliveryRecord = new String[MAX_RECORDS][13]; 
        for(int i=0 ; i<MAX_RECORDS ; i++){
            for(int j=0 ; j<13 ; j++){
                deliveryRecord[i][j] = ""; //default null value
            }
        }
        /* 
         * from =               deliveryRecord[][0]
         * to =                 deliveryRecord[][1]
         * minimun distance =   deliveryRecord[][2]
         * vehicle =            deliveryRecord[][3]
         * weight =             deliveryRecord[][4]
         * base cost =          deliveryRecord[][5]
         * fuel used =          deliveryRecord[][6]
         * fuel cost =          deliveryRecord[][7]
         * operation cost =     deliveryRecord[][8]
         * profit =             deliveryRecord[][9]
         * customer charge =    deliveryRecord[][10]
         * estimated time =     deliveryRecord[][11]
         * rater per km =       deliveryRecord[][12]
         * */

 
    
        menu(cityTable, distanceMatrix, VEHICLE_TABLE, orderTable, deliveryRecord);
        
        
        input.close();
    }
public static void menu(String[] cityTable, double[][] distanceMatrix, double[][] vehicleTable,double[] orderTable, String[][] deliveryRecord) {
    loadCityTable(cityTable);// load data from the txt files
    loadDeliveryRecord(deliveryRecord);
    loadDistanceMatrix(distanceMatrix);
     
    int choice = -1;

    while (choice != 0) {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. City Management");
        System.out.println("2. Distance Management");
        System.out.println("3. Delivery Request Handling");
        System.out.println("4. Reports");
        System.out.println("0. Exit");
        
        while (true) {
            System.out.println();
            System.out.print("Menu Option: ");
            String choiceHolder = input.nextLine();
            System.out.println();
            try {//checkin if the input is an integer, if this code block is not present the program crashes if a wrong data type is entered
                choice = Integer.parseInt(choiceHolder);
                break;
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Please input an integer input relevent to the options shown.");
                System.out.println();
            
            }
            
        }
        
        

        switch (choice) {
            case 1:{
                int firstSubMenuChoice = -1;
                while (firstSubMenuChoice != 0) {
                    System.out.println("\n--- CITY MANAGEMENT ---");
                    System.out.println("1. Add City");
                    System.out.println("2. Rename City");
                    System.out.println("3. Remove City");
                    System.out.println("0. Back");
                   
                    while (true) {
                        System.out.println();
                        System.out.print("Option: ");
                        String firstSubMenuChoiceHolder = input.nextLine();
                        System.out.println();
                        try {//checkin if the input is an integer, if this code block is not present the program crashes if a wrong data type is entered
                            firstSubMenuChoice = Integer.parseInt(firstSubMenuChoiceHolder);
                            break;
                        } 
                        catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Please input an integer input relevent to the options shown.");
                            System.out.println();
                        
                        }
                        
                    }

                    switch (firstSubMenuChoice) {
                        case 1 :
                            addCity(cityTable);
                            storeCityTable(cityTable);
                            break;
                        case 2 :
                            renameCity(cityTable);
                            storeCityTable(cityTable);
                            break;
                        case 3 :
                            removeCity(cityTable,distanceMatrix);
                            storeCityTable(cityTable);
                            storeDistanceMatrix(distanceMatrix);
                            break;
                        case 0 :
                            System.out.println();
                            System.out.println("Returning to Main Menu...");
                            System.out.println();
                            break;
                        default :
                            System.out.println();
                            System.out.println("Invalid input !!!");
                            System.out.println();
                            break;
                    }
                }
                break;}

            case 2:
                int secondSubMenuChoice = -1;
                while ( secondSubMenuChoice!= 0) {
                    System.out.println("\n--- DISTANCE MANAGEMENT ---");
                    System.out.println("1. Update Distance");
                    System.out.println("2. Display Distance Matrix");
                    System.out.println("0. Back");
                    
                    while (true) {
                        System.out.println();
                        System.out.print("Option: ");
                        String secondSubMenuChoiceHolder = input.nextLine();
                        System.out.println();
                        try {//checkin if the input is an integer, if this code block is not present the program crashes if a wrong data type is entered
                            secondSubMenuChoice = Integer.parseInt(secondSubMenuChoiceHolder);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Please input an integer input relevent to the options shown.");
                            System.out.println();
                        
                        }
                        
                    }

                    switch (secondSubMenuChoice) {
                        case 1 :
                            updateDistance(cityTable, distanceMatrix);
                            storeDistanceMatrix(distanceMatrix);
                            break;
                        case 2 : 
                            displayDistanceMatrix(distanceMatrix, cityTable);
                            break;

                        case 0 :
                            System.out.println();
                            System.out.println("Returning to Main Menu...");
                            System.out.println(); 
                            break;

                        default :
                            System.out.println();
                            System.out.println("Invalid input !!!");
                            System.out.println();
                            break;
                    }
                }
                break;

            case 3 :
                addOder(cityTable, distanceMatrix, vehicleTable, orderTable, deliveryRecord);
                storeDeliveryRecord(deliveryRecord);
                break;
            case 4 :
                generatePerformanceReport(deliveryRecord);
                break;
            case 0 :
                System.out.println("Exiting...");
                break;
            default :
                 System.out.println("Invalid input !!!");
                 break;
        }
    }

      
}

    public static void addCity(String[] cityTable){
        System.out.println();
        System.out.println("What is the name of the city ? ");
         
        String cityName=input.nextLine();
        int index = openIndex(cityTable); // method checks for an empty index and returns it
        if(index == -1){
            System.out.println("The maximum capacity for the amount of cities have been reached !!!");
              
            return;
        }
        cityTable[index]=cityName.substring(0,1).toUpperCase() + cityName.substring(1).toLowerCase(); //capitalising the first letter
          
        System.out.println();
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

    public static int getCityIndex(String [] cityTable,String cityName){
        int index = -99;
        for(int i = 0; i < MAX_CITIES ; i++){
            if(cityTable[i]!=null){
                if(cityName.equalsIgnoreCase(cityTable[i])) {
                index = i;
                }
            }
         }
         return(index);
    }
        public static void renameCity(String[] array){
          
        System.out.println("What is the city you need to rename ? ");
        String city = input.nextLine();
        int index = getCityIndex(array, city); //gets the index of the city by the given name

        if (index == -99) {
            System.out.println("Wrong City Name Entered !!!");
            System.out.println("Try Again!!!");
            return;
            
        }

        System.out.println("What do you need to rename the city as ? ");
        String renamedCity = input.nextLine();
        array[index] = renamedCity.substring(0,1).toUpperCase() + renamedCity.substring(1).toLowerCase(); //capitalising the first letter
    }

    
    public static void removeCity(String[] cityTable, double[][] distanceMatrix){
        System.out.println("What city do you need removed ? ");
         
        String city = input.nextLine();
        int index = getCityIndex(cityTable, city); //fetches the index of the city
        cityTable[index] = null;
        System.out.println("City removed successfully !");
        for(int i = 0 ; i < distanceMatrix[index].length ; i++ ){
            distanceMatrix[index][i] = -1; //updates the relevent cells with the default value
        }
          
    }




    public static void updateDistance(String[] cityTable, double[][] distance) {
        int start = -1;
        int end = -1;
        String exit = "not exit";
        System.out.println("(To exit the sequence type, exit)"); //can exit the sequence at any point by typing exit
        

        while (!exit.equalsIgnoreCase("exit")) {
            System.out.println();
            System.out.print("Departure :  ");
            String cityName = input.nextLine();
            if (cityName.equalsIgnoreCase("exit")) {
                break;
            }

            start = getCityIndex(cityTable, cityName);
            if (start == -99) {
                System.out.println("Wrong City Name Entered !!!");
                System.out.println("Try Again!!!");
                System.out.println("(To exit the sequence type, exit)");
                
                continue;
            }

            while (!exit.equalsIgnoreCase("exit")) {
                System.out.println();
                System.out.print("Destination : ");
                cityName = input.nextLine();
                if (cityName.equalsIgnoreCase("exit")) {
                    exit = "exit";
                    break;
                }

                end = getCityIndex(cityTable, cityName);
                if (end == -99) {
                    System.out.println();
                    System.out.println("Wrong City Name Entered !!!");
                    System.out.println("Try Again!!!");
                    continue;
                }
                if (end == start) {
                    System.out.println();
                    System.out.println("The distance between a city and itself is 0.");
                    distance[start][end]=0;
                }
                System.out.print("What is the distance between " + cityTable[start] + " and " + cityTable[end] + " (km): ");
                double distance1 = input.nextDouble();
                input.nextLine(); 
                distance[start][end] = distance1; //ensures symmetry 
                distance[end][start] = distance1;
                System.out.println();

                System.out.print("Type 'exit' to stop or press 'Enter' to continue: ");
                exit = input.nextLine();
                System.out.println();
            }
        }

    
    }
    public static void displayDistanceMatrix(double[][] distanceMatrix, String[] cityTable) {
        System.out.printf("%-15s", ""); 
        for (int i = 0; i < MAX_CITIES; i++) { //takes the city names from the cityTable and prints them 
            if (cityTable[i] != null && !cityTable[i].isEmpty()) {
                System.out.printf("| %-12s", cityTable[i]);
            }
        }
        System.out.println();
        System.out.println("=".repeat(15 * (MAX_CITIES + 1))); // separates the header row 
        for (int j = 0; j < MAX_CITIES; j++) { 
            if (cityTable[j] == null || cityTable[j].isEmpty()){ 
                continue;
            }
            System.out.printf("%-15s", cityTable[j]); 

            for (int k = 0; k < MAX_CITIES; k++) { //prints the distances taken from distanceMatrix
                if (cityTable[k] == null || cityTable[k].isEmpty()){
                    continue;
                }
                if (distanceMatrix[j][k] == -1) {
                    System.out.printf("| %-12s", "—");
                } else {
                    System.out.printf("| %-12.2f", distanceMatrix[j][k]);
                }
            }
            System.out.println();
        }
    }






  


    public static void addOder(String[] citiyTable, double[][] distanceMatrix, double[][] vehicleTable, double[] orderTable, String[][] deliveryRecord){

        //takes the order and also updates the delivery record and outputs the delivery reciept 
        
        double cargo;
        int vehicleIndex ;

        System.out.println("What is the source city name ? ");
        String source = input.nextLine();
        int sourceIndex = getCityIndex(citiyTable, source);

        System.out.println("What is the destination city name ? ");
        String destination = input.nextLine();
        int destinationIndex = getCityIndex(citiyTable, destination);

        if (sourceIndex == destinationIndex) {
            System.out.println("Souce city and Destination city cannot be the same .");
            System.out.println("Invalid input. please try again !!!");
            return;
            
        }

        while (true) {
            String choiceHolder;
            
            System.out.println("How much cargo does the customer want to transpot ? (in kg) ");
            while (true) { //checks for the right input type
                choiceHolder =  input.nextLine();;
                try {
                cargo = Integer.parseInt(choiceHolder);
                break;
                } catch (NumberFormatException e) {
                System.out.println("Pleae enter a valid weight ! ");
            
                }
            
            }
            
            System.out.println("What is the customer's prefered vehicle type ? (1 = Van, 2 = Truck, 3 = Lorry)" );
            System.out.println("Max weight -> 1. Van   =  1,000 kg");
            System.out.println("           -> 2. Truck =  5,000 kg");
            System.out.println("           -> 3. Lorry = 10,000 kg");
            
            while (true) {//checks for the right input type
                choiceHolder =  input.nextLine();;
                try {
                vehicleIndex = Integer.parseInt(choiceHolder)-1;
                break;
                } catch (NumberFormatException e) {
                System.out.println("Pleae enter a valid vehicle choice ! ");
            
                }
            
            }
            if (vehicleTable[vehicleIndex][0] < cargo ) {
                System.out.println("The customer's prefered vehicle doesn't allow the cargo weight.");
                System.out.println("Invalid input. please try again !!!");
                continue;
                }
                break;
    }
        
        orderTable[0] = minimumDistance(distanceMatrix, sourceIndex, destinationIndex); //For consistency it was assumed that minimum distance was used to calculate the costs because of the output given in the pdf eventhough it was mentioned to take distance from distance matrix.

        orderTable[1] = cargo;
        orderTable[2] = vehicleTable[vehicleIndex ][1];
        orderTable[3] = vehicleTable[vehicleIndex ][2];
        orderTable[4] = vehicleTable[vehicleIndex ][3];
        orderTable[5] = FUEL_PRICE;
        
        int openIndex = -1;
        for(int i = 0 ; i<50 ; i++){
            if (deliveryRecord[i][0] == null || deliveryRecord[i][0].isEmpty()) {
                openIndex = i;
                break;
                }
        }
        
        if (openIndex == -1) {
            System.out.println("Delivery record is full"); 
            return;
            
        }
        else{
            deliveryRecord[openIndex][0] = source.substring(0,1).toUpperCase() + source.substring(1).toLowerCase();
            deliveryRecord[openIndex][1] = destination.substring(0,1).toUpperCase() + destination.substring(1).toLowerCase();
            deliveryRecord[openIndex][2] = String.valueOf(minimumDistance(distanceMatrix, sourceIndex, destinationIndex));
            switch (vehicleIndex) {
                case 0:
                    deliveryRecord[openIndex][3] = "Van";
                    break;
                case 1:
                    deliveryRecord[openIndex][3] = "Truck";
                    break;
                case 2:
                    deliveryRecord[openIndex][3] = "Lorry";    
                    break;
                default:
                    break;
            }
            deliveryRecord[openIndex][4] = String.valueOf(cargo);
            deliveryRecord[openIndex][5] = String.valueOf(deliveryCost(orderTable));
            deliveryRecord[openIndex][6] = String.valueOf(fuelConsumption(orderTable));
            deliveryRecord[openIndex][7] = String.valueOf(fuelCost(orderTable));
            deliveryRecord[openIndex][8] = String.valueOf(TotalOperationCost(orderTable));
            deliveryRecord[openIndex][9] = String.valueOf(profit(orderTable));
            deliveryRecord[openIndex][10] = String.valueOf(profit(orderTable)+TotalOperationCost(orderTable));
            deliveryRecord[openIndex][11] = String.valueOf(estimatedDeliveryTime(orderTable));
            deliveryRecord[openIndex][12] = String.valueOf(orderTable[2]);

            generateDeliveryReciept(deliveryRecord, openIndex); 
        }

    }

    // for calculations oderTable is used (temporary array used to hold the current oder's value) because the whole taking the order and delivery reciept printing process is one method
    public static double deliveryCost(double[] orderTable){
        double cost = orderTable[0] * orderTable[2] * (1+ orderTable[1]*1/10000);
        return(cost);
    }
    public static double estimatedDeliveryTime(double[] orderTable){
        double time = orderTable[0] / orderTable[3];
        return(time);
    }

    public static double fuelConsumption(double[] orderTable){

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
    public static double minimumDistance(double[][] distanceMatrix,int source, int destination ){
        double minimumDistance = distanceMatrix[source][destination];
        for(int i = 0; i<MAX_CITIES; i++ ){
            for(int j = 0; j<MAX_CITIES; j++){
                for(int k = 0; k<MAX_CITIES; k++){
                    double testDistance = distanceMatrix[source][i] + distanceMatrix[i][j] + distanceMatrix[j][k]+distanceMatrix[k][destination];
                    if(minimumDistance > testDistance){
                        minimumDistance = testDistance;
                    }
                }
            }
        }
        return minimumDistance;  
    }

    
    public static void generateDeliveryReciept(String[][] deliveryRecord,int openIndex){
        System.out.println();
        System.out.println("==============================================================================");
        System.out.println("DELIVERY COST ESTIMATION ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("From : " + deliveryRecord[openIndex][0]);
        System.out.println("To : " + deliveryRecord[openIndex][1]);
        System.out.println("Minimum Distance : " + deliveryRecord[openIndex][2]+" km");
        System.out.println("Vehicle : " + deliveryRecord[openIndex][3]);
        System.out.println("Weight : " + deliveryRecord[openIndex][4]+" kg"); 
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Base Cost : "+ deliveryRecord[openIndex][2]+" X " + deliveryRecord[openIndex][12]+" X "+"( 1 + "+deliveryRecord[openIndex][4]+" / 10000 )"+" = "+ deliveryRecord[openIndex][5]+" LKR");
        System.out.println("Fuel Used : " + deliveryRecord[openIndex][6]+" L");
        System.out.println("Fuel Cost :" + deliveryRecord[openIndex][7]+" LKR");
        System.out.println("Operational Cost : " + deliveryRecord[openIndex][8]+" LKR");
        System.out.println("Profit : " + deliveryRecord[openIndex][9]+" LKR");
        System.out.println("Customer Charge : " + deliveryRecord[openIndex][10]+" LKR");
        System.out.println("Estimated Time : " + deliveryRecord[openIndex][11]+" hours"); 
        System.out.println("==============================================================================");
        System.out.println();

    }
    public static void generatePerformanceReport(String[][] deliveryRecord){
        int deliveries = 0;
        double totalDistanceTravelled = 0;
        double totalTime = 0;
        int count = 1;
        double totalRevenue = 0;
        double totalProfit = 0;
        double longestRoute = 0;
        double shortestRoute = INFINITY;
        for(int i = 0 ; i<MAX_RECORDS ; i++){ //loops throgh all the rows
            if (!deliveryRecord[i][0].isEmpty() ) {
                deliveries = i+1;
                }
            if(!deliveryRecord[i][2].isEmpty()){
                totalDistanceTravelled += Double.parseDouble(deliveryRecord[i][2]);
                }
            if(!deliveryRecord[i][11].isEmpty()){
                totalTime += Double.parseDouble(deliveryRecord[i][11]);
                count += 1;
                }

            if(!deliveryRecord[i][10].isEmpty()){
                totalRevenue += Double.parseDouble(deliveryRecord[i][10]);
                totalProfit+= Double.parseDouble(deliveryRecord[i][9]);
                }
            if(!deliveryRecord[i][2].isEmpty() && longestRoute < Double.parseDouble(deliveryRecord[i][2])){
                longestRoute = Double.parseDouble(deliveryRecord[i][2]);
                }
            if(!deliveryRecord[i][2].isEmpty() && shortestRoute > Double.parseDouble(deliveryRecord[i][2])){
                shortestRoute = Double.parseDouble(deliveryRecord[i][2]);
                }   
        }
        double avgDeliveryTime = totalTime/count;
        System.out.println();
        System.out.println("====================================================");
        System.out.println("PERFORMANCE REPORT");
        System.out.println("----------------------------------------------------");
        System.out.println("Total Deliveries Completed : "+deliveries);
        System.out.println("Total Distance Covered : "+totalDistanceTravelled+" KM");
        System.out.println("Average Deilvery Time : "+avgDeliveryTime+" Hours");
        System.out.println("Total Revenue :"+totalRevenue+" LKR");
        System.out.println("Total Profit : "+totalProfit+" LKR");
        System.out.println("Longest Route Completed : "+longestRoute+" km");
        System.out.println("Shortest Route Completed : "+shortestRoute+" km");
        System.out.println("----------------------------------------------------");
        System.out.println();





    }
    public static void storeCityTable(String[] cityTable){
        try{
            FileWriter writer = new FileWriter("City Table.txt");
            for(int i = 0; i <cityTable.length; i++){
                writer.write(cityTable[i] + "\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the City Talble.txt.");
            e.printStackTrace();
        }
    }
    public static void storeDistanceMatrix(double[][] distanceMatrix){
        try {
            FileWriter writer = new FileWriter("Distance Matrix.txt");
            for(int i = 0; i < distanceMatrix.length ; i++){
                for(int j = 0; j < distanceMatrix[i].length ; j++){
                    writer.write(String.format("%-8s",String.valueOf(distanceMatrix[i][j])));
                    if(j < distanceMatrix[i].length - 1){
                        writer.write("\t");
                    }
                }
                writer.write("\n");

            }
            writer.close();
            
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the Distance Matrix.txt.");
            e.printStackTrace();
        }



    }
    public static void storeDeliveryRecord(String[][] deliveryRecord){
        try {
            FileWriter writer = new FileWriter("Delivery Record.txt");
            for(int i = 0; i < deliveryRecord.length ; i++){
                for(int j = 0; j < deliveryRecord[i].length ; j++){
                    writer.write(String.format("%-20s",deliveryRecord[i][j]));
                    if(j < deliveryRecord[i].length - 1){
                        writer.write("\t");
                    }
                }
                writer.write("\n");

            }
            writer.close();
            
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the Delivery Record.txt.");
            e.printStackTrace();
        }



    }
    public static void loadCityTable(String[] cityTable){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("City Table.txt"));

            String city;
            for(int i =0 ; i < MAX_CITIES; i++){
                city = reader.readLine();
                if(city != null){
                    cityTable[i] = city.trim();
                }
                else{
                    cityTable[i] = null;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        
    }
    public static void loadDistanceMatrix(double[][] distanceMatrix){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Distance Matrix.txt"));
            String line;

            for(int i = 0; i < MAX_CITIES ; i++){
                line = reader.readLine();
                if(line != null){
                    String[] distance = line.trim().split("\\t+");
                    for(int j=0; j<MAX_CITIES ; j++){
                        distanceMatrix[i][j]=Double.parseDouble(distance[j]);

                    }

                }



            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public static void loadDeliveryRecord(String[][] deliveryRecord){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Delivery Record.txt"));
            String line;

            for(int i = 0; i < MAX_RECORDS  ; i++){
                line = reader.readLine();
                if(line != null){
                    String[] delivery = line.trim().split("\\t+");
                    for(int j=0; j<13 ; j++){
                        deliveryRecord[i][j]=delivery[j];

                    }

                }



            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
    

