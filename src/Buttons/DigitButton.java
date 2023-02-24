package Buttons;

import Modell.Situation;
import Modell.State;

import java.awt.*;

public class DigitButton extends CalculatorButton{ // DigitButton ärver CalculatorButton
    @Override
    public void transition() {  // Implementerar den abstrakta medtoden transition
        // Transistion innehåller en switch som tar emot nuvarande stadie utför det som ska göras
        switch(situation.getState()){
            // Uppdaterar display och lägger till siffror
            case Input1:
                if(situation.getDisplay().getText() == "0"){
                    situation.getDisplay().setText(this.toString());
                }
                else{
                    situation.getDisplay().setText(situation.getDisplay().getText() + this.toString());}
                situation.updateState(State.Input1);
                break;
            // Uppdaterar display och lägger till siffror
            case Input2:
                situation.getBinOpButton().setBorder(Color.gray);
                if(situation.getDisplay().getText() == "0"){
                    situation.getDisplay().setText(this.toString());
                }
                else{
                    situation.getDisplay().setText(situation.getDisplay().getText() + this.toString());}
                situation.updateState(State.Input2);
                break;
            // Byter tillstånd och sätter display till intryckt knapp
            case OpReady:
                situation.getDisplay().setText(this.toString());
                situation.getBinOpButton().setBorder(Color.gray);
                situation.updateState(State.Input2);
                break;
            // Sätter display till värdet på intryckt knapp och byter tillstånd
            case HasResult:
                situation.getDisplay().setText(this.toString());
                situation.updateState(State.Input1);
                break;
        }
    }

    public DigitButton(String string, Situation situation) {
        super(string, situation);
    }
}
