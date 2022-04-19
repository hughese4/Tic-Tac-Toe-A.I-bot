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

    // ISMOVESLEFT
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

    // EVALUATE
    // This is the evaluation function for minimax
    public int evaluate(char b[][], char botPiece, char playerPiece){
        
        // Checking rows for X or O victory
        for (int row = 0; row < 3; row++){
            if (b[row][0] == b[row][1] && b[row][1] == b[row][2]){
                if (b[row][0] == playerPiece){
                    return +10;
                }
                else if (b[row][0] == botPiece){
                    return -10;
                }
            }
        }

        // Checking columns for X or O victory
        for (int col = 0; col < 3; col++){
            if (b[0][col] == b[1][col] && b[1][col] == b[2][col]){
                if (b[0][col] == playerPiece){
                    return +10;
                }
                else if (b[0][col] == botPiece){
                    return -10;
                }
            }
        }

        // Checking diagonals for victory
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]){
            if (b[0][0] == playerPiece){
                return +10;
            }
            else if (b[0][0] == botPiece){
                return -10;
            }
        }
        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]){
            if (b[0][2] == playerPiece){
                return +10;
            }
            else if (b[0][2] == botPiece){
                return -10;
            }
        }

        // If none of the wincons return an eval then return 0
        return 0;
    }

    // MINIMAX
    // This is the minimax function. It considers all the possible
    // ways the game can go and returns the value of the board
    public int minimax(char[][] board, int depth, boolean isMax){


        
        return 0;
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
