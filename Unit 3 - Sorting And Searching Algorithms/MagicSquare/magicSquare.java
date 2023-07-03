import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class magicSquare extends Applet implements ActionListener
{
    int row = 3;
    JButton a[] = new JButton [row * row];
    JLabel sums[] = new JLabel [row + row + 1];
    int sumNum[] = {6, 15, 24, 12, 15, 18, 45};
    JLabel title;
    JButton reset;
    
    public void init ()
    {
        title = new JLabel("Magic Square");
        for (int i = 0 ; i < a.length ; i++)
        {   
            a [i] = new JButton ("" + (i + 1));
            a [i].addActionListener (this);
            a [i].setActionCommand ("" + i);
            a [i].setBackground (pickClr (i + 1));
            a [i].setFont (new Font ("Arial", Font.PLAIN, 26));
            a [i].setPreferredSize (new Dimension (50, 50));
        }
        for (int i = 0 ; i < sums.length ; i++)
        {
            sums [i] = new JLabel (" " + sumNum [i]);
            sums [i].setFont (new Font ("Arial", Font.PLAIN, 16));
            sums [i].setPreferredSize (new Dimension (50, 50));
        }
        JPanel mainPane = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new BorderLayout());
        reset = new JButton("reset"); 
        reset.addActionListener(this);
        infoPanel.add(title, BorderLayout.NORTH);
        JLabel instructions = new JLabel("<html>A magic square is an arrangement of numbers where the numbers in each row, column, and diagonals all add up to the same number.</html>");
        infoPanel.add(instructions, BorderLayout.SOUTH);
        Panel g = new Panel (new GridLayout (row + 1, row + 1));
        mainPane.add(infoPanel, BorderLayout.NORTH);
        mainPane.add(g, BorderLayout.CENTER);
        mainPane.add(reset, BorderLayout.SOUTH);
        mainPane.setPreferredSize(new Dimension(200, 250));
        add(mainPane);
        g.add(a[0]);
        g.add(a[1]);
        g.add(a[2]);
        g.add(sums[0]);
        g.add(a[3]);
        g.add(a[4]);
        g.add(a[5]);
        g.add(sums[1]);
        g.add(a[6]);
        g.add(a[7]);
        g.add(a[8]);
        g.add(sums[2]);
        g.add(sums[3]);
        g.add(sums[4]);
        g.add(sums[5]);
        g.add(sums[6]);
        resize (500, 500);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand ().equals ("reset"))
        { 
            for (int i = 0 ; i < a.length ; i++)
            {   
                a[i].setText("" + (i + 1));
                a [i].setBackground (pickClr (i + 1));
            }
            updateSums();
            showStatus("Have you won? " + winner());
        }
        else
        {
            int n = Integer.parseInt (e.getActionCommand ());
            int x = n / row;
            int y = n % row;
            int num = Integer.parseInt (a [n].getText ());
            num = num+1;
            if (num >= 10){
                num = 1;
            }
            a[n].setText(Integer.toString(num));
            a[n].setBackground(pickClr(num));
            updateSums();
        }
        showStatus ("Have you won? " + winner ());
    }
    public void updateSums ()
    {
        int n[] = new int [9];
        for (int i = 0 ; i < a.length ; i++)
        { 
            n [i] = Integer.parseInt (a [i].getText ());
        }

        sumNum [0] = n [0] + n [1] + n [2];
        sumNum [1] = n [3] + n [4] + n [5];
        sumNum [2] = n [6] + n [7] + n [8];
        sumNum [3] = n [0] + n [3] + n [6];
        sumNum [4] = n [1] + n [4] + n [7];
        sumNum [5] = n [2] + n [5] + n [8];
        sumNum [6] = n [0] + n [4] + n [8];
        for (int i = 0 ; i < sums.length ; i++)
        { 
            sums [i].setText (" " + sumNum [i]);
        }
    }

    public boolean winner ()
    {
        boolean win = true;
        int check = sumNum [0];
        for (int i = 1 ; i < sumNum.length; i++)
        {
            if (sumNum [i] != check)
                win = false;
        }
        int nums[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int n[] = new int [9];
        for (int i = 0 ; i < a.length ; i++)
        {
            n [i] = Integer.parseInt (a [i].getText ());
        }
        for (int i = 0 ; i < n.length ; i++)
        {
            nums [n [i]]++;
        }
        for (int i = 1 ; i < nums.length ; i++)
        {
            if (nums [i] == 0)
                win = false;
        }
        return win;
    }

    public Color pickClr (int n)
    {
        Color clr[] = {Color.red, Color.orange, Color.yellow, Color.cyan,
        Color.green, Color.magenta, Color.pink, Color.white, Color.lightGray};
        return (clr [n - 1]);
    }
}