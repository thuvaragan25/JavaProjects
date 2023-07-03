import java.awt.*;
import java.applet.Applet;
public class ManyGhostsPacMans extends Applet
{
    public void paint (Graphics g)
    {
        for (int x = 0 ; x < 1000 ; x += 100)
        {
            for (int y = 0 ; y < 800 ; y += 100)
            {
                int random = (int) (Math.random () * 10);
                //change the method names to match your own.
                if (random == 0)
                    pacman (g, x, y);
                else
                    ghost (g, x, y);
            }
        }
    }
    public void pacman (Graphics g, int x, int y){
        g.drawOval(x, y, 50, 50);
        g.drawOval(x+10, y+20, 10, 10);
        g.drawOval(x+30, y+20, 10, 10);
        g.drawLine(x,y+30, x, y+60);
        g.drawLine(x,y+60, x+10, y+50);
        g.drawLine(x+10, y+50, x+20, y+60);
        g.drawLine(x+20, y+60, x+30, y+60);
        g.drawLine(x+30, y+60, x+40, y+50);
        g.drawLine(x+40, y+50, x+50, y+60);
        g.drawLine(x+50, y+60, x+50, y+30);
    }

    public void ghost (Graphics g, int x, int y){
        g.drawOval(x, y, 60, 60);
        g.drawLine(x+30, y+30, x+60, y+10);
        g.drawLine(x+30, y+30, x+60, y+50);
    }

}