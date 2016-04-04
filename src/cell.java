/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class Cell {

    private static final String EMPTY_CELL_VALUE = "<empty>";
    private static final String EMPTY_CELL = "            ";
    private String originalData;

    public Cell() {
        originalData = EMPTY_CELL_VALUE;
    }

    public String initialToSpreadsheet(){
        return EMPTY_CELL;
    }

    public String initialCellValue(){
        return EMPTY_CELL_VALUE;
    }

    
}
