import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this class needs to take the mainboard as a parameter, and return a move so that the
//main board gets updated             
public class BotMoves{// extends JFrame implements ActionListener{

    private JButton[][] board;

    public BotMoves(){
        
    }

    //RANDOMMOVE
    //this method returns a random move for the sake of testing
    public String[][] randomMove(String botPiece){
        Random rand = new Random();
        JButton btn = new JButton();
        //until optimal move is implemented, bot makes a random move
        int botRow = rand.nextInt(3);
        int botColumn = rand.nextInt(3);
        btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
        board[botRow][botColumn] = btn;

        return null;
    }

    //this method should return the minimax'd optimal move
    public String[][] optimalMove(){
        
        return null;
    }
}
