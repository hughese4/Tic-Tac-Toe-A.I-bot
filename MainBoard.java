import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainBoard extends JFrame{
    //this needs to be the board object that is passed to both the player and botMoves obects
    //when the board is passed to those objects, they each will have a method that returns a move,
    //then this method (aka the main board) is updated.
    private String[][] currentBoard;
    private String currentPlayer;
    private Container pane;
    private JButton[][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;
    private int turnCount;
    private final String botPiece = "o";
    private final int boardSize = 3;
    private int m = 0;
    private int n = 0;


    //CONSTRUCTOR
    //- The object's fields are set to the provided values
    public MainBoard(/*JButton[][] currentBoard*/){
        //this.currentBoard = currentBoard;
        
    }

    public void initializeBoard(){
        String[][] newBoard = new String[3][3];
        turnCount = 0;
        pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Tic Tac Toe");
        setSize(750, 750);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        currentPlayer = "X";
        hasWinner = false;
        currentBoard = newBoard;
        setVisible(true);
        board = new JButton[3][3];
        initializeMenuBar();
    }

    public void updateBoard(){
        System.out.println("Inside the updateBoard function.");
        BotMoves botMoves = new BotMoves();
        for(int i = 0; i < 3; i++){
            n = i;
            for(int j = 0; j < 3; j++){
                m = j;
                JButton btn = new JButton();
                btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                board[i][j] = btn;
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(((JButton)e.getSource()).getText().equals("") && hasWinner == false){
                            btn.setText(currentPlayer);
                            hasWinner();
                            togglePlayer();
                        }
                        currentBoard[m][n] = currentPlayer;
                    }
                });
                pane.add(btn);
            }
        }
        
        
         
    }


    private void togglePlayer(){
        if(currentPlayer.equals("x")){
            currentPlayer = "o";
        }
        else {
            currentPlayer = "x";
        }
    }

    //initializes the menu bar with the new game and quit buttons, that are pretty self explanitory 
    private void initializeMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("Options");

        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });

        quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void resetBoard(){
        currentPlayer = "x";
        turnCount = 0;
        hasWinner = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j].setText("");
            }
        }
    }

    //make this check it's surroundings so I can make the board any size
    private void hasWinner(){
        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }
        if(board[2][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won.");
            hasWinner = true;
        }        
    }
}
