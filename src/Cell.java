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

    public String toSpreadsheet(){
        return EMPTY_CELL;
    }

    public String toString() { return originalData; }

    public String getCellValue(){
        return originalData;
    }

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

    public double getNumData(){
        return(0);
    }



}
