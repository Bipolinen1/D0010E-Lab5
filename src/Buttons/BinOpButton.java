package Buttons;

import Modell.Situation;
import Modell.State;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton{
    private IntBinaryOperator intBinaryOperator;
    public BinOpButton(String string, Situation situation, IntBinaryOperator intBinaryOperator) {
        super(string, situation);
        this.intBinaryOperator = intBinaryOperator;
    }
    public void applyAsInt(){

    }
}
