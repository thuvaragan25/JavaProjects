import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Face extends Applet implements ActionListener
{
    //Widgets, Panels
    JButton draw;
    JLabel lx, ly, lxscale, lyscale;
    JTextField tx, ty, txscale, tyscale;
    Panel flow;
    //Face Coordinates, initialized to 1. (Top Right and No Scaling)
    int x = 1;
    int y = 1;
    int xz = 1;
    int yz = 1;

    public void init ()
    { //Set Up Input Fields for Face Coordinates
        lx = new JLabel ("x co-ord:");
        ly = new JLabel ("y co-ord:");
        lxscale = new JLabel ("x scaling factor:");
        lyscale = new JLabel ("y scaling factor:");
        tx = new JTextField ("1", 2);
        ty = new JTextField ("1", 2);
        txscale = new JTextField ("1", 2);
        tyscale = new JTextField ("1", 2);
        //Set up draw button and actionlistener
        draw = new JButton ("Draw");
        draw.addActionListener (this);
        draw.setActionCommand ("draw");
        //Set up layout, add widgets
        setLayout (new BorderLayout ());
        flow = new Panel (new FlowLayout ());
        flow.add (lx);
        flow.add (tx);
        flow.add (ly);
        flow.add (ty);
        flow.add (lxscale);
        flow.add (txscale);
        flow.add (lyscale);
        flow.add (tyscale);
        flow.add (draw);
        flow.setBackground (Color.red);
        add(flow, "South");
        resize (600, 500);
    }
    public void paint (Graphics g)
    { //draw a white box over the background to erase everything
        g.setColor (Color.white);
        g.fillRect (0, 0, 600, 500);
        //draw the face passing in the global variables
        face (x, y, xz, yz);
        //used only to force an update
        showStatus ("Done Drawing Face");
    }
    /** Draws a face
    * @param x is the top x co-ordinate of the face
    * @param y is the left most y co-ordinate of the face
    * @param xz is the x scaling factor, stretches horizontally
    * @param yz is the y scaling factor, stretches vertically
    */
    public void face (int x, int y, int xz, int yz)
    {
        Color lightYellow = new Color (255, 255, 143);
        Color goldenYellow = new Color (255, 191, 0);
        Color emeraldGreen = new Color (80, 200, 120);
        
        Graphics g = getGraphics ();
        x = x / xz; //reset top based on scaling factor
        y = y / yz; //reset right coordinate based on scaling factor

        //yellow Circle
        g.setColor (lightYellow);
        g.fillOval ((x + 18) * xz, (y + 18) * yz, 84 * xz, 84 * yz);
        g.setColor (Color.black);
        g.drawOval ((x + 18) * xz, (y + 18) * yz, 84 * xz, 84 * yz);

        //eyes
        g.setColor (Color.white);
        g.fillOval ((x + 30) * xz, (y + 30) * yz, 25 * xz, 25 * yz);
        g.fillOval ((x + 60) * xz, (y + 30) * yz, 25 * xz, 25 * yz);
        g.setColor (Color.black);
        g.fillOval ((x + 40) * xz, (y + 40) * yz, 10 * xz, 10 * yz);
        g.fillOval ((x + 70) * xz, (y + 40) * yz, 10 * xz, 10 * yz);

        //nose
        g.setColor (Color.black);
        g.drawLine ((x + 60) * xz, (y + 55) * yz, (x + 65) * xz, (y + 70) * yz);
        g.drawLine ((x + 55) * xz, (y + 68) * yz, (x + 65) * xz, (y + 70) * yz);

        //Crown
        g.setColor (goldenYellow);
        int X[] = { (x+33)*xz, (x+33)*xz, (x+50)*xz, (x+60)*xz, (x+70)*xz, (x+87)*xz, (x+87)*xz, (x+33)*xz };
        int Y[] = { (y+28)*yz, (y+10)*yz, (y+18)*yz, (y+10)*yz, (y+18)*yz, (y+10)*yz, (y+28)*yz, (y+28)*yz };
        g.fillPolygon (X, Y, X.length);
        
        //emerald
        g.setColor (emeraldGreen);
        int X3[] = { (x+57)*xz, (x+60)*xz, (x+63)*xz, (x+60)*xz};
        int Y3[] = { (y+20)*yz, (y+15)*yz, (y+20)*yz, (y+25)*yz};
        g.fillPolygon (X3, Y3, X3.length);

        //teeth
        g.setColor (Color.white);
        g.fillRect ((x + 40) * xz, (y + 75) * yz, 40 * xz, 10 * yz);
        g.setColor (Color.black);
        g.drawRect ((x + 40) * xz, (y + 75) * yz, 40 * xz, 10 * yz);
        g.drawLine ((x + 50) * xz, (y + 75) * yz, (x + 50) * xz, (y + 85) * yz);
        g.drawLine ((x + 60) * xz, (y + 75) * yz, (x + 60) * xz, (y + 85) * yz);
        g.drawLine ((x + 70) * xz, (y + 75) * yz, (x + 70) * xz, (y + 85) * yz);
        g.drawLine ((x + 40) * xz, (y + 80) * yz, (x + 80) * xz, (y + 80) * yz);
    }
    /**
    Draw a face or clears the textfields
    @param e The ActionEvent invoked. e.getActionCommand contains nothing or draw
    */
    public void actionPerformed (ActionEvent e)
    {
        //get new co-ordinates and draw the  face 
        if (e.getActionCommand ().equals ("draw"))
        {
            showStatus ("");
            try
            {
                x = Integer.parseInt (tx.getText ());
                y = Integer.parseInt (ty.getText ());
                xz = Integer.parseInt (txscale.getText ());
                if (xz <= 0)
                xz = 1; //divide by zero, negative error check
                yz = Integer.parseInt (tyscale.getText ());
                if (yz <= 0)
                yz = 1; //divide by zero, negative error check
                repaint ();
            }
            catch (java.lang.NumberFormatException error)
            { //if the user entered text, display an error message and clear the textfield
                showStatus ("Enter NUMBERS in the text fields. eg. 2. No decimals.");
                tx.setText ("1");
                ty.setText ("1");
                txscale.setText ("1");
                tyscale.setText ("1");
            }
        }
    }
}