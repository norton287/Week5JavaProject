package costconverter;

import java.util.Scanner;

public class CostConverter {

    static double travelCost, hotelCost, rentalCarCost, laborCost, tcConvertedToAud, hcConvertedToAud, rcCostConvertedToAud, lcConvertedToAud;
    static char choice;

    public static void main(String[] args) {
        GetCosts();
    }

    static void GetCosts() {
        Scanner in = new Scanner(System.in);

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
                System.out.println("Invalid Input ... must contain positive numbers only!");
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
                System.out.println("Invalid Input ... must contain positive numbers only!");
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
                System.out.println("Invalid Input ... must contain positive numbers only!");
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
                System.out.println("Invalid Input ... must contain positive numbers only!");
            }
        }
        //Now that the values are correctly collected call the ConvertDollarsToAud() function
        ConvertDollarsToAud();
    }

    static void ConvertDollarsToAud() {
        Scanner in = new Scanner(System.in);
        
        //Vars for rounding up to nearest dollar otherwise numbers are off
        double roundedTc, roundedHc, roundedRc, roundedLc;
        
        //Convert USD values to AUD
        tcConvertedToAud = travelCost * 1.48271;
        hcConvertedToAud = hotelCost * 1.48271;
        rcCostConvertedToAud = rentalCarCost * 1.48271;
        lcConvertedToAud = laborCost * 1.48271;
        
        //Round up the computed numbers to the nearest dollar
        roundedTc = Math.round(tcConvertedToAud * 100.0) / 100.0;
        roundedHc = Math.round(hcConvertedToAud * 100.0) / 100.0;
        roundedRc = Math.round(rcCostConvertedToAud * 100.0) / 100.0;
        roundedLc = Math.round(lcConvertedToAud * 100.0) / 100.0;

        //Output the AUD values using two decimal places in the String.format
        System.out.println("\nCosts Converted to AUD From USD, Current AUD Rate is 1.48271 Per Dollar\n");
        System.out.println("Travel Cost Converted To AUD is: " + String.format("%.2f", roundedTc) + "\n"
                + "Hotel Cost Converted To AUD is: " + String.format("%.2f", roundedHc) + "\n"
                + "Rental Car Cost Converted To AUD is: " + String.format("%.2f", roundedRc) + "\n"
                + "Labor Cost Converted To AUD is: " + String.format("%.2f", roundedLc) + "\n");

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
