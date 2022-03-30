import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainBoard extends JFrame{
    //this needs to be the board object that is passed to both the player and botMoves obects
    //when the board is passed to those objects, they each will have a method that returns a move,
    //then this method (aka the main board) is updated.
    private JButton[][] currentBoard;
    private String currentPlayer;
    private Container pane;
    private JButton[][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;
    private int turnCount;


    //CONSTRUCTOR
    //- The object's fields are set to the provided values
    public MainBoard(/*JButton[][] currentBoard*/){
        //this.currentBoard = currentBoard;
    }

    public String[][] initializeBoard(){
        String[][] newBoard = new String[3][3];
        turnCount = 0;
        pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Tic Tac Toe");
        setSize(750, 750);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        initializeMenuBar();
        return newBoard;
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
