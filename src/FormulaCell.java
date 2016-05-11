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

    public String sum(int startCol, int endCol, int startRow, int endRow ){
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
        return("incomplete");
    }


    public double solve() {
        String[] split = formula.split(" ");
        //split[2] is used b/c it skips over the first parenthesis
        double result = Double.parseDouble(split[2]);
        for (int k = 3; k < split.length - 1; k++) {
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
        String[] split = formula.split(" ");
        //split[2] is used b/c it skips over the first parenthesis
        double result = Double.parseDouble(split[2]);
        for (int k = 3; k < split.length - 1; k++) {
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
        return (truncate(result + ""));
    }






    }

