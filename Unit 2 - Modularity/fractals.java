import java.applet.*;
import java.awt.*;
public class Fractals extends Applet {
    public void paint (Graphics g) {
        resize(900,600);
        //cantorcheese(0, 0, 400, Color.blue);
        //squareFractal(200, 100, 200);
        //pattern(100, 0, 200);
        //concentriccircles(100, 0, 100);
        //circles(300, 150, 100);
        //circles2 (300, 300, 100);
        //circles3 (300, 300, 100);
        //tsquare(100,100,80);
        //cantorDust(40,40,120);
            
        //int x[]={487,859,97};
        //int y[]={44,591,591};
        //g.fillPolygon(x,y,3);
        //g.setColor(Color.white);
        //tri(487,44,859,591,97,591,5);
    }
    public void cantorcheese (int x, int y, int r, Color colour) {
        Graphics g = getGraphics ();
        if (r < 5)
            return;
        else {
            g.setColor(colour);
            g.fillOval (x, y, r, r);
            cantorcheese (x + 0, y + r/4, r/2, (colour == Color.blue ? Color.green : Color.blue));
            cantorcheese (x + r/2, y + r/4, r/2, (colour == Color.blue ? Color.green : Color.blue));
        }
    }

    public void squareFractal (int x, int y, int r){
        Graphics g = getGraphics();
        if (r<25)
            return;
        else{
            g.drawRect(x, y, r, r);
            squareFractal(x-r/4, y-r/4, r/2);
            squareFractal(x+r-r/4, y-r/4, r/2);
            squareFractal(x-r/4, y+r-r/4, r/2);
            squareFractal(x+r-r/4, y+r-r/4, r/2);


        }
    }
    public void pattern (int x, int y, int d){
        Graphics g = getGraphics ();
        if (d <= 5)
            return;
        else{
            g.drawOval(x, y, d, d);
            pattern(x+d/2, y, d/2);
            pattern(x, y, d/2);
            pattern(x, y+d/2, d/2);
            pattern(x+d/2, y+d/2, d/2);
        }
    
    
    }

    public void concentriccircles (int x, int y, int r) {
        Graphics g = getGraphics();
        
        if(r <= 6.25) {
            return;
        } else {
            g.drawOval(x, y, r, r);
            concentriccircles(x + (r/4), y + (r/4), r/2);
        }
    }
    
    public void circles(int x, int y, int r){
        Graphics g = getGraphics ();

        if (r > 400)
            return;
        else
        {
            g.drawOval (x, y, r, r);
            circles(x, y-(r/2), r*2);


        }
    }

    public void circles2 (int x, int y, int r)
    {
        Graphics g = getGraphics ();

        if (r <= 6.25)
            return;
        else
        {
            g.drawOval (x, y, r, r);
            circles2 (x, y, r / 2);


        }

    }

    public void circles3(int x, int y, int r)
    {
        Graphics g = getGraphics ();

        if (r > 400)
            return;
        else
        {
            g.drawOval (x, y, r, r);
            circles3 (x-r, y+(-r/2), r * 2);


        }
    }
    

    public void tsquare (int x, int y, int r) {
        Graphics g = getGraphics();
        if (r<10)
            return;
        else {
            g.fillRect(x,y,r,r);
            tsquare(x-r/4,y-r/4,r/2); 
            tsquare(x+3*r/4,y-r/4,r/2);
            tsquare(x-r/4,y+3*r/4,r/2); 
            tsquare(x+3*r/4,y+3*r/4,r/2); 
        }
    }
    

    
    public void cantorDust (int x, int y, int r) {
        Graphics g = getGraphics();
        if (r<5)
            return;
        else {
            g.setColor(Color.white);
            g.fillRect(x,y,r,r);
            g.setColor(Color.black);
            g.fillRect(x,y,r/3,r/3);
            g.fillRect(x+2*r/3,y,r/3,r/3);
            g.fillRect(x,y+2*r/3,r/3,r/3);
            g.fillRect(x+2*r/3,y+2*r/3,r/3,r/3);
            
            cantorDust(x,y,r/3);
            cantorDust(x+2*r/3,y,r/3); 
            cantorDust(x,y+2*r/3,r/3); 
            cantorDust(x+2*r/3,y+2*r/3,r/3); 
        }
    }
    


    public void tri(int ax, int ay, int bx, int by, int cx, int cy, int i) {
        Graphics g = getGraphics();
        if (i<1)
            return;
        else {
            int x2[]={(ax+bx)/2,(cx+bx)/2,(ax+cx)/2};
            int y2[]={(ay+by)/2,(cy+by)/2,(ay+cy)/2};
            g.setColor(new Color(i*50,255,0));
            g.fillPolygon(x2,y2,3);
            tri(x2[2],y2[2],x2[1],y2[1],cx,cy,i-1);
        }
    }

}
