import java.awt.*;
import java.applet.Applet;
public class GraphicMethods extends Applet
{
    public void paint (Graphics g)
    {
        c(g, 0, 20);
        c(g, 50, 0);
        hexagon(g, 90, 0);
        hexagon(g, 130, 100);
        star(g, 150, 0, 1);
        star(g, 150, 20, 2);
        diamond(g, 300, 0, 1, 1);
        diamond(g, 310, 0, 2, 1);

    }
    public void c (Graphics g, int x, int y){
        g.drawRect(x, y, 10, 30);
        g.drawRect(x+10, y, 20, 10);
        g.drawRect(x+10, y+20, 20, 10);
    }
    public void hexagon (Graphics g, int x, int y){
        g.drawLine(x+10, y, x+20, y);
        g.drawLine(x+20, y, x+30, y+10);
        g.drawLine(x+30, y+10, x+30, y+20);
        g.drawLine(x+30, y+20, x+20, y+30);
        g.drawLine(x+20, y+30, x+10, y+30);
        g.drawLine(x+10, y+30, x, y+20);
        g.drawLine(x, y+20, x, y+10);
        g.drawLine(x, y+10, x+10, y);
    }
    public void star(Graphics g, int x, int y, int z){
        g.drawLine((x+60)*z, y*z, (x+30)*z, (y+110)*z);
        g.drawLine((x+30)*z, (y+110)*z, (x+110)*z, (y+40)*z);
        g.drawLine((x+110)*z, (y+40)*z, x*z, (y+40)*z);
        g.drawLine(x*z, (y+40)*z, (x+90)*z, (y+110)*z);
        g.drawLine((x+90)*z, (y+110)*z, (x+60)*z, y*z);
    }

    public void diamond(Graphics g, int x, int y, int xz, int yz){
        g.drawLine((x+20)*xz, y*yz, (x+40)*xz, y*yz);
        g.drawLine((x+40)*xz, y*yz, (x+60)*xz, (y+30)*yz);
        g.drawLine((x+60)*xz, (y+30)*yz, (x+30)*xz, (y+70)*yz);
        g.drawLine((x+30)*xz, (y+70)*yz, x*xz, (y+30)*yz);
        g.drawLine(x*xz, (y+30)*yz, (x+20)*xz, y*yz);
  
    }

}