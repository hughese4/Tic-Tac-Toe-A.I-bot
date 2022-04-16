import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this is the single player main class
public class TicTacToeBot extends JFrame {
    private Container pane;
    private JButton[][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;
    private int turnCount;

    //CONSTRUCTOR
    public TicTacToeBot(){
        super();
        MainBoard mainBoard = new MainBoard();
        BotMoves botMove = new BotMoves();
        Player player = new Player();

        mainBoard.initializeBoard();
        mainBoard.updateBoard();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new TicTacToeBot();
            }
        });
    }
}
