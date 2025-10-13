/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectas20240946;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 *
 * @author Kalana Dasanayaka
 */
public class ProjectAs20240946 {

   
    public static void main(String[] args) {
        int indexCities = 0  ;
        String cities[] = new String[30];
        System.out.println(cities[indexCities]);
        int a = openIndex(cities);
        System.out.println(a);
    }
    public static void menu(String[] array, int index){ 
        int choice = 0; 
        while (choice!=99) {
            
        
        System.out.print("Menu Option : ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        switch (choice) {
            case 1:
                addCity(array, index);
                break;
            case 2:
                break;

            default:
                break;
        }


    }
    }
    public static int addCity(String[] array){
        int index;
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
