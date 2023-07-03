import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.io.*;

public class HighRoller extends Applet implements ActionListener
{
    JButton bmine, next, bcomp;
    JLabel action, score, pic, pic2;
    int dice1 = 0, dice2 = 0, cscore = 0, uscore = 0;


    public void init ()
    {
        JLabel title = new JLabel ("High Roller");
        title.setFont (new Font ("Arial", Font.BOLD, 40));
        title.setForeground (new Color (136, 0, 21));

        JLabel words = new JLabel ("You roll. The computer rolls. ");
        JLabel morewords = new JLabel ("Higher roll wins.");
        JLabel mine = new JLabel ("Yours");
        mine.setFont (new Font ("Arial", Font.BOLD, 18));
        mine.setPreferredSize (new Dimension (70, 128));
        JLabel comp = new JLabel ("Comp");
        comp.setFont (new Font ("Arial", Font.BOLD, 18));
        comp.setPreferredSize (new Dimension (70, 128));

        pic = new JLabel (createImageIcon ("d0.png"));
        pic2 = new JLabel (createImageIcon ("d0.png"));

        bmine = new JButton ("ROLL Mine");
        bmine.setActionCommand ("1");
        bmine.addActionListener (this);

        bcomp = new JButton ("ROLL Comp");
        bcomp.setActionCommand ("2");
        bcomp.addActionListener (this);
        bcomp.setEnabled (false);

        next = new JButton ("Play again.");
        next.setActionCommand ("3");
        next.addActionListener (this);
        next.setEnabled (false);

        action = new JLabel ("Roll your dice to begin.");
        action.setFont (new Font ("Arial", Font.BOLD, 18));
        score = new JLabel ("Score:   You _____,     Computer ____    ");

        add (title);
        add (words);
        add (morewords);
        Panel p = new Panel ();
        p.add (mine);
        p.add (pic);
        p.add (bmine);
        p.setBackground (new Color (0, 128, 192));


        add (p);
        Panel p2 = new Panel ();
        p2.add (comp);
        p2.add (pic2);
        p2.add (bcomp);
        p2.setBackground (new Color (136, 0, 21));

        add (p2);
        add (action);

        add (next);
        add (score);

        resize (340, 420);
    }


    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand ().equals ("1"))
        {
            dice1 = (int) (Math.random () * 6) + 1;
            pic.setIcon (createImageIcon ("d" + dice1 + ".png"));
            bmine.setEnabled (false);
            bcomp.setEnabled (true);
            action.setText ("Roll computer's dice.");
        }
        else if (e.getActionCommand ().equals ("2"))
        {
            dice2 = (int) (Math.random () * 6) + 1;
            pic2.setIcon (createImageIcon ("d" + dice2 + ".png"));
            bmine.setEnabled (false);
            bcomp.setEnabled (false);
            next.setEnabled (true);
            if (dice1 == dice2)
            {
                action.setText ("It is a tie!");

            }
            else if (dice1 > dice2)
            {
                uscore += 1;
                action.setText ("You won!");
            }
            else
            {
                cscore += 1;
                action.setText ("Computer won!");
            }
            score.setText ("Score:   You " + Integer.toString (uscore) + ",     Computer " + Integer.toString (cscore) + "    ");


        }
        else
        {
            bmine.setEnabled (true);
            next.setEnabled (false);
            action.setText ("Roll your dice.");
            pic.setIcon (createImageIcon ("d0" + ".png"));
            pic2.setIcon (createImageIcon ("d0" + ".png"));

        }
    }


    protected static ImageIcon createImageIcon (String path)
    {
        java.net.URL imgURL = HighRoller.class.getResource (path);
        if (imgURL != null)
        {
            return new ImageIcon (imgURL);
        }
        else
        {
            System.err.println ("Couldn't find file: " + path);
            return null;
        }
    }
}




