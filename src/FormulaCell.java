/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class FormulaCell extends Cell {
    private String formula;
    private SpreadSheet usedSheet;

    public FormulaCell(String originalData) {
        super(originalData);
        formula = originalData;
    }

    public double Sum(int startCol, int endCol, int startRow, int endRow ){
        double endInt = 0;
        for (int k = startCol; k < endCol; k++) {
            for (int m = startRow; m < endRow; m++) {
                if(usedSheet.getCell(k,m) instanceof NumberCell){
                    NumberCell tempCell = (NumberCell)( usedSheet.getCell(k,m));
                    endInt += tempCell.getNumData();
                } else if(usedSheet.getCell(k,m) instanceof FormulaCell){
                    FormulaCell tempCell = (FormulaCell)( usedSheet.getCell(k,m));
                    endInt += tempCell.solve();
                } else {
                    m++;
                }
            }
        }
        return(endInt);
    }


    public double solve() {
        String[] split = formula.split(" ");
        if (split[0].contains("sum")){
            return (Sum( ((int) split[2].charAt(0) - (int)'A') , ((int) split[3].charAt(0) - (int)'A') , split[2].indexOf(1), split[3].indexOf(1)));
        } else if (split[0].contains("avg"))
            return ((Sum( ((int) split[2].charAt(0) - (int)'A') , ((int) split[3].charAt(0) - (int)'A') , split[2].indexOf(1), split[3].indexOf(1))) / );
        //split[2] is used b/c it skips over the first parenthesis
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
        return(result);
    }


    public String toSpreadsheet() {
        double result = solve();
        return (truncate(result + ""));
    }






    }

