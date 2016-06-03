/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class TextCell extends Cell {

    /**
     * Method description - sets a cell to a string cell
     *
     * @param originalData - takes in a new input to set the cell to.
     */
    public TextCell(String originalData){
         super(originalData);}

    /**
     * Method description - prints the string to the spreadsheet.
     *
      * @return - returns the ( possibly shorter ) string in the cell, while printing it to the spreadsheet.
     */
    public String toSpreadsheet() {

            return(truncate(originalData.substring(1, originalData.length() - 1 ) ) );
        }
}