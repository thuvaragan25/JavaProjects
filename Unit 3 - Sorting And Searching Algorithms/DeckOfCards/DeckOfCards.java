import java.awt.*; 
import java.awt.event.*; 
import java.applet.*;
import javax.swing.*;

import java.util.Random;

public class DeckOfCards extends Applet implements ActionListener
{
    int[] deck = new int[52];

    JPanel panel;
    
    public void init ()
    {

        panel = new JPanel(new GridLayout(1, 5));

        for(int i = 0; i < deck.length; ++i) {
            deck[i] = i;
        }  
        deck = randomize(deck);

        for(int i = 0; i < 5; i++) {
            JLabel card = new JLabel(new ImageIcon("cards/" + cardNumToPicture(deck[i])));
            panel.add(card);
            System.out.println(cardToWord(deck[i]));
        }
        
        add(panel);
    }

    int[] randomize(int[] list) {
        int[] ret = list;
        Random random = new Random();
        for(int i = 0; i < list.length; i++) {
            int idx = random.nextInt(list.length);
            int temp = ret[idx];
            ret[idx] = ret[i];
            ret[i] = temp;
        }
        return ret;
    }
    String cardToWord(int num) {
        String ret = "";

        int suit = num / 13;
        if(suit == 0) 
            ret += "spades";
        if(suit == 1) 
            ret += "hearts";
        if(suit == 2) 
            ret += "diamonds";
        if(suit == 3) 
            ret += "clubs";

        ret += " ";

        int rank = num % 13;
        if(rank == 0) ret += "A";
        else if(rank >= 1 && rank <= 8) 
            ret += "0" + (rank+1);
        else if(rank == 9) 
            ret += "10";
        else if(rank == 10) 
            ret += "J";
        else if(rank == 11) 
            ret += "Q";
        else if(rank == 12) 
            ret += "K";
 
        return ret;
    } 
    String cardNumToPicture(int num) {
        String ret = "card_";

        int suit = num / 13;
        if(suit == 0) 
            ret += "spades";
        if(suit == 1) 
            ret += "hearts";
        if(suit == 2) 
            ret += "diamonds";
        if(suit == 3) 
            ret += "clubs";

        ret += "_";

        int rank = num % 13;
        if(rank == 0) ret += "A";
        else if(rank >= 1 && rank <= 8) 
            ret += "0" + (rank+1);
        else if(rank == 9) 
            ret += "10";
        else if(rank == 10) 
            ret += "J";
        else if(rank == 11) 
            ret += "Q";
        else if(rank == 12) 
            ret += "K";
 
        ret += ".png";
        return ret;
    } 
    public void actionPerformed (ActionEvent e)
    {
    }
    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = DeckOfCards.class.getResource (path);
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