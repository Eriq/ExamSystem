import java.awt.*;

import java.awt.event.*;
import javax.swing.*;



public class TrafficLight extends JFrame implements Runnable

{


    JPanel mainP, street1P, street2P;
    public JButton btn1, btn2, btn3, btn4, btn5, btn6;




    JButton red, green, yellow ;

    TrafficLight()

    {

        street1P = new JPanel(new GridLayout(0, 1));
        street1P.add(btn1 = new JButton("Stop"));
        street1P.add(btn2 = new JButton("Wait"));
        street1P.add(btn3 = new JButton("Go"));
        street2P = new JPanel(new GridLayout(0, 1));
        street2P.add(btn4 = new JButton("Stop"));
        street2P.add(btn5 = new JButton("Wait"));
        street2P.add(btn6 = new JButton("Go"));
//         street2P = new JPanel(new GridLayout(0, 1));
//         street2P.add(btn7 = new JButton("Stop"));
//         street2P.add(btn8 = new JButton("Wait"));
//         street2P.add(btn9 = new JButton("Go"));

        mainP = new JPanel(new GridLayout(0, 2, 50, 50));
        mainP.add(street1P);
        mainP.add(street2P);



        // this.add(btn1); this.add(yellow); this.add(green) ;

        Thread t = new Thread(this) ;

        t.start();

        add(mainP, BorderLayout.CENTER);

        setSize(500, 500);
        setTitle("TrafficLights");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public void run()

    {

        while(true)

        {

            Thread turnRed = new Thread(new TurnRed());

            turnRed.start() ;

            synchronized(turnRed)

            {

                try { turnRed.wait() ; } catch(InterruptedException e) {}

            }

            Thread turnYellow = new Thread(new TurnYellow());

            turnYellow.start() ;

            synchronized(turnYellow)

            {

                try { turnYellow.wait() ; } catch(InterruptedException e) {}

            }

            Thread turnGreen = new Thread(new TurnGreen());

            turnGreen.start() ;

            synchronized(turnGreen)

            {

                try { turnGreen.wait() ; } catch(InterruptedException e) {}

            }

        }

    }

    public static void main(String[] args)

    {

        new TrafficLight().setVisible(true);

    }

    class TurnRed implements Runnable

    {

        public void run()

        {

            synchronized(this) {

                btn3.setBackground(Color.WHITE) ;

                btn1.setBackground(Color.RED) ;

                btn6.setBackground(Color.WHITE) ;

                btn4.setBackground(Color.RED) ;



                try { Thread.sleep(1000); } catch(InterruptedException e) {}

                notify(); }

        }

    }

    class TurnYellow implements Runnable

    {

        public void run()

        {

            synchronized(this) {

                btn1.setBackground(Color.WHITE) ;

                btn2.setBackground(Color.YELLOW) ;

                btn4.setBackground(Color.WHITE) ;

                btn5.setBackground(Color.YELLOW) ;

                try { Thread.sleep(1000); } catch(InterruptedException e) {}

                notify(); }

        }

    }

    class TurnGreen implements Runnable

    {

        public void run()

        {

            synchronized(this) {

                btn2.setBackground(Color.WHITE) ;
                btn3.setBackground(Color.GREEN) ;
                btn5.setBackground(Color.WHITE) ;
                btn6.setBackground(Color.GREEN) ;

                try { Thread.sleep(1000); } catch(InterruptedException e) {}

                notify(); }

        }

    }



}
