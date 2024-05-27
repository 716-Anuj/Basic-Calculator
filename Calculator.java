import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton decButton, equalButton, delButton, clearButton, negativeButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1, num2, result;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setFont(myFont);
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("del");
        clearButton = new JButton("clr");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }
        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
//        panel.setBackground(Color.PINK);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);



        frame.add(panel);
        frame.add(negativeButton);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
            if(e.getSource() == decButton){
                textField.setText(textField.getText().concat(String.valueOf(".")));
            }
            if(e.getSource() == subtractButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if(e.getSource() == multiplyButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if(e.getSource() == divideButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");

            }
            if(e.getSource() == equalButton){
                num2 = Double.parseDouble(textField.getText());

                switch(operator){
                    case '+':
                        result = num1 + num2;break;
                    case '-':
                        result = num1 - num2;break;
                    case '*':
                        result = num1 * num2;break;
                    case '/':
                        result = num1 / num2;break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if(e.getSource() == clearButton){
                textField.setText("");
            }
            if(e.getSource() == delButton){
                String string = textField.getText();
                textField.setText("");
                for(int i = 0; i < string.length()-1; i++){
                    textField.setText(textField.getText()+string.charAt(i));
                }
            }
            if(e.getSource() == negativeButton){
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        }
}