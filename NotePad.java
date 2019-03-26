
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NotePad extends JFrame implements ActionListener, ChangeListener {

    private Container c;
    private JScrollPane scroll;
    private JTextArea ta;
    private Font f, f2, f3;
    private JMenuBar menubar;
    private JMenu fileMenu, optionMenu, viewMenu, helpMenu, colorMenu, fontMenu, fsize, fcolor;
    private JMenuItem newItm, openItm, saveItm, exitItm, resetItm, deleteItm, Contact_meItm, italicItm, BoldItm, romanItm, redclr, greenclr, blueclr, pinkclr, yellowclr;
    private JCheckBoxMenuItem redItm, greenItm, blueItm, yellowItm, orangeItm, pinkItm;
    private ButtonGroup grp;
    private JSlider fsizeSlider;
    private int font = 18;
    private JFileChooser chooser;
    private ImageIcon icon;
  

    NotePad() {

        initComponents();

    }

    public void initComponents() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 80, 1300, 650);
        this.setTitle("Note Pad");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        
        icon = new ImageIcon(getClass().getResource("image.jpg"));
        this.setIconImage(icon.getImage());

        f = new Font("Arial", Font.PLAIN, 20);
        f2 = new Font("Arial", Font.PLAIN, 16);

        grp = new ButtonGroup();

        ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(f);

        scroll = new JScrollPane(ta);
        scroll.setBounds(-1, -1, 1295, 590);
        c.add(scroll);

        menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        fileMenu = new JMenu("File");
        fileMenu.setFont(f);
        optionMenu = new JMenu("Option");
        optionMenu.setFont(f);
        viewMenu = new JMenu("View");
        viewMenu.setFont(f);
        helpMenu = new JMenu("Help");
        helpMenu.setFont(f);
        colorMenu = new JMenu("BG Colors");
        colorMenu.setFont(f2);
        fontMenu = new JMenu("Font Style");    
        fontMenu.setFont(f2);
        fsize = new JMenu("Font Size");
        fsize.setFont(f2);
        fcolor = new JMenu("Font Color");
        fcolor.setFont(f2);

        menubar.add(fileMenu);
        menubar.add(optionMenu);
        menubar.add(viewMenu);
        menubar.add(helpMenu);

        newItm = new JMenuItem("New");
        newItm.setFont(f2);
        openItm = new JMenuItem("Open");
        openItm.setFont(f2);
        saveItm = new JMenuItem("Save");
        saveItm.setFont(f2);
        exitItm = new JMenuItem("Exit");
        exitItm.setFont(f2);
        resetItm = new JMenuItem("Reset Color");
        resetItm.setFont(f2);
        deleteItm = new JMenuItem("Delete Text");
        deleteItm.setFont(f2);
        Contact_meItm = new JMenuItem("Contact Me");
        Contact_meItm.setFont(f2);
        italicItm = new JMenuItem("Italic");
        italicItm.setFont(f2);
        BoldItm = new JMenuItem("Bold");
        BoldItm.setFont(f2);
        romanItm = new JMenuItem("Roman Line");
        romanItm.setFont(f2);
        redclr = new JMenuItem("Red");
        redclr.setFont(f2);
        greenclr = new JMenuItem("Green");
        greenclr.setFont(f2);
        blueclr = new JMenuItem("Blue");
        blueclr.setFont(f2);
        pinkclr = new JMenuItem("Pink");
        pinkclr.setFont(f2);
        yellowclr = new JMenuItem("Yellow");
        yellowclr.setFont(f2);

        redItm = new JCheckBoxMenuItem("Red");
        redItm.setFont(f2);
        greenItm = new JCheckBoxMenuItem("Green");
        greenItm.setFont(f2);
        blueItm = new JCheckBoxMenuItem("Blue");
        blueItm.setFont(f2);
        yellowItm = new JCheckBoxMenuItem("Yellow");
        yellowItm.setFont(f2);
        orangeItm = new JCheckBoxMenuItem("Orange");
        orangeItm.setFont(f2);
        pinkItm = new JCheckBoxMenuItem("Pink");
        pinkItm.setFont(f2);

        grp.add(redItm);
        grp.add(greenItm);
        grp.add(blueItm);
        grp.add(yellowItm);
        grp.add(orangeItm);
        grp.add(pinkItm);

        colorMenu.add(redItm);
        colorMenu.addSeparator();
        colorMenu.add(greenItm);
        colorMenu.addSeparator();
        colorMenu.add(blueItm);
        colorMenu.addSeparator();
        colorMenu.add(yellowItm);
        colorMenu.addSeparator();
        colorMenu.add(orangeItm);
        colorMenu.addSeparator();
        colorMenu.add(pinkItm);
        helpMenu.add(Contact_meItm);
        fcolor.add(redclr);
        fcolor.addSeparator();
        fcolor.add(greenclr);
        fcolor.addSeparator();
        fcolor.add(blueclr);
        fcolor.addSeparator();
        fcolor.add(pinkclr);
        fcolor.addSeparator();
        fcolor.add(yellowclr);
        viewMenu.add(fcolor);
        viewMenu.addSeparator();

        newItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        exitItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        fileMenu.add(newItm);
        fileMenu.addSeparator();
        fileMenu.add(openItm);
        fileMenu.addSeparator();
        fileMenu.add(saveItm);
        fileMenu.addSeparator();
        fileMenu.add(exitItm);
        optionMenu.add(colorMenu);
        optionMenu.addSeparator();
        optionMenu.add(resetItm);
        optionMenu.addSeparator();
        optionMenu.add(deleteItm);

        fontMenu.add(italicItm);
        fontMenu.addSeparator();
        fontMenu.add(BoldItm);
        fontMenu.addSeparator();
        fontMenu.add(romanItm);

        viewMenu.add(fontMenu);
        viewMenu.addSeparator();
        viewMenu.add(fsize);
        

        fsizeSlider = new JSlider(5, 80, font);
        fsizeSlider.setMinorTickSpacing(2);
        fsizeSlider.setMajorTickSpacing(10);
        fsizeSlider.setPaintTicks(true);
        fsizeSlider.setPaintLabels(true);
        fsize.add(fsizeSlider);

        newItm.addActionListener(this);
        openItm.addActionListener(this);
        saveItm.addActionListener(this);
        exitItm.addActionListener(this);
        redItm.addActionListener(this);
        greenItm.addActionListener(this);
        blueItm.addActionListener(this);
        yellowItm.addActionListener(this);
        orangeItm.addActionListener(this);
        pinkItm.addActionListener(this);
        resetItm.addActionListener(this);
        deleteItm.addActionListener(this);
        Contact_meItm.addActionListener(this);
        italicItm.addActionListener(this);
        BoldItm.addActionListener(this);
        romanItm.addActionListener(this);
        redclr.addActionListener(this);
        greenclr.addActionListener(this);
        blueclr.addActionListener(this);
        pinkclr.addActionListener(this);
        yellowclr.addActionListener(this);
        fsizeSlider.addChangeListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == saveItm) {
            try {
                chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();

                Formatter formatter = new Formatter(file);
                formatter.format("%s", ta.getText());
                formatter.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Exception :" + ex);
            }
        } else if (e.getSource() == openItm) {

            try {
                chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();
                Scanner input = new Scanner(file);
                while (input.hasNext()) {
                    String s = input.nextLine();
                    ta.append(s + " \r\n");

                }
                input.close();
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, "Exception :" + ex);
            }
        } else if (e.getSource() == newItm) {
            dispose();
            JFrame frame = new NotePad();
            frame.setVisible(true);
        } else if (e.getSource() == exitItm) {
            System.exit(0);
        } else if (e.getSource() == redItm) {
            ta.setBackground(Color.RED);
        } else if (e.getSource() == greenItm) {
            ta.setBackground(Color.GREEN);
        } else if (e.getSource() == blueItm) {
            ta.setBackground(Color.BLUE);
        } else if (e.getSource() == yellowItm) {
            ta.setBackground(Color.YELLOW);
        } else if (e.getSource() == orangeItm) {
            ta.setBackground(Color.ORANGE);
        } else if (e.getSource() == pinkItm) {
            ta.setBackground(Color.PINK);
        } else if (e.getSource() == resetItm) {
            ta.setBackground(Color.WHITE);
        } else if (e.getSource() == deleteItm) {
            ta.setText("");

        } else if (e.getSource() == Contact_meItm) {
            JOptionPane.showMessageDialog(null, "Md.Harun Or Rashid #01741551374", "Contact Me", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == italicItm) {
            f3 = new Font("Arial", Font.ITALIC, font);
            ta.setFont(f3);
        } else if (e.getSource() == BoldItm) {

            f3 = new Font("Arial", Font.BOLD, font);
            ta.setFont(f3);
        } else if (e.getSource() == romanItm) {
            f3 = new Font("Arial", Font.ROMAN_BASELINE, font);
            ta.setFont(f3);

        } else if (e.getSource() == redclr) {

            ta.setForeground(Color.RED);
        } else if (e.getSource() == greenclr) {

            ta.setForeground(Color.GREEN);
        } else if (e.getSource() == blueclr) {

            ta.setForeground(Color.BLUE);
        } else if (e.getSource() == pinkclr) {

            ta.setForeground(Color.PINK);
        } else if (e.getSource() == yellowclr) {

            ta.setForeground(Color.YELLOW);
        }

    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        font = fsizeSlider.getValue();
        f3 = new Font("Arial", Font.PLAIN, font);
        ta.setFont(f3);
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch(Exception eu){
            
        } 
        NotePad frame = new NotePad();
        frame.setVisible(true);
       

    }

}
