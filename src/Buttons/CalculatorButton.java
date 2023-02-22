package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modell.*;

public class CalculatorButton extends JButton implements ActionListener{
    Situation situation;

    public void transition(){
        switch(situation.getState()){
            case Input1:

            case Input2:

            case OpReady:

            case HasResult:

        }
    }

    public CalculatorButton(String string, Situation situation){
        super(string);
        this.situation = situation;
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.GRAY);
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        this.addActionListener(this);

    }

    public void setColor(Color color){
        this.setBackground(color);
    }

    @Override
    public String toString(){
        return this.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        transition();
    }
}
