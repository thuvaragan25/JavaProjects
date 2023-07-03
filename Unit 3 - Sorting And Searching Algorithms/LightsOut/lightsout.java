import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class lightsout extends Applet implements ActionListener
{
    int light[][] = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 2, 1}, {1, 1,2, 2, 2}, {1, 1, 1, 2, 1}};
    int row = 6;
    int col = 5;
    JButton pics[] = new JButton [row * col];
    int light0[][] = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 2, 1}, {1, 1,2, 2, 2}, {1, 1, 1, 2, 1}};
    int light1[][] = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 2, 1, 2, 1}, {2, 2, 1, 2, 2}, {1, 2, 1, 2, 1}};
    int light2[][] = {{1, 1, 1, 1, 1}, {1, 1, 1, 2, 1}, {1, 2, 2, 2, 2}, {2, 1, 2, 2, 1}, {2, 1, 2, 1, 1}, {1, 2, 1, 1, 1}};
    int light3[][] = {{1, 1, 2, 1, 1}, {1, 1, 2, 2, 1}, {2, 1, 2, 2, 1}, {2, 1, 2, 1, 2}, {2, 1, 1, 2, 1}, {1, 2, 1, 1, 1}};
    int light4[][] = {{1, 2, 1, 2, 1}, {2, 2, 1, 2, 2}, {1, 2, 2, 2, 1}, {1, 1, 1, 1, 1}, {2, 1, 1, 1, 2}, {1, 2, 2, 2, 1}};
    
    int difficulty = 1;

    Random random = new Random();


    public void init ()
    {

        resize (350, 500);
        setBackground (Color.black);
        JLabel title = new JLabel ("Lights Out");
        title.setFont (new Font ("Arial", Font.BOLD, 40));
        title.setForeground (new Color (207, 198, 126));
        add (title);
        Panel p = new Panel ();
        JButton reset = new JButton ("Reset");
        reset.setBackground (new Color (37, 37, 37));
        reset.setForeground (new Color (207, 198, 126));
        reset.addActionListener (this);
        reset.setActionCommand ("reset");
        p.add (reset);
        JButton next = new JButton ("Next");
        next.setBackground (new Color (37, 37, 37));
        next.setForeground (new Color (207, 198, 126));
        next.addActionListener (this);
        next.setActionCommand ("next");
        p.add (next);
        JButton previous = new JButton ("Previous");
        previous.setBackground (new Color (37, 37, 37));
        previous.setForeground (new Color (207, 198, 126));
        previous.addActionListener (this);
        previous.setActionCommand ("previous");
        p.add (previous);
        add (p);
        Panel grid = new Panel (new GridLayout (row, col));
        int m = 0;
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++)
            {
                if (light [i] [j] == 1)
                    pics [m] = new JButton (createImageIcon ("on.png"));
                else
                    pics [m] = new JButton (createImageIcon ("off.png"));
                pics [m].setPreferredSize (new Dimension (64, 64));
                pics [m].setBorderPainted (false);
                pics [m].setBackground (Color.black);
                pics [m].setActionCommand ("" + m);
                pics [m].addActionListener (this);
                grid.add (pics [m]);
                m++;
            }
        }
        add (grid);
    }

    public void redraw (){
        int m = 0;
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                if (light [i] [j] == 1)
                    pics [m].setIcon (createImageIcon ("on.png"));
                else if (light [i] [j] == 2)
                    pics [m].setIcon (createImageIcon ("off.png"));
                m++;
            }
        }
    }

    public void copyOver(int a[][], int b[][]) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = b[i][j];
                }
            }
        }


    public void reset() {
        if(difficulty == 1) 
            copyOver(light, light0);
        if (difficulty == 2)
            copyOver(light, light1);
        if (difficulty == 3)
            copyOver(light, light2);
        if (difficulty == 4)
            copyOver(light, light3);
        if (difficulty == 5)
            copyOver(light, light4);
        redraw();
    }

    public void previous() {
        difficulty--;
        if(difficulty < 1) difficulty = 5;
        if(difficulty == 1) 
            copyOver(light, light0);
        if (difficulty == 2)
            copyOver(light, light1);
        if (difficulty == 3)
            copyOver(light, light2);
        if (difficulty == 4)
            copyOver(light, light3);
        if (difficulty == 5)
            copyOver(light, light4);
        redraw(); 
    }

    public void next() {
        difficulty++;
        if(difficulty > 5) difficulty = 1;
        if(difficulty == 1) 
            copyOver(light, light0);
        if (difficulty == 2)
            copyOver(light, light1);
        if (difficulty == 3)
            copyOver(light, light2);
        if (difficulty == 4)
            copyOver(light, light3);
        if (difficulty == 5)
            copyOver(light, light4);
            
        redraw();
    }

    public boolean win(int[][] light){
        int[][] winCase =  new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1,1, 1, 1}, {1, 1, 1, 1, 1}};
        boolean win = true;
        for(int i = 0; i < 6; ++i) {
            for(int j = 0; j < 5; ++j) {
                if(light[i][j] != winCase[i][j]) win = false;
            }
        }
        System.out.print(win ? "You Won\n" : "");
        return win;
    }

    public void click (int pos) {
        int x = pos / col;
        int y = pos % col;

        if (light[x][y] == 1)
            light[x][y] = 2;
        else
            light[x][y] = 1;

        if (x-1 >= 0 && light[x-1][y] == 1)
            light[x-1][y] = 2;
        else if (x-1 >= 0)
            light[x-1][y] = 1;

        if (x+1 < row && light[x+1][y] == 1)
            light[x+1][y] = 2;
        else if (x+1 < row)
            light[x+1][y] = 1;
        
        if (y+1 < col && light[x][y+1] == 1)
            light[x][y+1] = 2;
        else if (y+1 < col)
            light[x][y+1] = 1;

        if (y-1 >= 0 && light[x][y-1] == 1)
            light[x][y-1] = 2;
        else if (y-1 >= 0)
            light[x][y-1] = 1;
        
        redraw();
        win(light);
        }

    public void actionPerformed (ActionEvent e){
        if (e.getActionCommand ().equals ("reset")){
            reset();
        }
        else if (e.getActionCommand ().equals ("next")){
            next ();
        }
        else if (e.getActionCommand ().equals ("previous")){
            previous();
        }
        else{    
            int pos = Integer.parseInt (e.getActionCommand ());
            click (pos);
        }
    }

    protected static ImageIcon createImageIcon (String path){
        java.net.URL imgURL = lightsout.class.getResource (path);
        if (imgURL != null) {
            return new ImageIcon (imgURL);
        } else {
            return null;
        }
    }
}