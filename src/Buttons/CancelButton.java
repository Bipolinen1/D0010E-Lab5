package Buttons;

import Modell.Situation;

import java.awt.*;
import java.awt.event.ActionEvent;

public class CancelButton extends CalculatorButton{
    @Override
    public void transition() {
        switch (situation.getState()){
            // Nollställer miniräknaren
            case Input1:
                situation.getDisplay().setText("0");
                situation.resetState();
                situation.getBinOpButton().setBorder(Color.GRAY);
                break;
            // Nollställer miniräknaren
            case Input2:
                situation.getDisplay().setText("0");
                situation.resetState();
                situation.getBinOpButton().setBorder(Color.GRAY);
                break;
            // Nollställer miniräknaren
            case OpReady:
                situation.getDisplay().setText("0");
                situation.resetState();
                situation.getBinOpButton().setBorder(Color.GRAY);
                break;
            // Nollställer miniräknaren
            case HasResult:
                situation.getDisplay().setText("0");
                situation.resetState();
                situation.getBinOpButton().setBorder(Color.GRAY);
                break;
        }
    }

    public CancelButton(String c, Situation situation) {
        super(c, situation);
    }

}
