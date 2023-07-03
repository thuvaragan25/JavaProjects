import java.awt.*; 
import java.awt.event.*; 
import java.applet.*;
import javax.swing.*;
 
import java.util.Random;

public class PicturePlace extends Applet implements ActionListener
{

    JButton[] thumbnails = new JButton[4];
    JButton[] puzzle = new JButton[4];

    int selectedPicture = -1;

    public void init ()
    {
        JPanel master = new JPanel(new BorderLayout());
        JPanel thumbnailsPanel = new JPanel(new GridLayout(1, 5));
        thumbnailsPanel.add(new JLabel("Thumbnails: "));
        for(int i = 0; i < 4; i++) {
            Icon icon = new ImageIcon("pictures/tn" + (i+1) + ".jpg");
            thumbnails[i] = new JButton(icon);
            thumbnails[i].setBorder(null);
            thumbnails[i].setMargin(new Insets(0, 0, 0, 0));
            thumbnails[i].setContentAreaFilled(false);
            thumbnails[i].setSize(88, 66);
            thumbnailsPanel.add(thumbnails[i]);
            thumbnails[i].addActionListener (this);
            thumbnails[i].setActionCommand ("tn" + (i+1));
        }


        int[] puzzleOrder = new int[4];
        for(int i = 0; i < 4; i++) puzzleOrder[i] = i+1;
        puzzleOrder = randomize(puzzleOrder);

        JPanel puzzlePanel = new JPanel(new GridLayout(2, 2));

        for(int i = 0; i < 4; i++) {
            Icon icon = new ImageIcon("pictures/cinder" + (puzzleOrder[i]) + ".jpg");
            puzzle[i] = new JButton(icon);
            puzzle[i].setBorder(null);
            puzzle[i].setMargin(new Insets(0, 0, 0, 0));
            puzzle[i].setContentAreaFilled(false);
            puzzle[i].setSize(300, 225);
            puzzlePanel.add(puzzle[i]);
            puzzle[i].addActionListener (this);
            puzzle[i].setActionCommand ("cinder" + (i+1));
        }

        JPanel instructions = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Cinderella Puzzle");
        title.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        title.setHorizontalAlignment(JLabel.CENTER);
        instructions.add(title, BorderLayout.NORTH);
        JLabel i1 = new JLabel("Click on the thumbnail of the picture you want to place.");
        JLabel i2 = new JLabel("Then click the square where you wish to place it.");
        i1.setHorizontalAlignment(JLabel.CENTER);
        i2.setHorizontalAlignment(JLabel.CENTER);
        instructions.add(i1, BorderLayout.CENTER);
        instructions.add(i2, BorderLayout.SOUTH);

        master.add(instructions, BorderLayout.NORTH);
        master.add(thumbnailsPanel, BorderLayout.CENTER);
        master.add(puzzlePanel, BorderLayout.SOUTH);
        add(master);
        resize(800, 650);

    }

    int[] randomize(int[] list) {
        int[] ret = list;
        Random random = new Random();
        for(int i = 0; i < list.length; i++) {
            int idx = random.nextInt(list.length);
            int temp = ret[idx];
            ret[idx] = ret[i];
            ret[i] = temp;
        }
        return ret;
    }

    public void actionPerformed (ActionEvent e)
    {
        char[] command = e.getActionCommand ().toCharArray();
        if(command[0] == 't') {
            selectedPicture = command[command.length - 1] - '0';
        } else if(command[0] == 'c') {
            if(selectedPicture != -1) {
                Icon icon = new ImageIcon("pictures/cinder" + selectedPicture + ".jpg");
                puzzle[command[command.length - 1] - '0' - 1].setIcon(icon);
            }
            selectedPicture = -1;
        }
    }
}