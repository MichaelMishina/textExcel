/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class FormulaCell extends Cell {
    public String formula;

    public FormulaCell(String originalData) {
        super(originalData);
        formula = originalData;
    }

    public String toSpreadsheet() {
        String result;
        String[] split = formula.split(" ");
        for (int k = 2; k < split.length; k += 2) {
            if (split[k - 1].contains(" + ")) {
                split[0] = (Double.parseDouble(split[0]) + Double.parseDouble(split[k]) + "");
            } else if (formula.contains(" - ")) {
                split[0] = (Double.parseDouble(split[0]) - Double.parseDouble(split[k]) + "");
            } else if (formula.contains(" * ")) {
                split[0] = (Double.parseDouble(split[0]) * Double.parseDouble(split[k]) + "");
            } else {
                split[0] = (Double.parseDouble(split[0]) / Double.parseDouble(split[k]) + "");
            }

        }
        return (trunkate(split[0]));
    }






    }

