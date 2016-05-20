/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class NumberCell extends Cell{
    private double numData;

    public NumberCell(String originalData) {
        super(originalData);
        numData = Double.parseDouble(originalData);
    }

    @Override
    public String toSpreadsheet() {
        return(truncate(numData + ""));
    }

    public double getNumData(){
        return(numData);
    }


    public void sort(){


    }
}
