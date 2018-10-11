package NR8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class nr8 extends JFrame{

    private EuroUmrechner rech;
    private JLabel[] jLabels;
    private JTextField[] jTextFields;


    private nr8() {
        rech = new EuroUmrechner();


        int w = 600;
        int h = 800;
        setTitle("schware orbet");
        setBounds(500, 25, w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        jLabels = new JLabel[12];
        jTextFields = new JTextField[12];


        Container contentPane =
                getContentPane();
        contentPane.setLayout(null);

        meinKeyDruck key = new meinKeyDruck();


        for(int i = 0 ; i < 12 ; i++){
            jLabels[i] = new JLabel();
            jTextFields[i] = new JTextField();

            jLabels[i].setBounds(10,(h/13)*(i)+10,(int)(w/2.5),h/12);

            jLabels[i].setHorizontalAlignment(SwingConstants.RIGHT);

            jTextFields[i].setBounds((int)(w/2.5)+20,(h/13)*i+10,w-(int)(w/2.5)-30,h/12);
            jTextFields[i].setHorizontalAlignment(SwingConstants.RIGHT);
            jTextFields[i].addKeyListener(key);


            contentPane.add(jLabels[i]);
            contentPane.add(jTextFields[i]);
        }


        jTextFields[0].setText("1.0");
        neurechnen(0,1.0);

        setVisible(true);



    }

    private void neurechnen(int werung,double wert){
        rech.setWaehrung(werung);
        rech.setBetrag(wert);
        for(int i = 0 ; i < 12 ; i++){

                jLabels[i].setText(rech.WAEHRUNGEN[i]);
        if(werung != i)
                jTextFields[i].setText(rech.getBetrag(i) + "");

        }
    }



    public static void main(String args[]) {
        new nr8();



    }



    private class meinKeyDruck extends KeyAdapter{

        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9'||e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                for (int i = 0; i < 12; i++) {
                    if (e.getSource().equals(jTextFields[i])) {

                        try {
                            neurechnen(i, Double.parseDouble(jTextFields[i].getText()));
                            System.out.println(Double.parseDouble(jTextFields[i].getText()));
                        }catch (NumberFormatException t){
                            JOptionPane.showMessageDialog(nr8.this, "Keine Zahl"+jTextFields[i].getText(), "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
    }
}

