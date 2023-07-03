import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
public class PizzaParty extends Applet implements ActionListener
{

    JLabel a, b, c, d, ee;
    JButton f, g, h, i, j;

    public void init ()
    {
	resize (350, 500);
	setBackground (Color.orange);
	JLabel title = new JLabel ("Pizza Party");
	title.setFont (new Font ("Arial", Font.PLAIN, 30));

	JButton pizza = new JButton (createImageIcon ("pizza.png"));
	pizza.setActionCommand ("pizza");
	pizza.setBackground (Color.orange);
	pizza.setPreferredSize (new Dimension (96, 96));
	pizza.addActionListener (this);

	JLabel instruct = new JLabel ("Click the Pizza to Start!");
	instruct.setFont (new Font ("Arial", Font.PLAIN, 20));
	JLabel instruct2 = new JLabel ("You Need to Get These Toppings:");
	instruct2.setFont (new Font ("Arial", Font.PLAIN, 16));

	Panel p = new Panel (new GridLayout (1, 5));
	a = new JLabel (createImageIcon ("small_plate.png"));
	a.setPreferredSize (new Dimension (48, 48));
	p.add (a);
	b = new JLabel (createImageIcon ("small_plate.png"));
	b.setPreferredSize (new Dimension (48, 48));
	p.add (b);
	c = new JLabel (createImageIcon ("small_plate.png"));
	c.setPreferredSize (new Dimension (48, 48));
	p.add (c);
	d = new JLabel (createImageIcon ("small_plate.png"));
	d.setPreferredSize (new Dimension (48, 48));
	p.add (d);
	ee = new JLabel (createImageIcon ("small_plate.png"));
	ee.setPreferredSize (new Dimension (48, 48));
	p.add (ee);


	JLabel instruct3 = new JLabel ("Here is what you have rolled so far:");
	instruct3.setFont (new Font ("Arial", Font.PLAIN, 16));
	Panel p2 = new Panel (new GridLayout (1, 3));
	f = new JButton (createImageIcon ("big_plate.png"));
	f.setActionCommand ("f");
	f.setBackground (Color.orange);
	f.setPreferredSize (new Dimension (96, 96));
	f.addActionListener (this);
	p2.add (f);
	g = new JButton (createImageIcon ("big_plate.png"));
	g.setActionCommand ("g");
	g.setBackground (Color.orange);
	g.setPreferredSize (new Dimension (96, 96));
	g.addActionListener (this);
	p2.add (g);
	h = new JButton (createImageIcon ("big_plate.png"));
	h.setActionCommand ("h");
	h.setBackground (Color.orange);
	h.setPreferredSize (new Dimension (96, 96));
	h.addActionListener (this);
	p2.add (h);
	Panel p3 = new Panel (new GridLayout (1, 2));
	i = new JButton (createImageIcon ("big_plate.png"));
	i.setActionCommand ("i");
	i.setBackground (Color.orange);
	i.setPreferredSize (new Dimension (96, 96));
	i.addActionListener (this);
	p3.add (i);
	j = new JButton (createImageIcon ("big_plate.png"));
	j.setActionCommand ("j");
	j.setBackground (Color.orange);
	j.setPreferredSize (new Dimension (96, 96));
	j.addActionListener (this);
	p3.add (j);

	Panel p4 = new Panel ();
	JButton reset = new JButton ("Reset");
	reset.addActionListener (this);
	reset.setActionCommand ("reset");
	reset.setPreferredSize (new Dimension (100, 30));
	p4.add (reset);
	JButton instructions = new JButton ("Instructions");
	instructions.addActionListener (this);
	instructions.setActionCommand ("instruct");
	instructions.setPreferredSize (new Dimension (120, 30));
	p4.add (instructions);
	JButton creator = new JButton ("Creator");
	creator.addActionListener (this);
	creator.setActionCommand ("creator");
	creator.setPreferredSize (new Dimension (100, 30));
	p4.add (creator);

	add (title);
	add (pizza);
	add (instruct);
	add (instruct2);
	add (p);
	add (instruct3);
	add (p2);
	add (p3);
	add (p4);

    }


    public void actionPerformed (ActionEvent e)
    {
		
	if (e.getActionCommand ().equals ("f"))
	{
		ChangeImage(f);
	}
	else if (e.getActionCommand ().equals ("g"))
	{
		ChangeImage(g);

	}
	else if (e.getActionCommand ().equals ("h"))
	{
		ChangeImage(h);

	}
	else if (e.getActionCommand ().equals ("i"))
	{
		ChangeImage(i);
	}
	else if (e.getActionCommand ().equals ("j"))
	{
		ChangeImage(j);
	}
	else if (e.getActionCommand ().equals ("pizza"))
	{
		ChangeImage(a);
		ChangeImage(b);
		ChangeImage(c);
		ChangeImage(d);
		ChangeImage(ee);
	}
	else if (e.getActionCommand ().equals ("creator"))
	{
	    JOptionPane.showMessageDialog (null, "This app was created by Thuvaragan, in 2023, at CPSS", "Created by", JOptionPane.INFORMATION_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("instruct"))
	{
	    JOptionPane.showMessageDialog (null, "Play against another player. \n Click on the pizza button to get random toppings. \n Click on the bottom plates until you match the toppings. \n First to match all, wins!!", "Pizza Party Instructions", JOptionPane.QUESTION_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("reset"))
	{
		f.setIcon (createImageIcon ("big_plate.png"));
		g.setIcon (createImageIcon ("big_plate.png"));
		h.setIcon (createImageIcon ("big_plate.png"));
		i.setIcon (createImageIcon ("big_plate.png"));
		j.setIcon (createImageIcon ("big_plate.png"));

		a.setIcon (createImageIcon ("small_plate.png"));
		b.setIcon (createImageIcon ("small_plate.png"));
		c.setIcon (createImageIcon ("small_plate.png"));
		d.setIcon (createImageIcon ("small_plate.png"));
		ee.setIcon (createImageIcon ("small_plate.png"));
		

	}

    }

	public static void ChangeImage(JComponent component){
		if(component instanceof JLabel) {
			JLabel labels = (JLabel) component;
			int n = (int)(Math.random()*6);
			if (n==1)
			labels.setIcon (createImageIcon ("small_tomato.png"));
			else if (n==2)
			labels.setIcon (createImageIcon ("small_pineapple.png"));
			else if (n==3)
			labels.setIcon (createImageIcon ("small_pepper.png"));
			else if (n==4)
			labels.setIcon (createImageIcon ("small_mushroom.png"));
			else if (n==5)
			labels.setIcon (createImageIcon ("small_bacon.png"));
			else
			labels.setIcon (createImageIcon ("small_cheese.png"));
		} else if(component instanceof JButton) {
			JButton button = (JButton) component;
			int n = (int)(Math.random()*6);
			if (n==1)
			button.setIcon (createImageIcon ("big_tomato.png"));
			else if (n==2)
			button.setIcon (createImageIcon ("big_pineapple.png"));
			else if (n==3)
			button.setIcon (createImageIcon ("big_pepper.png"));
			else if (n==4)
			button.setIcon (createImageIcon ("big_mushroom.png"));
			else if (n==5)
			button.setIcon (createImageIcon ("big_bacon.png"));
			else
			button.setIcon (createImageIcon ("big_cheese.png"));
		}
	}
	



    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = PizzaParty.class.getResource (path);
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
