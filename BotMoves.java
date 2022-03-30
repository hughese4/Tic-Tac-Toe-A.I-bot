import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this class needs to take the mainboard as a parameter, and return a move so that the
//main board gets updated             
public class BotMoves extends JFrame implements ActionListener{

    private JButton[][] board;

    public BotMoves(){
        
    }

    //OPTIMALMOVE
    //this method should eventually calculate the most optimal move for the bot to make
    //given the current board state.
    public JButton[][] optimalMove(String botPiece){
        Random rand = new Random();
        JButton btn = new JButton();
        //until optimal move is implemented, bot makes a random move
        int botRow = rand.nextInt(3);
        int botColumn = rand.nextInt(3);
        btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
        board[botRow][botColumn] = btn;

        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
