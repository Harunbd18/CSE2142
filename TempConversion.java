import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TempConversion extends JFrame implements ActionListener{
    private Container c;
    private JLabel labelIn,labelOut,label;
    private JTextField tf1,tf2;
    private JRadioButton celIn,fIn,kIn,celOut,fOut,kOut;
    private ButtonGroup grp1,grp2;
    private JButton btn;
    private Font f;
    private String s1;
    private Double n,n2;
    TempConversion(){
        c = this.getContentPane();
        c.setLayout(null);
        
        f = new Font("Bodoni MT",Font.ITALIC,20);
        
        labelIn = new JLabel("Input Unit",JLabel.CENTER);
        labelIn.setBounds(50,30,100,50);
        labelIn.setOpaque(true);
        labelIn.setBackground(Color.yellow);
        c.add(labelIn);
        
        labelOut = new JLabel("Output Unit",JLabel.CENTER);
        labelOut.setBounds(300,30,100,50);
        labelOut.setOpaque(true);
        labelOut.setBackground(Color.RED);
        c.add(labelOut);
        
        tf1 = new JTextField();
        tf1.setBounds(160,30,130,50);
        c.add(tf1);
        
        tf2 = new JTextField();
        tf2.setBounds(160,90,130,50);
        c.add(tf2);
        
        celIn =  new JRadioButton("Celsius");
        celIn.setBounds(50,90,100,50);
        celIn.setBackground(Color.yellow);
        c.add(celIn);
        
        fIn =  new JRadioButton("Fahrenheit");
        fIn.setBounds(50,150,100,50);
        fIn.setBackground(Color.yellow);
        c.add(fIn);
        
        kIn =  new JRadioButton("Kelvin");
        kIn.setBounds(50,210,100,50);
        kIn.setBackground(Color.yellow);
        c.add(kIn);
        
        celOut =  new JRadioButton("Celsius");
        celOut.setBounds(300,90,100,50);
        celOut.setBackground(Color.RED);
        c.add(celOut);
        
        fOut =  new JRadioButton("Fahrenheit");
        fOut.setBounds(300,150,100,50);
        fOut.setBackground(Color.RED);
        c.add(fOut);
        
        kOut =  new JRadioButton("Kelvin");
        kOut.setBounds(300,210,100,50);
        kOut.setBackground(Color.RED);
        c.add(kOut);
        
        grp1 = new ButtonGroup();
        grp1.add(celIn);
        grp1.add(fIn);
        grp1.add(kIn);
        grp2 = new ButtonGroup();
        grp2.add(celOut);
        grp2.add(fOut);
        grp2.add(kOut);
        
        btn = new JButton("Calculate");
        btn.setBounds(160,270,130,50);
        c.add(btn);
        
        label = new JLabel("Developed By Harun Or Rashid");
        label.setBounds(80,350,280,50);
        label.setFont(f);
        label.setForeground(Color.RED);
        c.add(label);
        
        celIn.addActionListener(this);
        fIn.addActionListener(this);
        kIn.addActionListener(this);
        celOut.addActionListener(this);
        fOut.addActionListener(this);
        kOut.addActionListener(this);
        btn.addActionListener(this);
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        s1 = tf1.getText();
        n = Double.parseDouble(s1);
        }catch(Exception ee){
            tf2.setText("Empty Lebel");
        }
        DecimalFormat ob = new DecimalFormat("0.00");
        if(e.getSource()==btn){
            if(celIn.isSelected()==true && fOut.isSelected()==true){
                n2 = (n*(9/5.0))+32;
                tf2.setText(ob.format(n2)+"");
            }
            else if(celIn.isSelected()==true && kOut.isSelected()==true){
                n2 = n+273.15;
                tf2.setText(ob.format(n2)+"");
            }
            else if(celIn.isSelected()==true && celOut.isSelected()==true){
                
                tf2.setText(ob.format(n)+"");
            }
            else if(fIn.isSelected()==true && celOut.isSelected()==true){
                n2 = (5/9.0)*(n-32);
                tf2.setText(ob.format(n2)+"");
                
            }
            else if(fIn.isSelected()==true && kOut.isSelected()==true){
                n2 = (n-32)*(5/9.0)+273.15;
                tf2.setText(ob.format(n2)+"");
            }
            else if(fIn.isSelected()==true && fOut.isSelected()==true){
                
                tf2.setText(ob.format(n)+"");
            }
            else if(kIn.isSelected()==true && celOut.isSelected()==true){
                n2 = n-273.15;
                tf2.setText(ob.format(n2)+"");
            }
            else if(kIn.isSelected()==true && fOut.isSelected()==true){
                n2 = (n-273.15)*(9/5.0)+32;
                tf2.setText(ob.format(n2)+"");
            }
            else if(kIn.isSelected()==true && kOut.isSelected()==true){
                
                tf2.setText(ob.format(n)+"");
            }
            
        }
         
    }
    
    public static void main(String[] args) {
        TempConversion f = new TempConversion();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100,50,450,450);
        
        
        
        
    }

    
    
}
