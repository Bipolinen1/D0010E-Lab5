package Buttons;

import Modell.Situation;
import Modell.State;

import java.awt.*;

public class EqualsButton extends CalculatorButton{  // Ärver CalculatorButton
    // Implementerar den abstrakta metoden transition, består av ett switch case
    @Override
    public void transition() {
        switch(situation.getState()){
            // Inget händer
            case Input1:
                situation.updateState(State.Input1);
                break;
            // Nollställer färg på knappen, sätter displayen till resultatet och uppdaterar tillståndet
            case Input2:
                situation.getBinOpButton().setBorder(Color.GRAY);
                situation.getDisplay().setText(Integer.toString(situation.getBinOpButton().result(situation.getLeftOperand(),
                        Integer.parseInt(situation.getDisplay().getText()))));
                situation.updateState(State.HasResult);
                break;
            // Inget händer
            case OpReady:
                situation.updateState(State.OpReady);
                break;
            // Inget händer
            case HasResult:
                situation.updateState(State.HasResult);
                break;
        }
    }

    public EqualsButton(String string, Situation situation) {
        super(string, situation);
    }
}
