import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this class needs to take the mainboard as a parameter, and return a move so that the
//main board gets updated             
public class BotMove{// extends JFrame implements ActionListener{

    static class Move{
        int row, col;
    }

    private char[][] board;

    //CONSTRUCTOR
    public BotMove(){
        board = new char[3][3];
    }

    /*
    //RANDOMMOVE
    //this method returns a random move for the sake of testing
    public char[][] randomMove(char botPiece){
        Random rand = new Random();
        JButton btn = new JButton();
        //until optimal move is implemented, bot makes a random move
        int botRow = rand.nextInt(3);
        int botColumn = rand.nextInt(3);
        btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
        board[botRow][botColumn] = botPiece;

        return board;
    } */

    // This function returns true if ther are moves
    // remaining on the board. It retruns false if
    // there are no moves left to play
    public boolean isMovesLeft(char[][] board){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '_'){
                    return true;
                }
            }
        }
        return false;
    }

    // FINDBESTMOVE
    // This method will return the best possible
    // move for the player
    public Move findBestMove(char[][] board, char botPiece){
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        // Go through all cells, evaluate minimax function
        // for all empty cells. Return the cell with 
        // the optimal value.
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                // Check if cell is empty
                if (board[i][j] == '_'){
                    // Make the move
                    board[i][j] = botPiece;

                    // Compute evaluation function for this move
                    int moveVal = minimax(board, 0, false);

                    // Undo the move
                    board[i][j] = '_';

                    // If the value of the current move is move than
                    // the best value, then update best
                    if (moveVal > bestVal){
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }

                }
            }
        }

        System.out.printf("The value of the best move is : %d/n/n", bestVal);

        return bestMove;
    }
}
