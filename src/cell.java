/**
 * Created by bal_mcmishina on 3/8/2016.
 */
public class cell {
    private String emptyCell = "            ";
    public cell(char row, int col){}

//set cell as 12 spaces
    public void clearCell (char row, int col){
         cell[row][col] = emptyCell;
    }
}
