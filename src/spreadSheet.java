/**
 * Created by bal_mcmishina on 3/8/2016.
 */
import java.util.List;
import java.util.Scanner;
public class SpreadSheet {

    //Constants
    private static final String HEADER = "            |      A      |      B      |      C      |      D      |      E      |     F      |      G      |";
    private static final String SEPARATOR = "------------+-------------+-------------+-------------+-------------+-------------+------------+-------------+";
    private static final int ROW = 10;
    private static final int COL = 7;
    private static final List[] LETTER_RANGE = new List[ROW];
    int[] numberRange = new int[10];

    //Instance variables
    private Scanner sheetScanner;
    private Cell[][] spreadSheetCells;
    public boolean finisher = false;

    public SpreadSheet(){
        spreadSheetCells = new Cell[ROW][COL];
        clearSheet();
    }

    public void clearSheet()
    {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                spreadSheetCells[row][col] = new Cell();
            }
        }
    }

    public void commandInput(Scanner commandScanner){
        System.out.print("Welcome. ");
        while(!finisher) {
            System.out.println("Enter a command.");
            String input1 = commandScanner.nextLine().toUpperCase();
            char char1 = input1.charAt(0);
            if ((input1.toLowerCase().contains("print"))) {
                System.out.println(HEADER);
                System.out.println(SEPARATOR);
                for(int i = 0;i <= ROW;i++) {
                    if (i > 9) {
                        System.out.println("    " + i + "      |             |             |             |             |             |            |             |");
                        System.out.println(SEPARATOR);

                    } else {
                        System.out.println("     " + i + "      |             |             |             |             |             |            |             |");
                        System.out.println(SEPARATOR);

                    }
                }


            } else if ((input1.toLowerCase().contains("exit"))) {
                System.out.println("Process: end");
                finisher = true;
            }else if(((int)char1 - (int)'A' >= 0 && (int)char1 - (int)'A' <= 6) && (Integer.parseInt(input1.substring(1)) >= 1 && (Integer.parseInt(input1.substring(1))) <= 10)) {
                getCell(char1,Integer.parseInt(input1.substring(1)));
            }

        }

    }

    public Cell getCell(char col, int row){
        return(spreadSheetCells[row][col]);
    }















}
