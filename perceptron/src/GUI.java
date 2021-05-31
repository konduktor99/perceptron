import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JLabel jl;
    JTextField jtf;
    JButton jb;
    public GUI(Perceptron percepek){


        setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        jl= new JLabel("Podaj cechy kwiatu który chcesz sprawdzić");
        jl.setForeground(Color.ORANGE);
        jl.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        jb=new JButton("SPRAWDŹ");
        jb.setBackground(Color.BLACK);
        jb.setForeground(Color.ORANGE);
        jtf=new JTextField(20);
        jtf.setFont(new Font("Arial", Font.HANGING_BASELINE, 12));
        jtf.setBackground(Color.black);
        jtf.setForeground(Color.ORANGE);


        jb.addActionListener(e-> {
           System.out.println( percepek.sprwdzJeden(jtf.getText()) );
            JOptionPane.showMessageDialog(this,"Prawdopodobny gatunek:\n"+ percepek.sprwdzJeden(jtf.getText()));

        });

        this.add(jl);
        this.add(jb);
        this.add(jtf);
        setSize(300,150);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);


    }

}


