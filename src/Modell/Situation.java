package Modell;

import Buttons.BinOpButton;

import javax.swing.*;
public class Situation {
    State state = State.Input1;  // Initial state
    JLabel display;
    BinOpButton binaryOperator;
    int leftOperand;

    public Situation(JLabel display){
        this.display = display;
    }
    public JLabel getDisplay(){
        return this.display;
    }
    public void setLeftOperand(int a){
        this.leftOperand = a;
    }
    public BinOpButton getBinOpButton(){
        return this.binaryOperator;
    }
    public State getState(){
        return state;
    }
    public void resetState(){
        this.state = State.Input1;
    }
    public void updateState(State newState){
        this.state = newState;
    }
}
