import java.awt.*;
import java.applet.*;
import java.util.*; 

public class SortAnimator extends Applet
{
    Button select, bubble, insert;
    int a[] = {15, 4, 6, 8, 1, 3, 14, 13, 7, 12};
    Button reset;
    
    public void init ()
    {
        bubble = new Button ("bubble sort");
        add (bubble);
        reset = new Button ("reset");
        add (reset);
    }

    Random r = new Random();
    int low = 10;
    int high = 100;
    public boolean action (Event e, Object o)
    {
        if (e.target == bubble)
        {
            bubble (a);
        }
        else if (e.target == reset)
        { 
            for (int i=0; i<a.length; i++){
                
                int result = r.nextInt(14) + 1;
                a[i] = result;
            }
            printarray (a);
        }
        return true;
    }

    public void paint (Graphics g)
    {
        printarray (a);
    }

    public void printarray (int a[])
    { 
        Graphics g = getGraphics ();
        g.setColor (Color.white);
        g.fillRect (0, 0, 500, 500);
        int y = 50;
        for (int i = 0 ; i < a.length ; i++)
        {
            g.setColor (new Color (0, a [i] * 15, a [i] * 15));
            g.fillRect (50, y, a [i] * 20, 10);
            y += 12;
        }
    }

    public void bubble (int a[])
    { 
        int temp;
        for (int i = 0 ; i < a.length - 1 ; i++)
        {
            for (int j = 0 ; j < a.length - 1 - i ; j++)
            { 
                if (a [j + 1] < a [j])
                { 
                    temp = a [j];
                    a [j] = a [j + 1];
                    a [j + 1] = temp;
                    for (int m = 0 ; m < 200000000 ; m++);
                    printarray (a);
                }
            }
        }
    }
}
