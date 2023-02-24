package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modell.*;

// Ärver JButton och implementerar ActionListener
public abstract class CalculatorButton extends JButton implements ActionListener{
    Situation situation;

    public abstract void transition(); // Skapar den abstrakta metoden transition

    public CalculatorButton(String string, Situation situation){
        super(string);
        this.situation = situation;
        // Sätter storleken på knapparna
        this.setPreferredSize(new Dimension(100, 100));
        // Färgar knapparna grå
        this.setBackground(Color.GRAY);
        // Sätter typsnitt
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        this.addActionListener(this);

    }

    // Används för att ändra färg på knappar
    public void setColor(Color color){
        this.setBackground(color);
    }

    // Ändrar färgern runt knapparna
    public void setBorder(Color color){
        setBorder(BorderFactory.createLineBorder(color));
    }

    // Returnerar texten på knapparna
    @Override
    public String toString(){
        return this.getText();
    }

    // Kallar transition när en knapp tryckts ner
    @Override
    public void actionPerformed(ActionEvent e) {
        transition();
    }

}
