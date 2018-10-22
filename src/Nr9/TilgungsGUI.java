package Nr9;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class TilgungsGUI extends JDialog {


    public TilgungsGUI(String ant,gui a){
        super(a);
        if(ant.equals("")){
            dispose();
            return;
        }
        setModal(true);

        setTitle("Tilgungspaln");
        setBounds(25, 25, 700, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setResizable(false);

        JEditorPane darstller = new JEditorPane();
        JScrollPane sroll = new JScrollPane(darstller);
        JButton butt = new JButton();

        darstller.setEditable(false);

        Container contentPane =
                getContentPane();
        contentPane.setLayout(null);
        contentPane.add(sroll);
        contentPane.add(butt);

        sroll.setBounds(5,5,700,800);
        darstller.setBounds(0, 0, 700, 800);
        butt.setBounds(500,810,125,50);

        butt.setText("Speichern");

        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFileChooser chooser = new JFileChooser();

                int rueckgabeWert = chooser.showOpenDialog(null);


                if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
                {
                    if(chooser.getSelectedFile().exists()) {
                        int i = JOptionPane.showConfirmDialog(TilgungsGUI.this, "Datei Überschreiben?", "Warnmeldung", JOptionPane.OK_CANCEL_OPTION);
                        if(i == JOptionPane.OK_OPTION){
                            try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".html")) {
                                fw.write(ant);
                            }catch (IOException e){

                            }
                        }
                    } else {
                        try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".html")) {
                           fw.write(ant);
                         }catch (IOException e){

                        }

                    }
                }
            }
        });

        darstller.setContentType("text/html");
        darstller.setText(ant);
        darstller.setCaretPosition(1);
        setVisible(true);
    }





}
