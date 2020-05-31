package w2tictactoe;

public class Board {
	
	  public static final int ROWS =3;
	    public static final int COLS =3; 
	    
	    Cell[][] cells;
	    int currentRow, currentCol;
	    
	    public Board(){
	        cells = new Cell[ROWS][COLS];
	        for(int row=0; row<ROWS; ++row){
	            for(int col=0; col<COLS; ++col){
	                cells[row][col] = new Cell(row,col);
	            }
	        }
	    }
	    
	    public void init(){
	        for(int row=0; row<ROWS; ++row){
	            for(int col=0; col<COLS; ++col){
	                cells[row][col].clear();
	            }
	        }
	    }
	    
	    public boolean isDraw(){
	        for(int row=0; row<ROWS; ++row){
	            for(int col=0; col<COLS; ++col){
	                if(cells[row][col].player == CurrentPlayer.EMPTY) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    
	    public boolean hasWon(CurrentPlayer currentPlayer){
	        return(cells[currentRow][0].player == currentPlayer
	                    && cells[currentRow][1].player == currentPlayer
	                    && cells[currentRow][2].player == currentPlayer
	                || cells[0][currentCol].player == currentPlayer
	                    && cells[1][currentCol].player == currentPlayer
	                    && cells[2][currentCol].player == currentPlayer
	                || currentRow == currentCol
	                    && cells[0][0].player == currentPlayer
	                    && cells[1][1].player == currentPlayer
	                    && cells[2][2].player == currentPlayer
	                || currentRow + currentCol == 2
	                    && cells[0][2].player == currentPlayer
	                    && cells[1][1].player == currentPlayer
	                    && cells[2][0].player == currentPlayer);
	    }
	    
	    public void paint(){
	       for(int row=0; row<ROWS; ++row){
	            for(int col=0; col<COLS; ++col){
	                cells[row][col].paint();
	                if(col < COLS-1) {
	                    System.out.print("|");
	                }
	            }
	            System.out.println();
	            if(row< ROWS-1){
	                System.out.println("------------------");
	            }
	        } 
	    }

}
