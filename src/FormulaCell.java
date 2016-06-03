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

    /**
     * Method description - converts the letter in a cell id to a number.
     *
     * @param character - the letter in the cell id.
     * @return - returns the letter in the cell id as a number.
     */
    public int convertToNum(char character){
        int finale;
        if ( (((int)character - (int)'1') >= 0) && ((int)character - (int)'1' <=  9)){
            finale = (int)character - (int)'1';
        } else {
            finale = (int)character - (int)'A';
        }
        return(finale);
    }

    /**
     * Method description - determines if the sum or average command is called, and returns the result.
     *
     * @param startCol - the column in the first cell id
     * @param endCol - the column in the second cell id
     * @param startRow - the row in the first cell id
     * @param endRow - the row in the second cell id
     * @param avg - this is the boolean to check if the average command is called.
     * @return - returns either the summed range or the averaged range.
     */
    public double SumOrAvg(int startCol, int endCol, int startRow, int endRow, boolean avg ){
        double endInt = 0;
        NumberCell tempCell;
        int avgMultiplier = 0;
        for (int k = startCol; k <= endCol; k++) {
            for (int m = startRow; m <= endRow; m++) {
                    if(usedSheet.getCell(k,m) instanceof NumberCell){
                     tempCell = (NumberCell)( usedSheet.getCell(k,m));
                    endInt += tempCell.getNumData();
                } else if(usedSheet.getCell(k,m) instanceof FormulaCell){
                    FormulaCell tempFormCell = (FormulaCell)( usedSheet.getCell(k,m));
                    endInt += tempFormCell.getNumData();
                } else {
                    m++;
                }
                avgMultiplier++;
            }
        }
        if(avg == true){
            return(endInt / avgMultiplier);
        } else {
            return (endInt);
        }
    }

    /**
     * Method description - checks if the formula contains a cell reference.
     *
     * @param position - part of the formula that may or may not be a cell reference.
     * @return - returns the number at the cell reference, or the number if it isn't a cell reference.
     *
     */
    public double referenceCheck(String position){
        Cell tempCell;
        double end;
        if ( (int)position.charAt(0) - (int)'A' <= 9 && (int)position.charAt(0) - (int)'A' >= 0){
            tempCell = usedSheet.getCell( ((int) position.charAt(0) - (int)'A'),(int)position.charAt(1) - ((int)'1'));
                end = tempCell.getNumData();
        } else {
            end = Double.parseDouble(position);
        }
        return(end);
    }

    /**
     * Method description - runs any operators that the formula may contain.
     *
     * @return - returns the number that the formula results in.
     */
    public double getNumData() {
        String[] split = formula.split(" ");
        double finale = 0;

        if (split[1].contains("sum")) {

            int col1 = convertToNum(split[2].charAt(0));
            int col2 = convertToNum(split[3].charAt(0));
            int row1 = convertToNum(split[2].charAt(1));
            int row2 = convertToNum(split[3].charAt(1));

            finale = (SumOrAvg(col1, col2, row1, row2, false));
        } else if(split[1].contains("avg")){

            int col1 = convertToNum(split[2].charAt(0));
            int col2 = convertToNum(split[3].charAt(0));
            int row1 = convertToNum(split[2].charAt(1));
            int row2 = convertToNum(split[3].charAt(1));

            finale = (SumOrAvg(col1, col2, row1, row2, true));
        } else {
            //split[1] is used b/c it skips over the first parenthesis


            //k = 2 b/c it skips over the first value.
                if( (int)split[1].charAt(0) - (int)'A' <= 9 && (int)split[1].charAt(0) - (int)'A' >= 0 ){
                    Cell tempCell = usedSheet.getCell( ((int) split[1].charAt(0) - (int)'A'),((int)split[1].charAt(1) - (int)'1'));
                    split[1] = tempCell.getCellValue();
                    finale = tempCell.getNumData();
                } else {
                    finale = Double.parseDouble(split[1]);
                }
                for (int d = 2; d < split.length - 1; d += 2){
                if (split[d].contains("+")) {
                    finale += referenceCheck(split[d + 1]);
                } else if (split[d].contains("-")) {
                    finale -= referenceCheck(split[d + 1]);
                } else if (split[d].contains("*")) {
                    finale *= referenceCheck(split[d + 1]);
                } else if (split[d].contains("/")){
                    finale /= referenceCheck(split[d + 1]);
                }

            }

        }
        return(finale);
    }


    /**
     * Method description - prints things to the spreadsheet
     *
     * @return - returns the truncated num data.
     */
    public String toSpreadsheet() {
        double result = getNumData();
        return (truncate(result + ""));
    }






    }

