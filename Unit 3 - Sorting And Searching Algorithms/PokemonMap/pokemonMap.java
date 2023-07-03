import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class pokemonMap extends Applet implements ActionListener {
//0= grass, 1=tree, 2=flowers, 3=road, 4=long grass, 5=rock, 6=water
    int map [][]={{0, 1, 2, 3, 4, 5, 6, 7},{0, 1, 2, 3, 4, 5, 6, 7}, {0, 1, 2, 3, 4, 5, 6, 7}, {0, 1, 2, 3, 4, 5, 6, 7}, {0, 1, 2, 3, 4, 5, 6, 7}, {0, 1, 2, 3, 4, 5, 6, 7}, {0, 1, 2, 3, 4, 5, 6, 7}};
    JLabel pics[]=new JLabel[49];
    
    public void init(){
        Panel grid=new Panel(new GridLayout(7,7));
        int m=0;
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                pics[m]=new JLabel (createImageIcon(""+map[i][j]+".jpg"));
                grid.add(pics[m]);
                m++;
            }
        }
        add(grid);
    }
    
    public void actionPerformed(ActionEvent e){
    }

    protected static ImageIcon createImageIcon (String path){
        java.net.URL imgURL = pokemonMap.class.getResource (path);

        if (imgURL != null)
            return new ImageIcon (imgURL);
        else
            return null;

    }
}