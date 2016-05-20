/**
 * Created by bal_mcmishina on 3/8/2016.
 */

public class TextCell extends Cell {


    public TextCell(String originalData){
         super(originalData);}

        public String toSpreadsheet() {

            return(truncate(originalData.substring(1, originalData.length() - 1 ) ) );
        }
}