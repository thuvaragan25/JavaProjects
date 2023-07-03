import java.applet.*;
import java.awt.*;
public class ShadedOvals extends Applet {
    public void paint (Graphics g) {
  
        int colorStep = 0;

        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(i/2, i/2, 100-i, 100-i);
            colorStep += 10;
        }

        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(150+ i-(i/4), i/2, 100-i, 100-i);  
            colorStep += 10;
        }
        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(300+i/2, i-(i/4), 100-i, 100-i);
            colorStep += 10;
        }
        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(450+(i/4), i / 2, 100-i, 100-i);
            colorStep += 10;
        }

        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(600+(i/2), i / 4, 100-i, 100-i);
            colorStep += 10;
        }

        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval((i/4), 150+(i/4), 100-i, 100-i);
            colorStep += 10;
        }

        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(150+(i-(i/4)), 150+(i-(i/4)), 100-i, 100-i);
            colorStep += 10;
        }

        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(300+(i-(i/4)), 150+(i/4), 100-i, 100-i);
            colorStep += 10;
        }

        colorStep = 0;
        for(int i = 0; i < 100; i+=10) {
            g.setColor(new Color(130 + colorStep, 0, 0));
            g.fillOval(450+(i/4), 150+(i-(i/4)), 100-i, 100-i);
            colorStep += 10;
        }
        
    }

}