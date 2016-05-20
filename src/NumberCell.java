/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class NumberCell extends Cell{
    private double numData;
    private SpreadSheet usedSheet;
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


    public void sort(int startCol, int endCol, int startRow, int endRow ) {
        for (int k = startCol; k <= endCol; k++) {
            for (int m = startRow; m <= endRow; m++) {
                if((usedSheet.getCell(k,m) instanceof NumberCell) && (usedSheet.getCell(k,m) instanceof NumberCell)){

                } else if(usedSheet.getCell(k,m)){

                } else {
                    m++;
                }


            }
        }
    }
}
