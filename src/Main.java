import Drop.Drop;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main extends JComponent implements Runnable {

    ArrayList<Drop> drops = new ArrayList<Drop>();

    static int screenWidth =  640;
    static int screenHeight = 360;
    public Main() { // Setup

        for (int i = 0; i<100;i++){
            drops.add(new Drop());
        }


        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                timeStep();
                repaint();
                Thread.sleep(1000 / 24);
            }
        } catch (InterruptedException ie) {
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2.setColor(new Color(138,43,226));
        g2.setStroke(new BasicStroke(4));
        for (int i = 0; i<100;i++){
            g2.drawLine(drops.get(i).getX(),drops.get(i).getY(),drops.get(i).getX(),drops.get(i).getY()+20);
        }



    }

    private void timeStep() {
        for (int i = 0; i<100;i++){
            drops.get(i).updateY();
        }
    }


    public static void main(String[] args) {
        JFrame f = new JFrame("Purple Rain");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Main());
        f.setSize(screenWidth, screenHeight);
        f.setVisible(true);
        f.setBackground(new Color(230,230,250));
    }
}

