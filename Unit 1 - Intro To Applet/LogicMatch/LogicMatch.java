import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class LogicMatch extends Applet implements ActionListener
{
    int num1 = 1;
    int num2 = 2;
    JLabel clue, message, pic;
    public void init ()
    {
	message = new JLabel ("Click on the image that matches the clue.");
	message.setFont (new Font ("Arial Rounded MT Bold", Font.PLAIN, 16));
	pic = new JLabel (createImageIcon ("blank.png"));
	clue = new JLabel ("It has a black outline, is not a circle and is not a rectangle.");

	Panel g = new Panel (new GridLayout (3, 3));
	JButton a = new JButton (createImageIcon ("11.png"));
	a.addActionListener (this);
	a.setActionCommand ("11");
	g.add (a);
	JButton b = new JButton (createImageIcon ("12.png"));
	b.addActionListener (this);
	b.setActionCommand ("12");
	g.add (b);
	JButton c = new JButton (createImageIcon ("13.png"));
	c.addActionListener (this);
	c.setActionCommand ("13");
	g.add (c);

	JButton d = new JButton (createImageIcon ("21.png"));
	d.addActionListener (this);
	d.setActionCommand ("21");
	g.add (d);
	JButton e = new JButton (createImageIcon ("22.png"));
	e.addActionListener (this);
	e.setActionCommand ("22");
	g.add (e);
	JButton f = new JButton (createImageIcon ("23.png"));
	f.addActionListener (this);
	f.setActionCommand ("23");
	g.add (f);

	JButton h = new JButton (createImageIcon ("31.png"));
	h.addActionListener (this);
	h.setActionCommand ("31");
	g.add (h);
	JButton i = new JButton (createImageIcon ("32.png"));
	i.addActionListener (this);
	i.setActionCommand ("32");
	g.add (i);
	JButton j = new JButton (createImageIcon ("33.png"));
	j.addActionListener (this);
	j.setActionCommand ("33");
	g.add (j);

	add (message);
	add (pic);
	add (clue);
	add (g);
	add (g);
	resize (340, 280);
    }


    public void actionPerformed (ActionEvent e)
    {
	int i = Integer.parseInt (e.getActionCommand ());
	pic.setIcon(createImageIcon(Integer.toString(i) + ".png"));

	    if (i / 10 == num1 && i % 10 == num2)
	    { 
		 message.setText("Correct!");
	     num1 = (int) (Math.random () * 3 + 1);
	     num2 = (int) (Math.random () * 3 + 1);
		 String text = "";
		 if(num2 == 1) {
			text += "It has a grey outline, ";
		 } else if(num2 == 2) {
			text += "It has a black outline, ";
		 } else if(num2 == 3) {
			text += "It has a white outline, ";
		 }
		 if(num1 == 1) {
			text += "is not a circle and is not a rectangle.";
		 } else if(num1 == 2) {
			text += "is not a circle and is not a triangle.";
		 } else if(num1 == 3) {
			text += "is not a triangle and is not a rectangle.";
		 }
		 clue.setText(text);
		} else {
			message.setText("Incorrect!");
		}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = LogicMatch.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	    return null;
    }

}
