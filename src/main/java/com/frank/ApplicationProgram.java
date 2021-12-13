package com.frank;

import com.frank.types.Bowler;
import com.frank.types.NonNumericInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ApplicationProgram {

    private static List<Bowler> theBowlers = new ArrayList();
    public static void main(String[] args) {
       System.out.println("Start of application program");

       LoadBowlers();  // call method to instantiate some test data in ArrayList

       System.out.println("-".repeat(80) + "\n--- List of Bowlers ---");

       try {
           for (Bowler aBowler : theBowlers) {
               ShowBowler(aBowler);
           }
       }
       catch (Exception e) {
           System.out.println("Null Pointer Encountered");
           System.out.println("The system message says: " + e.getMessage());
           System.out.println("How we got to the exception ");
           // printStackTrace() writes to standard error stream
           // System.out writes to standard output stream (which is different from the error stream)
           // BOTH are assigned to screen by Java
           // Writing to both may cause unexpected/interleaved output lines
//           e.printStackTrace();
           System.out.println(Arrays.toString(e.getStackTrace())); // Fix to printStackTrace, sout-Arrays.toString-getStackTrace()
           System.out.println("Execution continuing...");
       }

        System.out.println("-".repeat(80));
        String response = "";
        boolean shouldLoop = true;
        Scanner theKeyBoard = new Scanner(System.in);



        while (shouldLoop) {
            System.out.println("\nEnter the number of the Bowler you would like displayed");
            System.out.printf("Valid numbers are 1 thru %d\nYour choice: ", theBowlers.size());
            response = theKeyBoard.nextLine();
            if (response.toLowerCase().charAt(0) == 'e') {
                shouldLoop = false;
                continue;
            }

            int bowlerNumber = Integer.parseInt(response); // defined outside the try block, so scope can be used in try block
            // throw custom exception if the user enters non-numeric bowler number
            try {
                ShowBowler(theBowlers.get(bowlerNumber - 1));
            }
            catch (NumberFormatException e) {
                throw new NonNumericInputException("Input value " + response + " was non-numeric");
            }

           }



        System.out.println("-".repeat(80));

        System.out.println("End of application program");
        return;
    }
    /**
     * Display data for a Bowler
     */
    private static void ShowBowler(Bowler aBowler) {
        System.out.print(aBowler);
        System.out.printf(" average: %.2f \n", aBowler.getAverage());
    }
    /**
     * Add test data to test program data store
     */
    private static void LoadBowlers() {
        theBowlers.add(new Bowler("Fred Flintstone", new int[] {230, 260, 275}));
        theBowlers.add(new Bowler("Barney Rubble",   new int[] {120, 140, 190}));
        theBowlers.add(new Bowler("The Dude",        new int[] {260, 270, 290}));
//        theBowlers.add(new Bowler());
        theBowlers.add(new Bowler("Roy Munson",      new int[] {225, 285, 252}));
    }
}
