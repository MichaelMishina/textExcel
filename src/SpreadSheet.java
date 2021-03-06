/**
 * Created by bal_mcmishina on 3/8/2016.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SpreadSheet {

    //Constants
    private static final String HEADER = "            |      A     |      B     |      C     |      D     |      E     |     F      |      G     |";
    private static final String SEPARATOR = "\n------------+------------+------------+------------+------------+------------+------------+------------+\n";
    private static final int ROWCOUNT = 10; //Changing ROWCOUNT could break the code
    private static final int COLCOUNT = 7; //Changing COLCOUNT could also break the code
    private static final List[] LETTER_RANGE = new List[ROWCOUNT];
    public static final int CELL_SIZE = 12;

    int[] numberRange = new int[10];

    //Instance variables
    private Scanner sheetScanner;
    private Cell[][] spreadSheetCells;


    public SpreadSheet() {
        spreadSheetCells = new Cell[ROWCOUNT][COLCOUNT];
        clearSheet();
    }

    /**
     * Method description - clears the entire spreadsheet.
     */
    public void clearSheet() {
        for (int row = 0; row < ROWCOUNT; row++) {
            for (int col = 0; col < COLCOUNT; col++) {
                spreadSheetCells[row][col] = new Cell();
            }
        }
        System.out.println("Confirmed");
    }

    /**
     * Method description - prints the spreadsheet
     *
     * @return - prints out the spreadsheet
     */
    public String printSheet() {
        String out = HEADER + SEPARATOR;

        for (int row = 0; row < ROWCOUNT; row++) {
            //This is to name the specific rows. The IF statement is to make sure to add an additional character to the
            //row label if the row is a number greater than 9 without messing up the spacing of the whole table.
            if (row < (ROWCOUNT - 1)) {
                out += ("     " + (row + 1) + "      |");
            } else {
                out += ("     " + (row + 1) + "     |");

            }

            for (int col = 0; col < COLCOUNT; col++) {
                // Got centering working
                out += spreadSheetCells[row][col].toSpreadsheet();
                out += "|";
            }
            out += (SEPARATOR);
        }

        return out;
    }

    /**
     * Method description - clears a single cell
     * @param input - the cell id to be cleared.
     */
    public void clearCellValue (String input) {
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring(1,2) ) - 1);

        spreadSheetCells[row][col] = new Cell();
        //Any method with "Confirmed" at the end doesn't actually return anything, so the "Confirmed" is to confirm success.
        System.out.println("Confirmed");

    }

    /**
     * Method description - clears a range of cells
     * @param input - the range of cells to be cleared
     */
    public void clearRange (String input) {
        String[] separate = input.split(" ");
        int startCol = getCol(separate[0]);
        int endCol = getCol(separate[2]);
        int startRow = getRow(separate[0]);
        int endRow = getRow(separate[2]);
        for(int row = startRow;row <= endRow;row++){
            for(int col = startCol;col <= endCol;col++){
                spreadSheetCells[row][col] = new Cell();
            }
        }

        System.out.println("Confirmed");

    }

    /**
     * Method description - prints a single cell
     *
     * @param input - the cell to be printed
     * @return - the value of the requested cell
     */
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

    /**
     * method description - sets the value of a cell
     * @param input - the cel and the value of the cell
     * @return - the cell value
     */
    public String setCellValue(String input) {
        int col = (int) input.charAt(0) - (int) 'A';
        int row = (Integer.parseInt(input.substring( 1,2 ) ) - 1);
        char quote = (char)input.indexOf( ( "=" ) + 2 );

        if( input.contains("\"") ) {

            spreadSheetCells[row][col] = new TextCell(input.substring( input.indexOf("= " ) + 1 ).trim() );

            System.out.println("Confirmed");

        } else if(input.contains("( ") && input.contains( " )" ) ){
            spreadSheetCells[row][col] = new FormulaCell(input.substring( input.indexOf("= " ) + 1 ).trim(),this );
            System.out.println("Confirmed");
        } else {
            spreadSheetCells[row][col] = new NumberCell(input.substring(input.indexOf("= ") + 1).trim());
            System.out.println("Confirmed");
        }
        return (input);
    }

    /**
     * method description - gets the value of a cell in the sheet
     * @param col - the column
     * @param row - the row
     * @return - a cell within the spreadsheet
     */
    public Cell getCell(int col, int row){
        return(spreadSheetCells[row][col]);
    }

    /**
     * method description - gets the row value from the input
     * @param cellCall - the cell position ex. A1
     * @return - the row of the cell
     */
    public int getRow(String cellCall){
        return( (int) cellCall.charAt(1) - (int) '1');
    }

    /**
     * method description - gets the column value from the input
     * @param callCell - the cell position ex. A1
     * @return - the column of the cell
     */
    public int getCol(String callCell){
        return( (int) callCell.charAt(0) - (int) 'A');
    }

    /**
     * method description - sorts a range of cells
     * @param input - the input string
     * @param ascent - the direction in which the string is being sorted
     */
    public void sort(String input, boolean ascent) {
        String[] sortArray = input.split(" ");
        int startCol = getCol(sortArray[1]);
        int startRow = getRow(sortArray[1]);
        int endCol = getCol(sortArray[3]);
        int endRow = getRow(sortArray[3]);

        ArrayList<NumberCell> tempArray = new ArrayList<>();
        ArrayList<Cell> tempArray2 = new ArrayList<>();

        // separates the number cells from the formula and text cells
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                if (getCell(col, row) instanceof NumberCell) {
                    tempArray.add((NumberCell) (getCell(col, row)));
                } else {
                    tempArray2.add(getCell(col, row));
                }
            }
        }

        //sorting the array using selection sort
        for (int i = 0; i < tempArray.size() - 1; i++) {
            int minPos = i;

            for (int x = i + 1; x < tempArray.size(); x++) {
                if (tempArray.get(x).getNumData() < tempArray.get(minPos).getNumData()) {
                    minPos = x;
                }
            }

            NumberCell tempNumCell = tempArray.get(minPos);

            tempArray.set(minPos, tempArray.get(i));
            tempArray.set(i, tempNumCell);
        }

        //initial values
        int index = 0;
        int increment = 1;

        //initial values if descending
        if (!ascent){
            index = (tempArray.size() + tempArray2.size() - 1);
            increment = -1;
        }

        //assembles the final array list
        for (int i = 0; i < tempArray.size(); i++){
            if (increment < 0){
                tempArray2.add(tempArray.get(i));
            }else{
                tempArray2.add(0 , tempArray.get(tempArray.size() - 1 - i));
            }
        }

        //putting sorted values back into the sheet
        for (int col = startCol; col <= endCol; col++) {
            for (int row = startRow; row <= endRow; row++) {
                spreadSheetCells[row][col] = tempArray2.get(index);
                index += increment;
            }
        }
        System.out.println("Confirmed");
    }
}
