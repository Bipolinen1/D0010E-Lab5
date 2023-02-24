package Modell;

import Buttons.BinOpButton;

import javax.swing.JLabel;
public class Situation {
    State state = State.Input1;  // Sätter begynnelsestadiet till Input1
    JLabel display;
    BinOpButton binaryOperator;
    int leftOperand;

    // Konstruktor som tar display som en variabel
    public Situation(JLabel display){
        this.display = display;
    }

    // Returnerar displayen
    public JLabel getDisplay(){
        return this.display;
    }

    // Sätter leftOperand till en int
    public void setLeftOperand(int a){
        this.leftOperand = a;
    }
    public int getLeftOperand(){
        return this.leftOperand;
    }

    // Sätter binaryOperator till en given BinOpButton
    public void setBinaryOperator(BinOpButton binaryOperator){
        this.binaryOperator = binaryOperator;
    }

    // Returnerar knapp som sparats som binaryOperator
    public BinOpButton getBinOpButton(){
        return binaryOperator;
    }

    // Returnerar nuvarande tillstånd
    public State getState(){
        return state;
    }

    // Återställer tillståndet till Input1
    public void resetState(){
        this.state = State.Input1;
    }

    // Uppdaterar tillståndet till givet nytt tillstånd
    public void updateState(State newState){
        this.state = newState;
    }

}
