import java.util.ArrayList;

/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class NumberCell extends Cell{
    private double numData;

    /**
     * Method description - sets the cell to a double
     *
     * @param originalData - the double that the cell is set to.
     */
    public NumberCell(String originalData) {
        super(originalData);
        numData = Double.parseDouble(originalData);
    }

    /**
     * Method description - prints cell to spreadsheet
     *
     * @return - returns truncated double
     */
    @Override
    public String toSpreadsheet() {
        return(truncate(numData + ""));
    }

    /**
     * Method description - returns the double in the number cell
     *
     * @return - returns the double within the cell.
     */
    @Override
    public double getNumData(){
        return(numData);
    }





}


