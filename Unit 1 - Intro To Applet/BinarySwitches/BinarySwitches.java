import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BinarySwitches extends Applet implements ActionListener {

    JButton button1, button2, button3, button4;
    Panel panel, lightPanel;
    boolean button1Toggle, button2Toggle, button3Toggle, button4Toggle;
    JLabel button1Light, button2Light, button3Light, button4Light;
    char[] binary = { '0', '0', '0', '0' };
    JLabel binaryDisplay;
    JLabel decimalDisplay;
    Panel labelPanel;

    public void init() {

        binaryDisplay = new JLabel(new String(binary));
        decimalDisplay = new JLabel(Integer.toString(binStrToInt(binary)));

        button1Toggle = false;
        button1 = new JButton(new ImageIcon("off_switch.png"));
        button1.addActionListener(this);
        button1.setActionCommand("setButton1");

        button2Toggle = false;
        button2 = new JButton(new ImageIcon("off_switch.png"));
        button2.addActionListener(this);
        button2.setActionCommand("setButton2");

        button3Toggle = false;
        button3 = new JButton(new ImageIcon("off_switch.png"));
        button3.addActionListener(this);
        button3.setActionCommand("setButton3");

        button4Toggle = false;
        button4 = new JButton(new ImageIcon("off_switch.png"));
        button4.addActionListener(this);
        button4.setActionCommand("setButton4");

        panel = new Panel(new FlowLayout());
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        button1Light = new JLabel(new ImageIcon("on_light.png"));
        button2Light = new JLabel(new ImageIcon("on_light.png"));
        button3Light = new JLabel(new ImageIcon("on_light.png"));
        button4Light = new JLabel(new ImageIcon("on_light.png"));

        lightPanel = new Panel(new FlowLayout());
        lightPanel.add(button1Light);
        lightPanel.add(button2Light);
        lightPanel.add(button3Light);
        lightPanel.add(button4Light);

        labelPanel = new Panel(new FlowLayout());
        labelPanel.add(binaryDisplay);
        labelPanel.add(decimalDisplay);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(lightPanel, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("setButton1")) {
            button1Toggle = !button1Toggle;
            if(button1Toggle) {
                button1.setIcon(new ImageIcon("on_switch.png"));
                button1Light.setIcon(new ImageIcon("off_light.png"));
                binary[0] = '1';
            } else {
                button1.setIcon(new ImageIcon("off_switch.png"));
                button1Light.setIcon(new ImageIcon("on_light.png"));
                binary[0] = '0';
            }
        }

        if(command.equals("setButton2")) {
            button2Toggle = !button2Toggle;
            if(button2Toggle) {
                button2.setIcon(new ImageIcon("on_switch.png"));
                button2Light.setIcon(new ImageIcon("off_light.png"));
                binary[1] = '1';
            } else {
                button2.setIcon(new ImageIcon("off_switch.png"));
                button2Light.setIcon(new ImageIcon("on_light.png"));
                binary[1] = '0';
            }
        }

        if(command.equals("setButton3")) {
            button3Toggle = !button3Toggle;
            if(button3Toggle) {
                button3.setIcon(new ImageIcon("on_switch.png"));
                button3Light.setIcon(new ImageIcon("off_light.png"));
                binary[2] = '1';
            } else {
                button3.setIcon(new ImageIcon("off_switch.png"));
                button3Light.setIcon(new ImageIcon("on_light.png"));
                binary[2] = '0';
            }
        }

        if(command.equals("setButton4")) {
            button4Toggle = !button4Toggle;
            if(button4Toggle) {
                button4.setIcon(new ImageIcon("on_switch.png"));
                button4Light.setIcon(new ImageIcon("off_light.png"));
                binary[3] = '1';
            } else {
                button4.setIcon(new ImageIcon("off_switch.png"));
                button4Light.setIcon(new ImageIcon("on_light.png"));
                binary[3] = '0';
            }
        }
        binaryDisplay.setText(new String(binary));
        decimalDisplay.setText(Integer.toString(binStrToInt(binary)));
    }

    public int binStrToInt(char[] binStr) {
        int ans = 0;
        for(int i = 3; i >= 0; --i) {
            ans += (Character.getNumericValue(binStr[3-i])) * (Math.pow(2, i));
        }
        return ans;
    }
}