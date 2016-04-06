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

    public Cell() {
        originalData = EMPTY_CELL_VALUE;
    }

    public String toSpreadsheet(){
        return EMPTY_CELL;
    }

    public String getCellValue(){
        return originalData;
    }


}
