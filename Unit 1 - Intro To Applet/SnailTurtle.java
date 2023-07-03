import java.applet.*;
import java.awt.*;
public class SnailTurtle extends Applet {
    public void paint (Graphics g) {

    //Snail
    g.drawOval (30, 10, 10, 10);
    g.drawLine (40, 20, 50, 40);

    g.drawOval (110, 10, 10, 10);
    g.drawLine (110, 20, 100, 40);

    g.drawRect(40, 40, 70, 140);
    g.drawOval(30, 60, 40, 50);
    g.drawOval(80, 60, 40, 50);
    g.drawOval(50, 80, 10, 10);
    g.drawOval(90, 80, 10, 10);
    g.drawLine (60, 120, 90, 120);
    g.drawOval(50, 140, 50, 70);

    g.drawRect(20, 80, 20, 100);
    g.drawRect(110, 80, 20, 100);


    //Turtle
    g.drawOval (210, 10, 70, 40);
    g.drawRect(190, 30, 110, 120);
    g.drawOval (180, 40, 20, 40);
    g.drawOval (290, 40, 20, 40);

    g.drawRect(210, 60, 70, 100);
    g.drawRect(190, 150, 40, 30);
    g.drawRect(270, 150, 30, 30);

    g.drawOval (200, 80, 40, 50);
    g.drawOval (250, 80, 40, 50);
    g.drawOval (220, 100, 10, 10);
    g.drawOval (260, 100, 10, 10);
    g.drawLine (230, 140, 260, 140);

    }

}