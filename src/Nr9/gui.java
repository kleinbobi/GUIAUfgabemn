package Nr9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {

    private JRadioButton nachschüssigRadioButton;
    private JRadioButton vorschüssigRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox textField4;
    private JPasswordField passwordField1;
    private JButton barwertbutton;
    private JButton brechneButton;
    private JButton berechneButton;
    private JTextField textField1;
    private JPanel guiii;
    private ButtonGroup schlussig;

    public static void main(String[] args) {
        JFrame frame = new JFrame("gui");
        frame.setContentPane(new gui().guiii);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(500, 25, 500, 400);
        frame.setVisible(true);
    }

    public gui() {

        barwertbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

}
