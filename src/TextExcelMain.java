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
            String input = commandScanner.nextLine().toUpperCase();

            finisher = commandInput(input, newSheet);
        }



    }

    public static boolean commandInput(String input, SpreadSheet sheet){
            boolean finisher = false;
                while(!finisher)


            if ((input.toLowerCase().contains("print"))) {
                System.out.println(sheet.printSheet() );

            } else if ((input.toLowerCase().contains("exit"))) {
                System.out.println("Process: end");
                finisher = true;
            }else {
                System.out.println(sheet.printCellValue(input));
            }

        return finisher;

    }

}
