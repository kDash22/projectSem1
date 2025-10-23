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
    static final int MAX_CITIES = 10;
    static final double INFINITY = 999999999;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        


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



        String[][] deliveryRecord = new String[50][14]; 
        /* NIC =                deliveryRecord[][0] 
         * from =               deliveryRecord[][1]
         * to =                 deliveryRecord[][2]
         * minimun distance =   deliveryRecord[][3]
         * vehicle =            deliveryRecord[][4]
         * weight =             deliveryRecord[][5]
         * base cost =          deliveryRecord[][6]
         * fuel used =          deliveryRecord[][7]
         * fuel cost =          deliveryRecord[][8]
         * operation cost =     deliveryRecord[][9]
         * profit =             deliveryRecord[][10]
         * customer charge =    deliveryRecord[][11]
         * estimated time =     deliveryRecord[][12]
         * rater per km =       deliveryRecord[][13]
         * */

        //for testing purposes
            String[] testCities = {
                "Colombo",        // 0
                "Kandy",          // 1
                "Galle",          // 2
                "Matara",         // 3
                "Jaffna",         // 4
                "Trincomalee",    // 5
                "Batticaloa",     // 6
                "Negombo",        // 7
                "Kurunegala",     // 8
                "Anuradhapura",   // 9
            };

        //for testing purposes
        String[][] testDeliveryRecord = {
    
    {"200134567", "Colombo",    "Kottawa",     "18",        "Van",      "1500",     "800",       "3.5",       "1575",      "2000",    "925",     "2925",        "35",    "90"},
    {"991245678", "Homagama",   "Nugegoda",    "40",        "Lorry",    "5000",     "2000",      "9.0",       "4050",      "5200",    "2050",    "7250",        "70",    "95"},
    {"200112345", "Kirulapone", "Colombo",     "6",         "Truck",    "2000",     "1000",      "2.0",       "900",       "1300",    "600",     "1900",        "15",    "95"},
    {"200078945", "Maharagama", "Homagama",    "10",        "Van",      "1200",     "700",       "2.5",       "1125",      "1500",    "625",     "2125",        "25",    "85"},
    {"993456781", "Nugegoda",   "Kirulapone",  "9",         "Truck",    "3500",     "1500",      "3.0",       "1350",      "1800",    "850",     "2650",        "20",    "88"},
    {"200234567", "Kottawa",    "Colombo",     "18",        "Lorry",    "8000",     "3000",      "10.5",      "4725",      "6000",    "2000",    "8000",        "50",    "90"},
    {"200998877", "Colombo",    "Homagama",    "25",        "Truck",    "2500",     "1200",      "5.0",       "2250",      "2800",    "1250",    "4050",        "40",    "85"}
};
        //for testing purposes

        double[][] testDistanceMatrix = {
            //  0    1    2    3    4    5    6    7    8    9
            {  0, 115, 120, 400,  38,  94, 205, 105, 275, 160}, // Colombo
            {115,   0, 230, 365, 120,  42, 150,  95, 185, 245}, // Kandy
            {120, 230,   0, 520, 155, 210, 315, 140, 365,  45}, // Galle
            {400, 365, 520,   0, 370, 250, 195, 420, 220, 515}, // Jaffna
            { 38, 120, 155, 370,   0,  72, 190, 125, 260, 175}, // Negombo
            { 94,  42, 210, 250,  72,   0, 115,  80, 155, 210}, // Kurunegala
            {205, 150, 315, 195, 190, 115,   0, 220, 125, 300}, // Anuradhapura
            {105,  95, 140, 420, 125,  80, 220,   0, 280, 120}, // Ratnapura
            {275, 185, 365, 220, 260, 155, 125, 280,   0, 345}, // Trincomalee
            {160, 245,  45, 515, 175, 210, 300, 120, 345,   0}  // Matara
        };   
    
                
        
        menu(cityTable, distanceMatrix, VEHICLE_TABLE, orderTable, deliveryRecord);
        
        input.close();
    }
public static void menu(String[] cityTable, double[][] distanceMatrix, double[][] vehicleTable,double[] orderTable, String[][] deliveryRecord) {

     
    int choice = -1;

    while (choice != 0) {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. City Management");
        System.out.println("2. Distance Management");
        System.out.println("3. Delivery Request Handling");
        System.out.println("4. Reports");
        System.out.println("0. Exit");
        System.out.print("Menu Option: ");
        choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:{
                int firstSubMenuChoice = -1;
                while (firstSubMenuChoice != 0) {
                    System.out.println("\n--- CITY MANAGEMENT ---");
                    System.out.println("1. Add City");
                    System.out.println("2. Rename City");
                    System.out.println("3. Remove City");
                    System.out.println("0. Back");
                    System.out.print("Option: ");
                    firstSubMenuChoice = input.nextInt();
                    input.nextLine();

                    switch (firstSubMenuChoice) {
                        case 1 :
                         addCity(cityTable);
                         break;
                        case 2 :
                        renameCity(cityTable);
                        break;
                        case 3 :
                         removeCity(cityTable);
                         break;
                        case 0 :
                         System.out.println("Returning to Main Menu...");
                         break;
                        default :
                         System.out.println("Invalid input !!!");
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
                    System.out.print("Option: ");
                    secondSubMenuChoice = input.nextInt();
                    input.nextLine();

                    switch (secondSubMenuChoice) {
                        case 1 :
                            updateDistance(cityTable, distanceMatrix);
                            break;
                        case 2 : 
                            displayDistanceMatrix(distanceMatrix, cityTable);
                            break;

                        case 0 :
                             System.out.println("Returning to Main Menu...");
                             break;

                        default :
                             System.out.println("Invalid input !!!");
                             break;
                    }
                }
                break;

            case 3 :
                 addOder(cityTable, distanceMatrix, vehicleTable, orderTable, deliveryRecord);
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
        int index = openIndex(cityTable);
        if(index == -1){
            System.out.println("The maximum capacity for the amount of cities have been reached !!!");
              
            return;
        }
        cityTable[index]=cityName.substring(0,1).toUpperCase() + cityName.substring(1).toLowerCase();
          
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
         
        String city = input.nextLine();
        int index = getCityIndex(array, city);
        array[index] = "";
          
    }




    public static void updateDistance(String[] cityTable, double[][] distance) {
        int start = -1;
        int end = -1;
         
        String exit = "not exit";

        while (!exit.equalsIgnoreCase("exit")) {
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
                System.out.print("Destination : ");
                cityName = input.nextLine();
                if (cityName.equalsIgnoreCase("exit")) {
                    exit = "exit";
                    break;
                }

                end = getCityIndex(cityTable, cityName);
                if (end == -99) {
                    System.out.println("Wrong City Name Entered !!!");
                    System.out.println("Try Again!!!");
                    continue;
                }
                if (end == start) {
                    System.out.println("The distance between a city and itself is 0.");
                    distance[start][end]=0;
                }
                System.out.print("What is the distance between " + cityTable[start] + " and " + cityTable[end] + " (km): ");
                double distance1 = input.nextDouble();
                input.nextLine(); 
                distance[start][end] = distance1;
                distance[end][start] = distance1;

                System.out.print("Type 'exit' to stop or press 'Enter' to continue: ");
                exit = input.nextLine();
                System.out.println();
            }
        }

    
    }
    public static void displayDistanceMatrix(double[][] distanceMatrix, String[] cityTable) {
        System.out.printf("%-15s", ""); 
        for (int i = 0; i < MAX_CITIES; i++) {
            if (cityTable[i] != null && !cityTable[i].isEmpty()) {
                System.out.printf("| %-12s", cityTable[i]);
            }
        }
        System.out.println();
        System.out.println("=".repeat(15 * (MAX_CITIES + 1)));
        for (int j = 0; j < MAX_CITIES; j++) {
            if (cityTable[j] == null || cityTable[j].isEmpty()){ 
                continue;
            }
            System.out.printf("%-15s", cityTable[j]); 

            for (int k = 0; k < MAX_CITIES; k++) {
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
            System.out.println("How much cargo does the customer want to transpot ? (in kg) ");
            cargo = input.nextDouble();
            input.nextLine();
            System.out.println("What is the customer's prefered vehicle type ? (1 = Van, 2 = Truck, 3 = Lorry)" );
            vehicleIndex = input.nextInt()-1;
            input.nextLine();
            if (vehicleTable[vehicleIndex][0] < cargo ) {
                System.out.println("The customer's prefered vehicle doesn't allow the cargo weight.");
                System.out.println("Invalid input. please try again !!!");
                continue;
                }
                break;
    }
        
        orderTable[0] = minimumDistance(distanceMatrix, sourceIndex, destinationIndex); // it was assumed that minimum distance was used to calculate the costs because of the output given eventhough it was mentioned distance was taken from distance matrix for consistency 
        orderTable[1] = cargo;
        orderTable[2] = vehicleTable[vehicleIndex ][1];
        orderTable[3] = vehicleTable[vehicleIndex ][2];
        orderTable[4] = vehicleTable[vehicleIndex ][3];
        orderTable[5] = FUEL_PRICE;
        
        int openIndex = -1;
        for(int i = 0 ; i<50 ; i++){
            if (deliveryRecord[i][0] == null ) {
                openIndex = i;
                }
        }
        System.out.println("What is the customer's NIC number ? ");//assumned everyone has the new format of NIC ie; 12 digits
        long NIC = input.nextLong();
        if (openIndex == 1) {
            System.out.println("Delivery record is full");
            return;
            
        }
        
        deliveryRecord[openIndex][0] = String.valueOf(NIC);
        deliveryRecord[openIndex][1] = source.substring(0,1).toUpperCase() + source.substring(1).toLowerCase();
        deliveryRecord[openIndex][2] = destination.substring(0,1).toUpperCase() + destination.substring(1).toLowerCase();
        deliveryRecord[openIndex][3] = String.valueOf(minimumDistance(distanceMatrix, sourceIndex, destinationIndex))+" km";
        switch (vehicleIndex) {
            case 0:
                deliveryRecord[openIndex][4] = "Van";
                break;
            case 1:
                deliveryRecord[openIndex][4] = "Truck";
                break;
            case 2:
                deliveryRecord[openIndex][4] = "Lorry";    
                break;
            default:
                break;
        }
        deliveryRecord[openIndex][5] = String.valueOf(cargo);
        deliveryRecord[openIndex][6] = String.valueOf(deliveryCost(orderTable));
        deliveryRecord[openIndex][7] = String.valueOf(fuelConsumption(orderTable));
        deliveryRecord[openIndex][8] = String.valueOf(fuelCost(orderTable));
        deliveryRecord[openIndex][9] = String.valueOf(TotalOperationCost(orderTable));
        deliveryRecord[openIndex][10] = String.valueOf(profit(orderTable));
        deliveryRecord[openIndex][11] = String.valueOf(profit(orderTable)+TotalOperationCost(orderTable));
        deliveryRecord[openIndex][12] = String.valueOf(estimatedDeliveryTime(orderTable));
        deliveryRecord[openIndex][13] = String.valueOf(orderTable[2]);

        generateDeliveryReciept(deliveryRecord, openIndex);

    }







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
        System.out.println("From : " + deliveryRecord[openIndex][1]);
        System.out.println("To : " + deliveryRecord[openIndex][2]);
        System.out.println("Minimum Distance : " + deliveryRecord[openIndex][3]+" km");
        System.out.println("Vehicle : " + deliveryRecord[openIndex][4]);
        System.out.println("Weight : " + deliveryRecord[openIndex][5]+" kg"); 
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Base Cost : "+ deliveryRecord[openIndex][3]+" X " + deliveryRecord[openIndex][13]+" X "+"( 1 + "+deliveryRecord[openIndex][5]+" / 10000 )"+" = "+ deliveryRecord[openIndex][6]+" LKR");
        System.out.println("Fuel Used : " + deliveryRecord[openIndex][7]+" L");
        System.out.println("Fuel Cost :" + deliveryRecord[openIndex][8]+" LKR");
        System.out.println("Operational Cost : " + deliveryRecord[openIndex][9]+" LKR");
        System.out.println("Profit : " + deliveryRecord[openIndex][10]+" LKR");
        System.out.println("Customer Charge : " + deliveryRecord[openIndex][11]+" LKR");
        System.out.println("Estimated Time : " + deliveryRecord[openIndex][12]+" hours"); 
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
        for(int i = 0 ; i<50 ; i++){
            if (deliveryRecord[i][0] != null && !deliveryRecord[i][0].isEmpty() ) {
                deliveries = i;
                }
            if(deliveryRecord[i][3] != null && !deliveryRecord[i][3].isEmpty()){
                totalDistanceTravelled += Double.parseDouble(deliveryRecord[i][3]);
                }
            if(deliveryRecord[i][12] != null && !deliveryRecord[i][12].isEmpty()){
                totalTime += Double.parseDouble(deliveryRecord[i][12]);
                count += 1;
                }

            if(deliveryRecord[i][11] != null && !deliveryRecord[i][11].isEmpty()){
                totalRevenue += Double.parseDouble(deliveryRecord[i][11]);
                totalProfit+= Double.parseDouble(deliveryRecord[i][10]);
                }
            if(deliveryRecord[i][3] != null && !deliveryRecord[i][3].isEmpty() && longestRoute < Double.parseDouble(deliveryRecord[i][3])){
                longestRoute = Double.parseDouble(deliveryRecord[i][3]);
                }
            if(deliveryRecord[i][3] != null && !deliveryRecord[i][3].isEmpty() && shortestRoute > Double.parseDouble(deliveryRecord[i][3])){
                shortestRoute = Double.parseDouble(deliveryRecord[i][3]);
                }   
        }
        double avgDeliveryTime = totalTime/count;
        System.out.println();
        System.out.println("====================================================");
        System.out.println("PERFORMANCE REPORT");
        System.out.println("----------------------------------------------------");
        System.out.println("Total Deliveries Completed : "+deliveries);
        System.out.println("Total Distance Covered : "+totalDistanceTravelled+" KM");
        System.out.println("Average Deilvery Time : "+avgDeliveryTime);
        System.out.println("Total Revenue :"+totalRevenue+" LKR");
        System.out.println("Total Profit : "+totalProfit+" LKR");
        System.out.println("Longest Route Completed : "+longestRoute+" km");
        System.out.println("Shortest Route Completed : "+shortestRoute+" km");
        System.out.println("----------------------------------------------------");
        System.out.println();





    }





    
}
