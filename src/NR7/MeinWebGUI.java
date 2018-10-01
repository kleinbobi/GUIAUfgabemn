package NR7;

import javax.swing.*;
import java.awt.*;

public class MeinWebGUI extends JFrame {

    private JButton search;
    private JLabel adress;
    private JTextField searchbar;
    private JScrollBar sroll;
    private JEditorPane darstller;

    public MeinWebGUI(){
        Font boi = new Font("Mono Space",Font.BOLD,16);
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        setTitle("PYEET");
        setBounds(0,0,w,h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        search    = new JButton();
        adress    = new JLabel();
        searchbar = new JTextField();
        sroll     = new JScrollBar();
        darstller = new JEditorPane();

        search.setBounds(w-75,10,40,40);
        adress.setBounds(10,10,100,40);
        adress.setFont(boi);

        adress.setText("Adresse: ");

        Container contentPane =
                getContentPane();
        contentPane.setLayout(null);
        contentPane.add(search);
        contentPane.add(adress);

        setVisible(true);



    }

    public static void main(String[] args){

        MeinWebGUI a = new MeinWebGUI();











    }



}
