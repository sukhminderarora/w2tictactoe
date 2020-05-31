package w2tictactoe;

public class Cell {
	
	  CurrentPlayer player;
	    int row, col;
	    
	    public Cell(int row, int col){
	        this.row = row;
	        this.col = col;
	        clear();
	    }
	    
	    public void clear(){
	    	player = CurrentPlayer.EMPTY;
	    }
	    
	    public void paint(){
	        switch(player){
	            case CROSS: System.out.print(" X "); break;
	            case ZERO:System.out.print(" 0 "); break;
	            case EMPTY: System.out.print("   ");break;
	        }
	    }

}
