/**
 * Created by bal_mcmishina on 3/3/2016.
 */
import java.util.Scanner;



public class TextExcelMain {

    /**
     * Method Description - Beginning of the code, tells the user to enter a command until the boolean, finisher, is true.
     *
     * @param args   - command line arguments
     *
     */
    public static void main(String[]args){
        boolean finisher = false;
        Scanner commandScanner = new Scanner(System.in);
        SpreadSheet newSheet = new SpreadSheet();

        System.out.print("Welcome. ");
        while(!finisher) {
            System.out.println("Enter a command.");
            String input = commandScanner.nextLine();

            finisher = commandInput(input, newSheet);
        }



    }

    /**
     * Method Description - takes in the input from the scanner, and uses the appropriate method
     *
     * @param input - the input from the scanner created in the main method.
     * @param sheet - the new spreadsheet, with all of the methods that every textExcel needs.
     * @return - returns the finisher. This is done every time until finisher is true, which ends the code.
     *
     */
    public static boolean commandInput(String input, SpreadSheet sheet){
            boolean finisher = false;


        if ((input.toLowerCase().contains("print"))) {
            System.out.println(sheet.printSheet());

        } else if ((input.toLowerCase().contains("exit"))) {
            System.out.println("Process: end");
            finisher = true;
        } else if ((input.contains(" = "))) {
            sheet.setCellValue(input);
        } else if ((input.toLowerCase().contains("clear"))) {
            String[] clearArray = input.split(" ");

                if (clearArray.length == 1) {
                    sheet.clearSheet();
                } else if (clearArray.length == 2) {
                    sheet.clearCellValue(clearArray[1]);
                } else {
                    sheet.clearRange(input.substring(input.indexOf("r") + 1).trim() );
                }


        } else if ((input.contains("sort"))) {
            String[] sortArray = input.split(" ");

            if (sortArray[0].contains("a")) {

                sheet.sort(input, true);
            } else {
                sheet.sort (input, false);
            }

        }else{
                    System.out.println(sheet.printCellValue(input));
                }


        return finisher;

    }

}
