/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class FormulaCell extends Cell {
    public String formula;

    public FormulaCell(String originalData) {
        super(originalData);
        formula = originalData;
    }

    public String toSpreadSheet(){
        String result;
        if ( formula.contains(" + ") ) {
            result = ( formula.substring(0, formula.indexOf(" + ") ) + formula.substring(formula.indexOf(" + "), formula.indexOf(" ) ") ) );
        } else if ( formula.contains(" - ") ) {
            result = ( formula.substring(0, formula.indexOf(" - ") ) + formula.substring(formula.indexOf(" - "), formula.indexOf( " ) ") ) );
        } else if (formula.contains(" * ") ){
            result = ( formula.substring(0, formula.indexOf(" * ") ) + formula.substring(formula.indexOf(" * "), formula.indexOf( " ) ") ) );
        } else {
            result = ( formula.substring(0, formula.indexOf(" / ") ) + formula.substring(formula.indexOf(" / "), formula.indexOf( " ) ") ) );
        }
        return (trunkate(result));
    }






    }

