/**
 * Created by bal_mcmishina on 3/8/2016.
 */
import java.util.List;
import java.util.Scanner;
public class SpreadSheet {

    //Constants
    private static final String HEADER = "            |      A     |      B     |      C     |      D     |      E     |     F      |      G     |";
    private static final String SEPARATOR = "\n------------+------------+------------+------------+------------+------------+------------+------------+\n";
    private static final int ROWCOUNT = 10; //Changing ROWCOUNT could break the code
    private static final int COLCOUNT = 7; //Changing COLCOUNT could also break the code
    private static final List[] LETTER_RANGE = new List[ROWCOUNT];
    private static final int CELL_SIZE = 12;
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
            //This is to name the specific rows. The IF statement is to make sure to add an additional character to the
            //row label if the row is a number greater than 9 without messing up the spacing of the whole table.
            if (row < (ROWCOUNT -1)) {
                out += ("     " + (row + 1) + "      |");
            } else {
                out += ("     " + (row + 1) + "     |");

            }

            for (int col = 0; col < COLCOUNT; col++) {
                // Got centering working
                int temp;
                if (spreadSheetCells[row][col].toSpreadsheet().length() < CELL_SIZE) {
                    temp = (CELL_SIZE - spreadSheetCells[row][col].toSpreadsheet().length());

                    if ((temp) % 2 == 0) {
                        for (int i = 0; i < (temp / 2); i++){
                            out += " ";
                        }

                        out += spreadSheetCells[row][col].toSpreadsheet();

                        for (int i = 0; i < (temp / 2); i++){
                        out += " ";
                        }
                    } else {
                        for (int i = 0; i < ((temp / 2) + 1); i++){
                            out += " ";
                        }

                        out += spreadSheetCells[row][col].toSpreadsheet();

                        for (int i = 0; i < (temp / 2); i++){
                            out += " ";
                        }
                    }

                    out += "|";
                } else {
                    // TODO: 5/3/2016 put truncating here
                    out += spreadSheetCells[row][col].toSpreadsheet();
                    out += "|";
                }
            }
            out += (SEPARATOR);
        }

        return out;
    }

    public void clearCellValue(String input) {
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring(1,2) ) - 1);

        spreadSheetCells[row][col] = new Cell();
        //Any method with "Confirmed" at the end doesn't actually return anything, so the "Confirmed" is to confirm success.
        System.out.println("Confirmed");

    }


    public String printCellValue(String input) {
        String cellValue = "Invalid input";
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring(1,2) ) - 1);

        if ( ( (col >= 0) && (col < COLCOUNT) ) &&
                ( (row >= 0) && (row < ROWCOUNT) ) ) {
            cellValue = (input + " = " + spreadSheetCells[row][col]);
        }

        return cellValue;
    }

    public String setCellValue(String input){
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring(1,2) ) - 1);
        char quote = (char)input.indexOf(("=") + 2);

        if( (char) input.indexOf(("=") + 2) == quote) {
            spreadSheetCells[row][col] = new TextCell(input.substring(input.indexOf("=") + 1).trim());
            System.out.println("Confirmed");
        } else if(input.contains("+")||input.contains("-")||input.contains("*")||input.contains("/")){
            //Set up after the FormulaCell class is complete.
            //System.out.println("Confirmed");
        } else {
            spreadSheetCells[row][col] = new NumberCell(input.substring(input.indexOf("=") + 1).trim());
            System.out.println("Confirmed");
        }
        return(input);
    }

    public Cell getCell(char col, int row){
        return(spreadSheetCells[row][col]);
    }















}
