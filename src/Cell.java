/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class Cell {

    private static final String EMPTY_CELL_VALUE = "<empty>";
    private static final String EMPTY_CELL = "            ";
    protected String originalData;
    protected String originalCell;

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

    public String trunkate(String originalData) {
        if(this.originalData.length() > 12){
            return(this.originalData.substring(this.originalData.length() - 1) + ">");
        } else {
            return(this.originalData);
        }
    }


}
