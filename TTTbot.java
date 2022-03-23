import javax.swing.SwingUtilities;

public class TTTbot {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new ticTacToe();
            }
        });
    }
        /*String gamemode = "";
        //ticTacToe begin = new ticTacToe("terminal");
        if (args[0].equals("terminal")){
            gamemode = "terminal";
            ticTacToe begin = new ticTacToe(gamemode);
        }
        if (args[0].equals("gui")){
            
            SwingUtilities.invokeLater(new Runnable() {
                public void run(){
                    new ticTacToe("gui");
                }
            });
            
        }*/
}
