import java.util.ArrayList;

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

    @Override
    public double getNumData(){
        return(numData);
    }


    public void sort(int startCol, int endCol, int startRow, int endRow ) {
        ArrayList<NumberCell> tempArray = new ArrayList<>();
        ArrayList<Cell> tempArray2 = new ArrayList<>();
        int tempInt = 0;
        for (int k = startCol; k <= endCol; k++) {
            for (int m = startRow; m <= endRow; m++) {
                if (usedSheet.getCell(k,m) instanceof NumberCell){
                tempArray.add((NumberCell)(usedSheet.getCell(k,m)));
                } else {
                tempArray2.add(usedSheet.getCell(k,m));
                }
                tempInt += 1;
            }
            for (int m = 0; m <= tempArray.size()){
                if ((tempArray.get(m).getNumData()) > (tempArray.get((m+1)).getNumData())){
                    double fac = tempArray.get(m).getNumData();
                    tempArray.set(m, ) = tempArray.get(m+1).getNumData();
                }
            }
        }
    }
}

