/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class FormulaCell extends Cell {
    public String formula;

    public FormulaCell(String originalData) {
        super(originalData);
        formula = originalData;
    }

    //this is very wrong
    public String sum(){
        return("thing");
    }





    public String toSpreadsheet() {
        String[] split = formula.split(" ");
        //split[2] is used b/c it skips over the first parenthesis
        double result = Double.parseDouble(split[1]);
        for (int k = 2; k < split.length - 1; k++) {
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

