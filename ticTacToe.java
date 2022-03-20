import java.util.*;
import java.math.*;

public class ticTacToe{

    //CONSTRUCTOR
    public ticTacToe(String gamemode){
        terminalPlay();
        return;
    }

    public static void main(String[] args){
        String gamemode = "";
        if (args[0].equals("terminal")){
            gamemode = "terminal";
            ticTacToe begin = new ticTacToe(gamemode);
        }
        if (args[0].equals("gui")){
            //gamemode = "gui";
            System.out.println("The gui has not been implemented yet, taking you to terminal play...");
            ticTacToe begin = new ticTacToe("terminal");
            
        }
    }

    public String[][] initialBoard(){
        String[][] board = new String[3][3];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = "_";
            }
        }
        return board;
    }

    //if the given boardstate matches any of the following board states, then the board is in a winning state
    public boolean winCon(String[][] boardState){
        //first three are across wins
        if (boardState[0][0].equals("O") && boardState[1][0].equals("O") && boardState[2][0].equals("O")){
            return true;
        }
        if (boardState[0][1].equals("O") && boardState[1][1].equals("O") && boardState[2][1].equals("O")){
            return true;
        }
        if (boardState[0][2].equals("O") && boardState[1][2].equals("O") && boardState[2][2].equals("O")){
            return true;
        }
        //second three are down wins
        if (boardState[0][0].equals("O") && boardState[0][1].equals("O") && boardState[0][2].equals("O")){
            return true;
        }
        if (boardState[1][0].equals("O") && boardState[1][1].equals("O") && boardState[1][2].equals("O")){
            return true;
        }
        if (boardState[2][0].equals("O") && boardState[2][1].equals("O") && boardState[2][2].equals("O")){
            return true;
        }
        //the next two are diagonal wins
        if (boardState[0][0].equals("O") && boardState[1][1].equals("O") && boardState[2][2].equals("O")){
            return true;
        }
        if (boardState[2][0].equals("O") && boardState[1][1].equals("O") && boardState[0][2].equals("O")){
            return true;
        }
        //same thing with O's
        //first three are across wins
        if (boardState[0][0].equals("X") && boardState[1][0].equals("X") && boardState[2][0].equals("X")){
            return true;
        }
        if (boardState[0][1].equals("X") && boardState[1][1].equals("X") && boardState[2][1].equals("X")){
            return true;
        }
        if (boardState[0][2].equals("X") && boardState[1][2].equals("X") && boardState[2][2].equals("X")){
            return true;
        }
        //second three are down wins
        if (boardState[0][0].equals("X") && boardState[0][1].equals("X") && boardState[0][2].equals("X")){
            return true;
        }
        if (boardState[1][0].equals("X") && boardState[1][1].equals("X") && boardState[1][2].equals("X")){
            return true;
        }
        if (boardState[2][0].equals("X") && boardState[2][1].equals("X") && boardState[2][2].equals("X")){
            return true;
        }
        //the next two are diagonal wins
        if (boardState[0][0].equals("X") && boardState[1][1].equals("X") && boardState[2][2].equals("X")){
            return true;
        }
        if (boardState[2][0].equals("X") && boardState[1][1].equals("X") && boardState[0][2].equals("X")){
            return true;
        }
        return false;
    }

    public String[][] changeBoard(String[][] board, boolean botTurn, String playerPiece, String botPiece){
        Scanner input = new Scanner(System.in);
        if (botTurn == true){
            boolean again = true;
            boolean more = true;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (board[i][j] == null){
                        board[i][j] = botPiece;
                    }
                    
                }
            }
        }

        if (botTurn == false){
            System.out.print("Column:\n> ");
            int column = input.nextInt();
            System.out.print("Row:\n> ");
            int row = input.nextInt();
            board[column][row] = playerPiece;
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < 3; j++){ 
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        return board;
    }
    
    public void terminalPlay(){
        Scanner input = new Scanner(System.in);
        String playerChar = "";
        String botChar = "";
        System.out.println("\nYou have entered terminal play mode. When prompted, enter your input then press return.");

        String[][] board = initialBoard();

        System.out.print("Choose X's or O's (type X or O): \n> ");
        String letterChoice = input.next();
        //add in a while loop later to avoid a misatke input
        if (letterChoice.equals("X") || letterChoice.equals("x")){
            playerChar = "X";
            botChar = "O";
            System.out.println("You have chosen X's. You go first.");
            System.out.println("In order to select a spot on the board, you must type the column number first, then the row number.");
            System.out.println("You may now make the first move");

            board = changeBoard(board, false, playerChar, botChar);

        }
        else if (letterChoice.equals("O") || letterChoice.equals("o")){
            playerChar = "O";
            botChar = "X";
            System.out.println("You have chosen O's. You go second.");
            System.out.println("In order to select a spot on the board, you must type the column number first, then the row number.");
            System.out.println("The bot will now make the first move:");
            //rand1 and 2 need to randomly choose a number between 1 and 4
            //int rand1 = 0;//(Math.random()*40);
            //int rand2 = 0;//(Math.random()*40);
            //the bot selects one of the corners to make it's starting move
            //for testing purposes and cuz I'm on the plane rn and forget how random numbers work, I'll manually set it to one of the corners
            //board[rand1][rand2] = "X";

            board = changeBoard(board, true, playerChar, botChar);
        }
        boolean botTurn = true;
        boolean again = true;
        while (again == true){
            int counter = 2;
            if (counter % 2 == 0){
                botTurn = true;
            }
            else {
                botTurn = false;
            }
            counter++;
            System.out.println("This is a big ol test string");
            board = changeBoard(board, botTurn, playerChar, botChar);
            if (winCon(board) == true){
                again = false;
                System.out.println("The game is over now lol");
            }
        }
        //return null;
    }
}