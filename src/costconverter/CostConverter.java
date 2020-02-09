package costconverter;

import java.util.Scanner;

public class CostConverter {

    static double travelCost, hotelCost, rentalCarCost, laborCost;
    static char choice;

    public static void main(String[] args) {
        GetCosts();
    }

    static void GetCosts() {
        Scanner in = new Scanner(System.in);
        
        /* Use nested while loops to catch any invalid numbers or negative values */
        while (true) {
            System.out.println("Enter Travel Cost in US Dollars without the $:");
            try {
                travelCost = Double.parseDouble(in.nextLine());
                while (travelCost <= 0) {
                    System.out.println("Enter Travel Cost in US Dollars, it must not be a negative number:");
                    travelCost = Double.parseDouble(in.nextLine());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid Input ... must contain positive numbers only!  No special characters are needed!");
            }
        }
        while (true) {
            System.out.println("Enter Hotel Cost in US Dollars without the $:");
            try {
                hotelCost = Double.parseDouble(in.nextLine());
                while (hotelCost <= 0) {
                    System.out.println("Enter Hotel Cost in US Dollars, it must not be a negative number:");
                    hotelCost = Double.parseDouble(in.nextLine());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid Input ... must contain positive numbers only!  No special characters are needed!");
            }
        }
        while (true) {
            System.out.println("Enter Rental Car Cost in US Dollars without the $:");
            try {
                rentalCarCost = Double.parseDouble(in.nextLine());
                while (rentalCarCost <= 0) {
                    System.out.println("Enter Rental Car Cost in US Dollars, it must not be a negative number:");
                    rentalCarCost = Double.parseDouble(in.nextLine());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid Input ... must contain positive numbers only!  No special characters are needed!");
            }
        }
        while (true) {
            System.out.println("Enter the Total Labor Cost in US Dollars without the $:");
            try {
                laborCost = Double.parseDouble(in.nextLine());
                while (laborCost <= 0) {
                    System.out.println("Enter Labor Cost in US Dollars, it must not be a negative number:");
                    laborCost = Double.parseDouble(in.nextLine());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid Input ... must contain positive numbers only!  No special characters are needed!");
            }
        }
        //Now that the values are correctly collected call the ConvertDollarsToAud() function
        ConvertDollarsToAud();
    }

    static void ConvertDollarsToAud() {
        Scanner in = new Scanner(System.in);
        
        //Convert USD values to AUD
        travelCost = travelCost * 1.49857;
        hotelCost = hotelCost * 1.49857;
        rentalCarCost = rentalCarCost * 1.49857;
        laborCost = laborCost * 1.49857;
        
        //Round up the computed numbers to the nearest dollar
        travelCost = Math.round(travelCost * 100.0) / 100.0;
        hotelCost = Math.round(hotelCost * 100.0) / 100.0;
        rentalCarCost = Math.round(rentalCarCost * 100.0) / 100.0;
        laborCost = Math.round(laborCost * 100.0) / 100.0;

        //Output the AUD values using two decimal places in the String.format
        System.out.println("\nCosts Converted to AUD From USD, Current AUD Rate is 1.49857 Per Dollar\n");
        System.out.println("Travel Cost Converted To AUD is: " + String.format("%.2f", travelCost) + "\n"
                + "Hotel Cost Converted To AUD is: " + String.format("%.2f", hotelCost) + "\n"
                + "Rental Car Cost Converted To AUD is: " + String.format("%.2f", rentalCarCost) + "\n"
                + "Labor Cost Converted To AUD is: " + String.format("%.2f", laborCost) + "\n");

        //Do a while loop to repeat the process until the user enters 'n'
        while (choice != 'N') {
            System.out.println("Enter 'Y' to do again, 'N' to stop");
            choice = Character.toUpperCase(in.nextLine().charAt(0));

            if (choice == 'Y') {
                GetCosts();
            }
        }
    }
}
