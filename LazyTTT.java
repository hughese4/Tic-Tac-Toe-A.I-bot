import java.util.*;

public class LazyTTT {

    private String[][] boardState;

    public static void main(String[] args){
        LazyTTT terminalGame = new LazyTTT();
    }

    public LazyTTT(){
        initialBoardTerminal();
        terminalPlay();
    }

    public String[][] initialBoardTerminal(){
        String[][] board = new String[3][3];
        //Arrays.fill(board, "_");
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
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        //this is where the bot move is calculated, will call BotMoves in the future for minimax optimal move.
        if (botTurn == true){
                        
            System.out.println("\nThe bot will now go:\n");
            //bot makes a random move on the board
            int botRow = rand.nextInt(3);
            int botColumn = rand.nextInt(3);
            board[botRow][botColumn] = botPiece;
            
        }
        if (botTurn == false){
            System.out.println("\nYour turn:");
            System.out.print("Row (1-3):\n> ");
            int column = input.nextInt();
            System.out.print("Column (1-3):\n> ");
            int row = input.nextInt();
            board[column-1][row-1] = playerPiece;
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ 
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return board;
    }
    
    //method for playing the game in the terminal
    public void terminalPlay(){
        Scanner input = new Scanner(System.in);
        String playerChar = "";
        String botChar = "";
        boolean botTurn = true;
        boolean again = true;
        int counter = 2;
        System.out.println("\nYou have entered terminal play mode. When prompted, enter your input then press return.");
        String[][] board = initialBoardTerminal();
        System.out.print("Choose X's or O's (type X or O): \n> ");
        String letterChoice = input.next();
        //add in a while loop later to avoid a misatke input
        if (letterChoice.equals("X") || letterChoice.equals("x")){
            playerChar = "X";
            botChar = "O";
            System.out.println("You have chosen X's. You go first.");
            System.out.println("In order to select a spot on the board, you must type the column number first, then the row number.");
            System.out.println("You may now make the first move.");
        }
        else if (letterChoice.equals("O") || letterChoice.equals("o")){
            playerChar = "O";
            botChar = "X";
            System.out.println("You have chosen O's. You go second.");
            System.out.println("In order to select a spot on the board, you must type the column number first, then the row number.");
            System.out.println("The bot will make the first move.");
            
            //sets counter to 3 so that it becomes the bot's turn first in the following loop
            counter = 3;
        }
        
        //while loop runs the actual playing of the game (maybe make a different function at some point)
        while(again == true){
            //if we get to a cat, game exits and prints a statement about tying
            //maybe change this so that its more concrete later
            if (((counter >= 12))){
                System.out.println("\nThis game has resulted in a tie.");
                break;
            }
            if (counter % 2 == 0){
                botTurn = false;
            }
            else {
                botTurn = true;
            }
            
            boardState = changeBoard(board, botTurn, playerChar, botChar);
            boolean done = winCon(board);
            counter++;
            if (done == true){
                again = false;
                if (botTurn == true){
                    System.out.println("The bot has won the game, better luck next time.");
                }
                else{
                    System.out.println("You have won the game!");
                }
            }
        }
    
}
}
