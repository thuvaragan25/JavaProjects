import java.applet.*;
import java.awt.*;
public class Star extends Applet {

    public void createShape(Graphics g, int[] x1, int[] y1, Color color) {
        g.setColor(color);
        g.fillPolygon(x1, y1, x1.length);
    }

    public void paint (Graphics g) {
        Color darkShade = new Color(121, 40, 168);
        Color lightShade = new Color(149, 33, 217);
        int X1Coordinates[] = {177, 210, 324, 232, 267, 175, 83, 122, 27, 140};
        int Y1Coordinates[] = {22, 133, 132, 198, 308, 236, 306, 198, 132, 133};
        createShape(g, X1Coordinates, Y1Coordinates, lightShade);

        int X2Coordinates[] = {177, 140, 27, 175};
        int Y2Coordinates[] = {22, 133, 132, 179};
        createShape(g, X2Coordinates, Y2Coordinates, darkShade);

        int X3Coordinates[] = {210, 324, 175};
        int Y3Coordinates[] = {133, 132, 179};
        createShape(g, X3Coordinates, Y3Coordinates, darkShade);

        int X4Coordinates[] = {175, 267, 175};
        int Y4Coordinates[] = {179, 308, 236};
        createShape(g, X4Coordinates, Y4Coordinates, darkShade);

        int X5Coordinates[] = {122, 175, 83};
        int Y5Coordinates[] = {198, 179, 306};
        createShape(g, X5Coordinates, Y5Coordinates, darkShade);
    }

}