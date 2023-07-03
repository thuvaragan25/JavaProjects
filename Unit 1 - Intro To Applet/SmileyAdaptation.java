import java.applet.Applet; 
import java.awt.*;
public class SmileyAdaptation extends Applet
{
    public void straightEyebrow(Graphics g, int i, int j){
        g.drawLine(i+15, j+16, i+45, j+16);
    }
    public void outwardEyebrow(Graphics g, int i, int j){
        g.drawLine(i+15, j+15, i+25, j+10);
        g.drawLine(i+35, j+10, i+45, j+15);
    }
    public void inwardEyebrow(Graphics g, int i, int j){
        g.drawLine(i+15, j+16, i+25, j+23);
        g.drawLine(i+35, j+23, i+45, j+16);
    }

    public void happyMouth(Graphics g, int i, int j){
        g.drawLine(i+15, j+35, i+25, j+45);
        g.drawLine(i+25, j+45, i+35, j+45);
        g.drawLine(i+35, j+45, i+45, j+35);
    }
    public void sadMouth(Graphics g, int i, int j){
        g.drawLine(i+15, j+45, i+25, j+35);
        g.drawLine(i+25, j+35, i+35, j+35);
        g.drawLine(i+35, j+35, i+45, j+45);
    }
    public void neutralMouth(Graphics g, int i, int j){
        g.drawLine(i+15, j+35, i+45, j+35);
    }
    public void openMouth(Graphics g, int i, int j){
        g.fillOval(i+25, j+35, 10, 10);
    }



    public void paint (Graphics g) {
        for (int i=0; i<490; i+=70){
            for (int j=0; j<490; j+=70){
                Color color = Color.yellow;
                int colorNum = (int) (Math.random() * 5 + 1);
                switch(colorNum) {
                    case 1:
                        color = Color.yellow;
                        break;
                    case 2:
                        color = new Color(227, 225, 98);
                        break;
                    case 3:
                        color = new Color(179, 176, 48);
                        break;
                    case 4:
                        color = new Color(250, 246, 5);
                        break;
                    case 5:
                        color = new Color(191, 163, 0);
                        break;
                    default:
                        break;
                }

                g.setColor(color);
                g.fillOval(i, j, 60, 60);
                g.setColor(Color.black);
                g.fillOval(i+15, j+20, 10, 10); 
                g.fillOval(i+35, j+20, 10, 10); 

                int mouthNum = (int)(Math.random() * 4 + 1);

                switch(mouthNum) {
                    case 1:
                        happyMouth(g, i, j);
                        break;
                    case 2:
                        sadMouth(g, i, j);
                        break;
                    case 3:
                        neutralMouth(g, i, j);
                        break;
                    case 4:
                        openMouth(g, i, j);
                        break;
                    default:
                        break;
                }

                int eyebrowNum = (int)(Math.random() * 4 + 1);

                switch(eyebrowNum) {
                    case 1:
                        inwardEyebrow(g, i, j);
                        break;
                    case 2:
                        outwardEyebrow(g, i, j);
                        break;
                    case 3:
                        straightEyebrow(g, i, j);
                        break;
                    default:
                        break;
                }
            }  
        }  
    }
}