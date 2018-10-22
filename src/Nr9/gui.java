package Nr9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame{

    private JRadioButton nachschüssigRadioButton;
    private JRadioButton vorschüssigRadioButton;
    private JTextField barwertText;
    private JTextField laufzeittext;
    private JButton barwertbutton;
    private JButton berechneLaufzeit;
    private JButton berechneRate;
    private JTextField jahreszinstext;
    private JPanel guiii;
    private JButton tilgung;
    private JTextField ratentext;
    private JComboBox ratenpJBox;
    private ButtonGroup schlussig;
    private JFrame des;

    public void setGUI(JFrame a){
        des = a;

    }

    public static void main(String[] args) {
        gui frame = new gui();
        frame.setGUI(frame);
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
                try {
                    Ratenrechner ratenrechner = new Ratenrechner();
                    ratenrechner.setNachschuessig(nachschüssigRadioButton.isSelected());
                    ratenrechner.setJahreszinssatz(jahreszinstext.getText());
                    ratenrechner.setLaufzeitInJahren(laufzeittext.getText());
                    ratenrechner.setRatenProJahr(ratenpJBox.getSelectedItem()+"");
                    ratenrechner.setRate(ratentext.getText());

                    ratenrechner.berechneBarwert();
                    String s = ratenrechner.getBarwert();
                    barwertText.setText(s);

                }catch (RatenRechnenException a){
                    JOptionPane.showMessageDialog(gui.this, "Nicht alle Daten vohranden", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                }



            }
        });


        berechneRate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Ratenrechner ratenrechner = new Ratenrechner();
                    ratenrechner.setNachschuessig(nachschüssigRadioButton.isSelected());
                    ratenrechner.setBarwert(barwertText.getText());
                    ratenrechner.setJahreszinssatz(jahreszinstext.getText());
                    ratenrechner.setLaufzeitInJahren(laufzeittext.getText());
                    ratenrechner.setRatenProJahr(ratenpJBox.getSelectedItem()+"");

                    ratenrechner.berechneRate();
                    String s = ratenrechner.getRate();
                    ratentext.setText(s);

                }catch (RatenRechnenException a){
                    JOptionPane.showMessageDialog(gui.this, "Nicht alle Daten vohranden", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        berechneLaufzeit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Ratenrechner ratenrechner = new Ratenrechner();
                    ratenrechner.setNachschuessig(nachschüssigRadioButton.isSelected());
                    ratenrechner.setBarwert(barwertText.getText());
                    ratenrechner.setJahreszinssatz(jahreszinstext.getText());
                    ratenrechner.setRatenProJahr(ratenpJBox.getSelectedItem()+"");
                    ratenrechner.setRate(ratentext.getText());

                    ratenrechner.berechneLaufzeit();
                    String s =ratenrechner.getLaufzeitInJahren();
                    laufzeittext.setText(s);
                }catch (RatenRechnenException a){
                    JOptionPane.showMessageDialog(gui.this, "Nicht alle Daten vohranden", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        tilgung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Ratenrechner ratenrechner = new Ratenrechner();
                    ratenrechner.setNachschuessig(nachschüssigRadioButton.isSelected());
                    ratenrechner.setBarwert(barwertText.getText());
                    ratenrechner.setJahreszinssatz(jahreszinstext.getText());
                    ratenrechner.setLaufzeitInJahren(laufzeittext.getText());
                    ratenrechner.setRatenProJahr(ratenpJBox.getSelectedItem()+"");
                    ratenrechner.setRate(ratentext.getText());

                    String ant = ratenrechner.getTilgungsplan();
                    TilgungsGUI gui = new TilgungsGUI(ant, (gui)des);
                }catch (RatenRechnenException a){
                    JOptionPane.showMessageDialog(gui.this, "Nicht alle Daten vohranden", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }



}
