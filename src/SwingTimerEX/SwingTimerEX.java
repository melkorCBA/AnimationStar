package SwingTimerEX;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingTimerEX extends JFrame {


    public SwingTimerEX(){
        this.iniUI();

    }

    private void iniUI(){

       add(new Board());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new SwingTimerEX();
            ex.setVisible(true);
        });
    }
}
