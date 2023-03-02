package Buttons;

import Modell.Situation;
import Modell.State;

import java.awt.*;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton{  // Ärver CalculatorButton
    private IntBinaryOperator intBinaryOperator;
    public BinOpButton(String string, Situation situation, IntBinaryOperator intBinaryOperator) {
        super(string, situation);
        this.intBinaryOperator = intBinaryOperator;
    }
    //Metoden som använder applyAsInt för att beräkna resultatet av två variabler. Tar emot leftOpperand och displaytext
    public int result(int var1, int var2){
        return intBinaryOperator.applyAsInt(var1, var2);
    }

    @Override
    public void transition() {  // Implementerar den abstrakta metoden transition
        switch(situation.getState()){
            case Input1:
                // Sätter leftOperand till värdet i displayen. Koverterar från string till int
                situation.setLeftOperand(Integer.parseInt(situation.getDisplay().getText()));
                // Färgar operatorknappen röd
                this.setBorder(Color.RED);
                // Sparar knappen som tryckts ner, denna operator används senare
                situation.setBinaryOperator(this);
                // Uppdaterar display ochh tillstånd
                situation.updateState(State.OpReady);
                break;
            // Nollställer display
            case Input2:
                this.setBorder(Color.red);
                situation.getDisplay().setText("0");
                situation.updateState(State.Input2);
                break;
            case OpReady:
                // Återställer färgen på tidigare vald operator
                situation.getBinOpButton().setBorder(Color.GRAY);
                // Sparar vald knapp
                situation.setBinaryOperator(this);
                // Sätter knappens färg till röd
                this.setBorder(Color.RED);
                situation.updateState(State.OpReady);
                break;
            case HasResult:
                // Sätter leftOperand till värdet i displayen
                situation.getBinOpButton().setBorder(Color.GRAY);
                situation.setLeftOperand(Integer.parseInt(situation.getDisplay().getText()));
                situation.setBinaryOperator(this);
                // Färgar operatorknappen röd
                this.setBorder(Color.RED);
                situation.updateState(State.OpReady);
        }
    }
}
