/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class FormulaCell extends Cell {
    private String formula;
    private SpreadSheet usedSheet;

    public FormulaCell(String originalData, SpreadSheet formulaSheet) {
        super(originalData);
        formula = originalData;
        usedSheet = formulaSheet;
    }


    public int convertToNum(char character){
        int finale;
        if ( (((int)character - (int)'1') >= 0) && ((int)character - (int)'1' <=  9)){
            finale = (int)character - (int)'1';
        } else {
            finale = (int)character - (int)'A';
        }
        return(finale);
    }

    public double Sum(int startCol, int endCol, int startRow, int endRow ){
        double endInt = 0;
        NumberCell tempCell;
        for (int k = startCol; k <= endCol; k++) {
            for (int m = startRow; m <= endRow; m++) {
                if(usedSheet.getCell(k,m) instanceof NumberCell){
                     tempCell = (NumberCell)( usedSheet.getCell(k,m));
                    endInt += tempCell.getNumData();
                } else if(usedSheet.getCell(k,m) instanceof FormulaCell){
                    FormulaCell tempFormCell = (FormulaCell)( usedSheet.getCell(k,m));
                    endInt += tempFormCell.solve();
                } else {
                    m++;
                }
            }
        }
        return(endInt);
    }


    public double solve() {
        String[] split = formula.split(" ");
        double finale = 0;

        if (split[1].contains("sum")){

            int col1 = convertToNum(split[2].charAt(0));
            int col2 = convertToNum(split[4].charAt(0));
            int row1 = convertToNum(split[2].charAt(1));
            int row2 = convertToNum(split[4].charAt(1));

            finale = (Sum( col1, col2, row1, row2 ) );
        } else if (split[1].contains("avg")) {

            int col1 = convertToNum(split[2].charAt(0));
            int col2 = convertToNum(split[4].charAt(0));
            int row1 = convertToNum(split[2].charAt(1));
            int row2 = convertToNum(split[4].charAt(1));

            if (col2 - col1 == 0){
                finale = ( (Sum( col1, col2, row1, row2) ) / row2 - row1 );
            } else if (col2 - col1 != 0){
                finale = ( (Sum( col1, col2, row1, row2) ) / ( (7 * (col2 - col1) ) + ( (10 * (col2 - col1) ) + (row2 - row1) ) ) );
            }

        //split[2] is used b/c it skips over the first parenthesis

    } else {
            double result = Double.parseDouble(split[2]);
            for (int k = 0; k < split.length - 1; k++) {
                if (split[k].contains("+")) {
                    result += (Double.parseDouble(split[k + 1]));
                } else if (split[k].contains("-")) {
                    result -= (Double.parseDouble(split[k + 1]));
                } else if (split[k].contains("*")) {
                    result *= (Double.parseDouble(split[k + 1]));
                } else if (split[k].contains("/")){
                    result /= (Double.parseDouble(split[k + 1]));
                }

            }
            finale = result;
        }

        return(finale);
    }


    public String toSpreadsheet() {
        double result = solve();
        return (truncate(result + ""));
    }






    }

