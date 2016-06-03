/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class Cell {

    private static final String EMPTY_CELL_VALUE = "<empty>";
    private static final String EMPTY_CELL = "            ";
    protected String originalData;

    public Cell(String originalData){
        this.originalData = originalData;
    }

    public Cell(){
        originalData = EMPTY_CELL_VALUE;
    }

    /**
     * Method description - prints the cell value to the spreadsheet.
     * @return - the twelve empty spaces.
     */
    public String toSpreadsheet(){
        return EMPTY_CELL;
    }

    /**
     * Method description - returns the data in the cell.
     * @return - returns the data in the cell.
     */
    public String toString() { return originalData; }

    /**
     * Method description - gets the value in the cell.
     * @return - returns the cell value.
     */
    public String getCellValue(){
        return originalData;
    }

    /**
     * Method description - shortens the data if it is greater than 12 characters.
     *
     * @param data - the data to be shortened.
     * @return - returns the truncated data in the cell.
     */
    public String truncate(String data) {

        String output = "";

        if (data.length() > SpreadSheet.CELL_SIZE) {

            output = (data.substring(0 , SpreadSheet.CELL_SIZE - 1) + ">");

        } else if (data.length() <= SpreadSheet.CELL_SIZE) {

            int numSpaces = (SpreadSheet.CELL_SIZE - data.length());

            if ((numSpaces) % 2 != 0) {

                for (int i = 0; i < ((numSpaces / 2) + 1); i++) {
                    output += " ";
                }

            } else {
                for (int i = 0; i < (numSpaces / 2); i++) {
                    output += " ";
                }

            }
            output += data;

            for (int i = 0; i < (numSpaces / 2); i++) {
                output += " ";
            }
        }

    return(output);
    }

    /**
     * Method description - returns the number in the empty cell.
     * @return - returns 0, as the cell is empty.
     */
    public double getNumData(){
        return(0);
    }



}
