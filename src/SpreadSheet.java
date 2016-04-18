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


    public String printCellValue(String input) {
        String cellValue = "Invalid input";
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring(1) ) - 1);

        if ( ( (col >= 0) && (col < COLCOUNT) ) &&
                ( (row >= 0) && (row < ROWCOUNT) ) ) {
            cellValue = (input + " = " + spreadSheetCells[row][col]);
        }

        return cellValue;
    }

    public String setCellValue(String input){
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring(1) ) - 1);

        spreadSheetCells[row][col] = new TextCell(input.substring(input.indexOf(" = ") ) );
        return(input);
    }

    public Cell getCell(char col, int row){
        return(spreadSheetCells[row][col]);
    }















}
