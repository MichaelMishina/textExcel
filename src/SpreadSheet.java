/**
 * Created by bal_mcmishina on 3/8/2016.
 */
import java.util.List;
import java.util.Scanner;
public class SpreadSheet {

    //Constants
    private static final String HEADER = "            |      A     |      B     |      C     |      D     |      E     |     F      |      G     |";
    private static final String SEPARATOR = "\n------------+------------+------------+------------+------------+------------+------------+------------+\n";
    private static final int ROWCOUNT = 10;
    private static final int COLCOUNT = 7;
    private static final List[] LETTER_RANGE = new List[ROWCOUNT];
    int[] numberRange = new int[10];

    //Instance variables
    private Scanner sheetScanner;
    private Cell[][] spreadSheetCells;
    public boolean finisher = false;

    public SpreadSheet(){
        spreadSheetCells = new Cell[ROWCOUNT][COLCOUNT];
        clearSheet();
    }

    public void clearSheet()
    {
        for (int row = 0; row < ROWCOUNT; row++) {
            for (int col = 0; col < COLCOUNT; col++) {
                spreadSheetCells[row][col] = new Cell();
            }
        }
    }

    public String printSheet() {
        String out = HEADER + SEPARATOR;

        for (int row = 0; row < ROWCOUNT; row++) {
            if (row < (ROWCOUNT -1)) {
                out += ("     " + (row + 1) + "      |");
            } else {
                out += ("     " + (row + 1) + "     |");

            }


            for (int col = 0; col < COLCOUNT; col++) {

                out += spreadSheetCells[row][col].toSpreadsheet();
                out += "|";
            }
            out += (SEPARATOR);
        }

        return out;
    }

    public void commandInput(Scanner commandScanner){
        System.out.print("Welcome. ");
        while(!finisher) {
            System.out.println("Enter a command.");
            String input1 = commandScanner.nextLine().toUpperCase();
            int char1 = (int)input1.charAt(0) - (int)'A';
            if ((input1.toLowerCase().contains("print"))) {
               System.out.println(printSheet() );

            } else if ((input1.toLowerCase().contains("exit"))) {
                System.out.println("Process: end");
                finisher = true;
            }else if((char1 >= 0 && char1 < COLCOUNT ) && ( (Integer.parseInt(input1.substring(1) ) - 1) >= 1 &&
                    (Integer.parseInt(input1.substring(1) ) ) < ROWCOUNT) ) {
                System.out.println(spreadSheetCells[char1][Integer.parseInt(input1.substring(1))]);
            }

        }

    }

    public Cell getCell(char col, int row){
        return(spreadSheetCells[row][col]);
    }















}
