import javax.swing.*;
import java.awt.*;
import java.util.function.IntBinaryOperator;

import Buttons.*;
import Modell.*;
public class GUI extends JFrame { // Klassen GUI ärver JFrame
    private JPanel canvas;
    private JLabel display;
    private JPanel keyPad;



    public GUI(){ //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Avslutar programmet

        // Skapar en instans av JPanel och sätter den som contentpane
        canvas = new JPanel();
        canvas.setLayout(new GridBagLayout());
        canvas.setSize(1000, 1000);
        setContentPane(canvas);

        // Skapar display som är en instans av JLabel
        display = new JLabel("0");
        display.setFont(new Font("Arial", Font.PLAIN, 40));
        display.setBorder(BorderFactory.createLineBorder(Color.black));
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        // Skapar en instans av siuation som använder display
        Situation situation = new Situation(display);


        GridBagConstraints constraintsDisplay = new GridBagConstraints();
        constraintsDisplay.fill = GridBagConstraints.BOTH;
        constraintsDisplay.weighty = 1;
        constraintsDisplay.weightx = 1;
        constraintsDisplay.gridx = 0;
        constraintsDisplay.gridy = 0;
        constraintsDisplay.gridwidth = 1;
        constraintsDisplay.gridheight = 1;
        canvas.add(display, constraintsDisplay);



        keyPad = new JPanel();
        keyPad.setLayout(new GridLayout(4, 4));
        GridBagConstraints constraintsKeyPad = new GridBagConstraints();
        constraintsKeyPad.fill = GridBagConstraints.BOTH;
        constraintsKeyPad.weighty = 1;
        constraintsKeyPad.weightx = 1;
        constraintsKeyPad.gridx = 0;
        constraintsKeyPad.gridy = 4;
        constraintsKeyPad.gridwidth = 1;
        constraintsKeyPad.gridheight = 4;

        canvas.add(keyPad, constraintsKeyPad);

        // Lägger till alla knappar
        keyPad.add(new DigitButton("7", situation));
        keyPad.add(new DigitButton("8", situation));
        keyPad.add(new DigitButton("9", situation));
        keyPad.add(new BinOpButton("/", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int argument1, int argument2) {
                return argument1/argument2;
            }
        }));
        keyPad.add(new DigitButton("6", situation));
        keyPad.add(new DigitButton("5", situation));
        keyPad.add(new DigitButton("4", situation));
        keyPad.add(new BinOpButton("*", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int argument1, int argument2) {
                return argument1 * argument2;
            }
        }));
        keyPad.add(new DigitButton("3", situation));
        keyPad.add(new DigitButton("2", situation));
        keyPad.add(new DigitButton("1", situation));
        keyPad.add(new BinOpButton("-", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int argument1, int argument2) {
                return argument1 - argument2;
            }
        }));
        keyPad.add(new DigitButton("0", situation));
        keyPad.add(new EqualsButton("=", situation));
        keyPad.add(new CancelButton("C", situation));
        keyPad.add(new BinOpButton("+", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int argument1, int argument2) {
                return argument1 + argument2;
            }
        }));

        pack();
        setVisible(true);
    }
}
