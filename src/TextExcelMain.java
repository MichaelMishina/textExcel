/**
 * Created by bal_mcmishina on 3/3/2016.
 */
import java.util.Scanner;



public class TextExcelMain {

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
        //something something
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

            if (sortArray[1].contains("a")) {

            } else {
                return (false);
            }

        }else{
                    System.out.println(sheet.printCellValue(input));
                }


        return finisher;

    }

}
