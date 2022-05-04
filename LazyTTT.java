import java.util.*;

public class LazyTTT {

    private char[][] boardState;

    public static void main(String[] args){
        LazyTTT terminalGame = new LazyTTT();
    }

    public LazyTTT(){
        boardState = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                boardState[i][j] = '_';
            }
        }
        terminalPlay();
    }

    public char[][] initialBoardTerminal(){
        char[][] board = new char[3][3];
        //Arrays.fill(board, "_");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '_';
            }
        }
        return board;
    }

    //if the given boardstate matches any of the following board states, then the board is in a winning state
    public boolean winCon(char[][] boardState){
        //first three are across wins
        if (boardState[0][0] == 'O' && boardState[1][0] == 'O' && boardState[2][0] == 'O'){
            return true;
        }
        if (boardState[0][1] == 'O' && boardState[1][1] == 'O' && boardState[2][1] == 'O'){
            return true;
        }
        if (boardState[0][2] == 'O' && boardState[1][2] == 'O' && boardState[2][2] == 'O'){
            return true;
        }
        //second three are down wins
        if (boardState[0][0] == 'O' && boardState[0][1] == 'O' && boardState[0][2] == 'O'){
            return true;
        }
        if (boardState[1][0] == 'O' && boardState[1][1] == 'O' && boardState[1][2] == 'O'){
            return true;
        }
        if (boardState[2][0] == 'O' && boardState[2][1] == 'O' && boardState[2][2] == 'O'){
            return true;
        }
        //the next two are diagonal wins
        if (boardState[0][0] == 'O' && boardState[1][1] == 'O' && boardState[2][2] == 'O'){
            return true;
        }
        if (boardState[2][0] == 'O' && boardState[1][1] == 'O' && boardState[0][2] == 'O'){
            return true;
        }
        //same thing with O's
        //first three are across wins
        if (boardState[0][0] == 'X' && boardState[1][0] == 'X' && boardState[2][0] == 'X'){
            return true;
        }
        if (boardState[0][1] == 'X' && boardState[1][1] == 'X' && boardState[2][1] == 'X'){
            return true;
        }
        if (boardState[0][2] == 'X' && boardState[1][2] == 'X' && boardState[2][2] == 'X'){
            return true;
        }
        //second three are down wins
        if (boardState[0][0] == 'X' && boardState[0][1] == 'X' && boardState[0][2] == 'X'){
            return true;
        }
        if (boardState[1][0] == 'X' && boardState[1][1] == 'X' && boardState[1][2] == 'X'){
            return true;
        }
        if (boardState[2][0] == 'X' && boardState[2][1] == 'X' && boardState[2][2] == 'X'){
            return true;
        }
        //the next two are diagonal wins
        if (boardState[0][0] == 'X' && boardState[1][1] == 'X' && boardState[2][2] == 'X'){
            return true;
        }
        if (boardState[2][0] == 'X' && boardState[1][1] == 'X' && boardState[0][2] == 'X'){
            return true;
        }
        return false;
    }

    public char[][] changeBoard(char[][] board, boolean botTurn, char playerPiece, char botPiece){
        Scanner input = new Scanner(System.in);
        BotMove botMove = new BotMove();

        //this is where the bot move is calculated, will call BotMoves in the future for minimax optimal move.
        if (botTurn == true){
            
            boardState = botMove.findBestMove(boardState);
            
            
        }
        if (botTurn == false){
            System.out.println("\nYour turn:");
            System.out.print("Row (1-3):\n> ");
            int column = input.nextInt();
            System.out.print("Column (1-3):\n> ");
            int row = input.nextInt();
            boardState[column-1][row-1] = playerPiece;
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ 
                System.out.print(boardState[i][j] + " ");
            }
            System.out.println();
        }
        return board;
    }
    
    //method for playing the game in the terminal
    public void terminalPlay(){
        BotMove botMove = new BotMove();
        Scanner input = new Scanner(System.in);
        char playerChar;
        char botChar;
        boolean botTurn = true;
        boolean again = true;
        int counter = 2;
        System.out.println("\nYou have entered terminal play mode. When prompted, type your input then press enter.");
        char[][] board = initialBoardTerminal();
        //System.out.print("Choose X's or O's (type X or O): \n> ");
        //char letterChoice = input.next();
        //add in a while loop later to avoid a misatke input
        //if (letterChoice == 'X' || letterChoice == 'X'){
        playerChar = 'X';
        botChar = 'O';
        System.out.println("You have chosen X's. You go first.");
        System.out.println("In order to select a spot on the board, you must type the column number first, then the row number.");
        System.out.println("You may now make the first move.");
        
        /*else if (letterChoice == 'O' || letterChoice == 'O'){
            playerChar = 'O';
            botChar = 'X';
            System.out.println("You have chosen O's. You go second.");
            System.out.println("In order to select a spot on the board, you must type the column number first, then the row number.");
            System.out.println("The bot will make the first move.");
            
            //sets counter to 3 so that it becomes the bot's turn first in the following loop
            counter = 3;
        }*/
        
        //while loop runs the actual playing of the game (maybe make a different function at some point)
        while(again == true){
            //if we get to a cat, game exits and prints a statement about tying
            //maybe change this so that its more concrete later
            if (((counter >= 11))){
                System.out.println("\nThis game has resulted in a tie.\n");
                break;
            }
            if (counter % 2 == 0){
                botTurn = false;
            }
            else {
                botTurn = true;
            }
            
            boardState = changeBoard(boardState, botTurn, playerChar, botChar);
            boolean done = winCon(boardState);
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
