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

   
    public static void main(String[] args) {
        final int MAX_CITIES = 30;

        int indexCities = 0  ;
        String cities[] = new String[MAX_CITIES];
        double distanceTable[][] = new double[MAX_CITIES][MAX_CITIES];
        
        //for testing purposes
        cities[0]="colombo";
        cities[1]="homagama";
        cities[3]="maharagama";
        cities[2]="kottawa";
        cities[4]="nugegoda";
        cities[5]="kirulapone";
        
                
        
        
        updateDistance(cities, distanceTable);

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
                if(name.toLowerCase().equals(array[i].toLowerCase()) ){
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
        array[index]=cityName;
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
}
