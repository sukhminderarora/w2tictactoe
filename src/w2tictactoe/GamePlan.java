package w2tictactoe;

import java.util.Scanner;

public class GamePlan {
	
	private Board board;
    private GameState currentState;
    private CurrentPlayer currentPlayer;
    
    private static Scanner in = new Scanner(System.in);
    
    public GamePlan(){
        board = new Board();
        initGame();
        
        do {
            playerMove(currentPlayer);
            board.paint();
            updateGame(currentPlayer);
            
            if(currentState == GameState.CROSS_WON){
                System.out.println("Player 'X' won this Game!!");
            } else if (currentState == GameState.ZERO_WON){
                System.out.println("Player '0' won this Game!!");
            } else if(currentState == GameState.DRAW){
                System.out.println("It's draw! Bye!");
            }
            
            currentPlayer = (currentPlayer == CurrentPlayer.CROSS)? CurrentPlayer.ZERO : CurrentPlayer.CROSS;
        }while(currentState == GameState.PLAYING);
    }
    
    public void initGame(){
        board.init();
        currentPlayer = CurrentPlayer.CROSS;
        currentState = GameState.PLAYING;
    }
    
    public void playerMove(CurrentPlayer currentPlayer){
        boolean validInput = false;
        do {
            if(currentPlayer == CurrentPlayer.CROSS){
                System.out.print("Player 'X', enter your move(row[1-3] col[1-3]): ");
            } else {
                System.out.print("Player '0', enter your move(row[1-3] col[1-3]): ");
            }
            int row = in.nextInt()-1;
            int col = in.nextInt()-1;
            
            if(row>=0 && row<Board.ROWS && col>=0 && col<Board.COLS && 
                    board.cells[row][col].player == CurrentPlayer.EMPTY){
                board.cells[row][col].player = currentPlayer;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true;
            } else {
                System.out.println("Provided input move at (" +(row+1)+","+(col+1)+") is not "
                        + "valid. Please try again");
            }
        } while(!validInput);
    }
    
    public void updateGame(CurrentPlayer currentPlayer){
        if(board.hasWon(currentPlayer)){
            currentState = (currentPlayer == CurrentPlayer.CROSS)? GameState.CROSS_WON:GameState.ZERO_WON;
        } else if(board.isDraw()){
            currentState = GameState.DRAW;
        }
    }

}
