import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleEncryption extends Applet implements ActionListener {

    JLabel display, output, outputLabel;
    JButton caesarShift, numberCode, pigLatin, backwards;
    TextField plainText;
    JPanel panel;

    public void init() {
        display = new JLabel("Encryption");

        caesarShift = new JButton("Caesar Shift");
        caesarShift.addActionListener(this);
        caesarShift.setActionCommand("caesarShift");

        plainText = new TextField();

        numberCode = new JButton("Number Code");
        numberCode.addActionListener(this);
        numberCode.setActionCommand("numberCode");

        pigLatin = new JButton("Pig Latin");
        pigLatin.addActionListener(this);
        pigLatin.setActionCommand("pigLatin");

        backwards = new JButton("Backwards");
        backwards.addActionListener(this);
        backwards.setActionCommand("backwards");
       
        outputLabel = new JLabel("Cipher Text:");
        output = new JLabel("");

        panel = new JPanel(new GridLayout(8, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        display.setHorizontalAlignment(JLabel.CENTER);
        outputLabel.setHorizontalAlignment(JLabel.CENTER);
        output.setHorizontalAlignment(JLabel.CENTER);

        display.setFont(new Font("Verdana", Font.BOLD, 24));

        panel.add(display);
        panel.add(plainText);
        panel.add(caesarShift);
        panel.add(numberCode);
        panel.add(pigLatin);
        panel.add(backwards);
        panel.add(outputLabel);
        panel.add(output);

        add(panel);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("pigLatin")) {
            output.setText(pigLatin(plainText.getText()));
 
        }
        else if(command.equals("backwards")){
            output.setText(backwards(plainText.getText()));

        }
        else if(command.equals("numberCode")){
            output.setText(numberCode(plainText.getText()));

        }
        else if(command.equals("caesarShift")){
            output.setText(caesarShift(plainText.getText()));

        }
    }


    public String pigLatin(String plainText){
        return plainText.substring(1, plainText.length())+plainText.charAt(0)+"ay";
    }

    public String backwards(String plainText){
        String ans = "";
        for (int i = plainText.length()-1; i >= 0; i--){
            ans = ans+ plainText.charAt(i);
        }
        return ans;
    }
    public String numberCode(String plainText){
        int num = 0;
        plainText = plainText.toLowerCase();
        String ans = "";

        for (int i = 0; i < plainText.length(); i++ ){
            num = (int)(plainText.charAt(i) - 'a' + 1);
            ans += Integer.toString(num);
        }
        return ans;
    }

    public String caesarShift(String plainText){
        int num = 0;
        String ans = "";
        plainText = plainText.toLowerCase();
        for (int i = 0; i < plainText.length(); i++){
            num = (int)((plainText.charAt(i) - 'a' + 1) % 26) + 'a';
            ans += (char) num;
        }
        return ans;
    }
}
