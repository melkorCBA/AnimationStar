package SwingTimerEX;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.TimerTask;
import java.lang.Math;

public class Board extends JPanel implements  ActionListener{

    final int B_width=1366;
    final int B_Height=768;
    private double iniX1 =B_width/3;
    private double iniY1 =B_Height/3;
    private double iniX2 =B_width/3-10.0;
    private double iniY2 =B_Height/3-10.0;
    final double radius=150;

    final int delay=1;

    private Image star1;
    private Image star2;
    private Timer timer;
    private double x1, y1;
    private double x2, y2;
    private Double deg1=0.0;
    private Double deg2=45.0;


    public Board(){

        this.iniBoard();

    }

    private void loadImage(){
        ImageIcon im=new ImageIcon("src/SwingTimerEX/index.jpg");
        star1=im.getImage();
        star2=im.getImage();
    }



    public void iniBoard(){
        //set bcolour
        this.setBackground(Color.black);
        //set window size
        this.setPreferredSize(new Dimension(B_width,B_Height));

        this.loadImage();

        x1= iniX1;
        y1= iniY1 -radius;
        x2= iniX2;
        y2= iniY2 -radius;



        timer=new Timer(delay,this);
        timer.start();

    }

    //star drawing
    private void drawStar(Graphics g){
        g.drawImage(star1,(int)x1,(int)y1,this);
        g.drawImage(star2,(int)x2,(int)y2,this);
        Toolkit.getDefaultToolkit().sync();

    }

public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.drawStar(g);

}






    private int Xcords(double deg,double iniX){

        double r=radius;
        int x=0;
        return x=(int) iniX +(int) (r*Math.sin(Math.toRadians(deg)));

    }

    private int Ycords(double deg,double iniY){

        double r=radius;
        int y=0;
        return y=(int) iniY +(int) (r*Math.cos(Math.toRadians(deg)));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        deg1+=0.5;
        deg2+=0.5;
        this.x1=this.Xcords(deg1,iniX1);
        this.x2=this.Xcords(deg2,iniX2);
        this.y1=this.Ycords(deg1,iniX1);
        this.y2=this.Ycords(deg2,iniX2);


        if (deg1>360.0) {
            deg1=0.0;
            iniX1-=10;
            iniY1-=10;

           this.x1= iniX1;
           this.y1= iniY1 +radius;
        }

        if (deg2>360.0) {
            deg2=0.45;

            iniX2-=10;
            iniY2-=10;


            this.x2= iniX2;
            this.y2= iniY2 +radius;
        }

       /* x += 1;
        y += 1;

        if (y > B_Height) {

            y = iniY1;
            x = iniX1;
        }*/

        repaint();

    }
}
