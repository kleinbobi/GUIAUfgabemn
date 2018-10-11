package NR7;


import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MeinWebGUI extends JFrame {

    private String webad;
    private boolean ctrl = false;
    private KeyAdapter keyadd;
    private JButton search;
    private JLabel adress;
    private JTextField searchbar;
    private JScrollPane sroll;
    private JEditorPane darstller;
    private String[] history;
    private int momentan =0;
    private JButton back;

    public MeinWebGUI() {
        Font boi = new Font("", Font.BOLD, 17);
        int w = 1500;
        int h = 1000;
        setTitle("Browser");
        setBounds(25, 25, w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        history = new String[100];

        search = new JButton();
        adress = new JLabel();
        searchbar = new JTextField();
        darstller = new JEditorPane();
        sroll = new JScrollPane(darstller);
        back = new JButton();


        search.setBounds(w - 75, 10, 50, 40);
        adress.setBounds(10, 10, 100, 40);
        searchbar.setBounds(w - (w - 100), 10, w - 220, 40);
        sroll.setBounds(0, 60, w, h - 70);
        darstller.setBounds(0, 0, 2 * w, 2 * h);
        back.setBounds(w - (w - 100)+(w-220),10,40,40);

        darstller.setEditable(false);

        webad = "http://www.tfobz.it/";

        try {
            history[momentan]=webad;
            momentan++;
            searchTheWeeb();


        } catch (IOException e) {


            System.exit(0);
        }

        searchbar.setFont(boi);
        adress.setFont(boi);
        search.setFont(new Font("", Font.BOLD, 12));

        adress.setText("Adresse:");

        Container contentPane =
                getContentPane();
        contentPane.setLayout(null);
        contentPane.add(search);
        contentPane.add(adress);
        contentPane.add(searchbar);
        contentPane.add(sroll);
        contentPane.add(back);


        darstller.setContentType("text/html");
        ((HTMLEditorKit) darstller.getEditorKitForContentType("text/html")).setAutoFormSubmission(false);

        search.setText("\uD83D\uDD0D");

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAdd();
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(momentan > 0) {
                    momentan--;
                    System.out.println(momentan);
                    webad = history[momentan];

                    try {
                        searchTheWeeb();
                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(MeinWebGUI.this, "Konnte Seite nicht laden", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        darstller.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    webad = e.getURL() + "";
                    try {
                        searchTheWeeb();
                    }catch (IOException io){
                        JOptionPane.showMessageDialog(MeinWebGUI.this, "Konnte Hyperlink nicht folgen", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

        });


        keyadd = new KeyAdapter();
        darstller.addKeyListener(keyadd);
        searchbar.addKeyListener(keyadd);

        setVisible(true);

    }

    public static void main(String[] args) {

        MeinWebGUI a = new MeinWebGUI();
    }

    /**
     * Fügt falls nötig dem link das https//hinzu
     */
    private void setAdd() {
        webad = searchbar.getText();
        try {
            if (!(((webad.toLowerCase()).substring(0, 7)).equals("http://"))) {
                webad = "http://" + webad;
            }
        } catch (IndexOutOfBoundsException e) {
            webad = "http://" + webad;
        } finally {
            try {

                history[momentan]=webad;
                momentan++;
                System.out.println(momentan);
                searchTheWeeb();
            }catch (IOException io){
                JOptionPane.showMessageDialog(MeinWebGUI.this, "Konnte Link nicht auflösen", "Warnmeldung", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void searchTheWeeb() throws IOException{
        searchbar.setText(webad);
        darstller.setPage(webad);
    }


    private class KeyAdapter extends java.awt.event.KeyAdapter {
        private boolean ctrl = false;

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                ctrl = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S && ctrl) {
                searchbar.requestFocus();
                searchbar.selectAll();
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                setAdd();
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                ctrl = false;

            }


        }


    }


}
