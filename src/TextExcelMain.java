/**
 * Created by bal_mcmishina on 3/3/2016.
 */
import java.util.Scanner;

/* Test Plan:
* print
* exit
* A1
* A2 = 12345
* A2
* A3 = "abcdefg"
* A3
* A4 = ()
* A4
* clear A1
* clear
* A5 = (1.6 + 1.4 * 2.845 / 6.443)
* A5
* A6 = (1.5 - 1.1 + 4.829 * 7.66 - 1000)
* A6
* A7 = (2.3 * 2.9 + 4.362)
* A7
* A8 = (4.564363461 / 2.5543254326)
* A8
* A9 = (A5 + A7 * A8 / A6)
* A9
* B1 = 1.75453
* B2 = 2.96436537
* B3 = 3.53673573
* B4 = 4.454544
* B5 = (avg B1 - B4)
* B5
* B6 = (sum B1 - B4)
* B6
* clear A1 - B6
* print
* A1 = 1.558948643
* A2 = 1.47657322
* A3 = 1.36546
* A4 = 1.26256757
* A5 = 1.142643563
* sorta A1 - A5
* sortd A1 - A5*/

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
                System.out.println(sheet.printSheet() );

            } else if ((input.toLowerCase().contains("exit"))) {
                System.out.println("Process: end");
                finisher = true;
            }else if ((input.contains( " = "))){
                sheet.setCellValue(input);
            } else if ((input.toLowerCase().contains("clear"))) {
                String[] clearArray = input.split(" ");

                if (clearArray.length == 1){
                    sheet.clearSheet();
                } else if (clearArray.length == 2){
                    sheet.clearCellValue(clearArray[1]);
                } else {

                }
            } else {
                    System.out.println(sheet.printCellValue(input));
                }


        return finisher;

    }

}
