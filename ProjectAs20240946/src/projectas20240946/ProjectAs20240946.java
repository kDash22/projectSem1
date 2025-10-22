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
    static final int MAX_CITIES = 30;
    static final double INFINITY = 999999999;
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

        int indexCities = 0  ;
        String[] cities = new String[MAX_CITIES];
        double[][]  distanceTable= new double[MAX_CITIES][MAX_CITIES];
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
        cities[0]="colombo";
        cities[1]="homagama";
        cities[3]="maharagama";
        cities[2]="kottawa";
        cities[4]="nugegoda";
        cities[5]="kirulapone";
        //for testing purposes
        double[][] distances = {
                                { 0, 50, 14, 18, 10,  6}, // Colombo
                                {50,  0, 10,  7, 40, 20}, // Homagama
                                {14, 10,  0,  5, 20, 12}, // Maharagama
                                {18,  7,  5,  0, 12, 15}, // Kottawa
                                {10, 40, 20, 12,  0,  9}, // Nugegoda
                                { 6, 20, 12, 15,  9,  0}  // Kirulapone
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

        
        generatePerformanceReport(testDeliveryRecord);       
    
                
        
        
        

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
        array[index]=cityName.substring(0,1).toUpperCase() + cityName.substring(1).toLowerCase();
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

    public static void addOder(String[] citiyTable, double[][] distanceTable, double[][] vehicleTable, double[] orderTable, String[][] deliveryRecord){
        double cargo;
        int vehicleIndex ;

        Scanner input = new Scanner(System.in);
        
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
            System.out.println("What is the customer's prefered vehicle type ? (1 = Van, 2 = Truck, 3 = Lorry)" );
            vehicleIndex = input.nextInt()-1;
            if (vehicleTable[vehicleIndex][0] < cargo ) {
                System.out.println("The customer's prefered vehicle doesn't allow the cargo weight.");
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

        
        orderTable[0] = minimumDistance(distanceTable, sourceIndex, destinationIndex); // it was assumed that minimum distance was used to calculate the costs because of the output given eventhough it was mentioned distance was taken from distance matrix for consistency 
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
        deliveryRecord[openIndex][3] = String.valueOf(minimumDistance(distanceTable, sourceIndex, destinationIndex))+" km";
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
    public static double minimumDistance(double[][] distanceTable,int source, int destination ){
        double minimumDistance = distanceTable[source][destination];
        for(int i = 0; i<MAX_CITIES; i++ ){
            for(int j = 0; j<MAX_CITIES; j++){
                for(int k = 0; k<MAX_CITIES; k++){
                    double testDistance = distanceTable[source][i] + distanceTable[i][j] + distanceTable[j][k]+distanceTable[k][destination];
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
        for(int i = 0 ; i<7 ; i++){
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
