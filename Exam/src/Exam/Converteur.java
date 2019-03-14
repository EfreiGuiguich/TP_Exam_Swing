package Exam;

import java.awt.Color;
import static java.awt.Color.BLACK;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Converteur extends JFrame
{
    
    public Converteur (String name)
    {
	setTitle(name);
        construc();       
    }
    
    private void construc() // Construc general
    {
        setSize(420,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(false);
        setResizable(false);
	setContentPane(Contenu());        
                
        this.setVisible(true);
    }
	
    Container Contenu()
    {    
        //Placement
        getContentPane().setLayout(new FlowLayout());
        
        //Espace disponible
	JTextField textNum = new JTextField(5);
        getContentPane().add(textNum);
        textNum.setText("0");
        
        //Text
        JLabel label = new JLabel("Celsius");
	getContentPane().add(label);
        
        //Bouton pour calculer
	JButton convert = new JButton();
        convert.setText("Convert");
        getContentPane().add(convert);
        
        //Emplacement résultat
        JTextField boiteResultat = new JTextField();
        getContentPane().add(boiteResultat);
        boiteResultat.setText("                                            ");
	boiteResultat.setEditable(false);
        boiteResultat.setBackground(Color.green);
        Border bordure = BorderFactory.createLineBorder(BLACK, 1);
	boiteResultat.setBorder(bordure);
        
        //Text
        JLabel label2 = new JLabel("Fahrenheit");
	getContentPane().add(label2);
        
        //Action du bouton
	convert.addActionListener(new ActionListener() 
	{
            public void actionPerformed(ActionEvent e)
            {
                String name;
                double n = -1;

                name = textNum.getText();
                n = Double.parseDouble(name); // Passer de String à Int

                double resultatDouble = conv(n);
                String resultatString = String.valueOf(resultatDouble); // Passer de Int à String
                    
                boiteResultat.setText(" " + resultatString + " "); // Mise à jour du résultat                            
            }
            
	});
        return getContentPane();
    }
    
    //Fonction Convert C-> F
    public double conv (double n)
    {
	double x =0;
        x = n*9/5+32;
	return x;
    }
}
