import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GiantCatArmy extends Applet implements ActionListener {

    JLabel display;
    JButton plus5, plus7, squareRoot, reset;
    Panel panel, labelPanel, logPanel;
    int num = 0;
    String log = "";
    JLabel logDisplay;
    int order = -1;

    public void init() {
        display = new JLabel(Integer.toString(num));

        plus5 = new JButton("+5");
        plus5.addActionListener(this);
        plus5.setActionCommand("plus5");

        plus7 = new JButton("+7");
        plus7.addActionListener(this);
        plus7.setActionCommand("plus7");

        squareRoot = new JButton("sqrt");
        squareRoot.addActionListener(this);
        squareRoot.setActionCommand("sqrt");

        reset = new JButton("reset");
        reset.addActionListener(this);
        reset.setActionCommand("reset");

        logDisplay = new JLabel(log);

        panel = new Panel(new FlowLayout());
        panel.add(plus5);
        panel.add(plus7);
        panel.add(squareRoot);
        panel.add(reset);

        labelPanel = new Panel(new FlowLayout());
        labelPanel.add(display);

        logPanel = new Panel(new FlowLayout());
        logPanel.add(logDisplay);

        setLayout(new BorderLayout());
        add(labelPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(logPanel, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("plus5")) {
            num += 5;
            if(num >= 60) num = 0;
        } else if(command.equals("plus7")) {
            num += 7;
            if(num >= 60) num = 0;
        } else if(command.equals("sqrt")) {
            num = (int) (Math.sqrt(num));
        } else if(command.equals("reset")) {
            num = 0;
            order = -1;
            log = "";
        }

        if(num == 2) {
            if(order == -1) {
                order = 2;
            } else {
                order = -1;
            }
        }

        if(num == 10) {
            if(order == 2) {
                order = 10;
            } else {
                order = -1;
            }
        }

        if(num == 14) {
            if(order == 10) {
                order = 14;
            } else {
                order = -1;
            }
        }

        log += " " + Integer.toString(num);
        logDisplay.setText(log);
        if(order != 14) {
            display.setText(Integer.toString(num));
        } else {
            display.setText("You won! Congratulations!");
        }

    }
}