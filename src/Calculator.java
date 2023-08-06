import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    int resultNum = 0;
    int tempNum;
    String sign;
    String tempNumString = "";
    
    JFrame jFrame = new JFrame();

    JLabel num = new JLabel("");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton equals = new JButton("=");
    JLabel results = new JLabel();

    public Calculator() {
        jFrame.setLocation(950, 50);
        jFrame.setSize(800, 800);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        
        num.setBounds(250, 100, 250, 50);
        one.setBounds(300, 200, 50, 50);
        two.setBounds(400, 200, 50, 50);
        three.setBounds(300, 300, 50, 50);
        four.setBounds(400, 300, 50, 50);
        plus.setBounds(300, 400, 50, 50);
        minus.setBounds(400, 400, 50, 50);
        equals.setBounds(350, 500, 50, 50);
        results.setBounds(325, 600, 100, 50);
        
        num.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        results.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        num.setHorizontalAlignment(SwingConstants.CENTER);
        results.setHorizontalAlignment(SwingConstants.CENTER);

        jFrame.add(num);
        jFrame.add(results);
        jFrame.add(one);
        jFrame.add(two);
        jFrame.add(three);
        jFrame.add(four);
        jFrame.add(plus);
        jFrame.add(minus);
        jFrame.add(equals);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);    
        four.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        equals.addActionListener(this);    
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == one || e.getSource() == two || e.getSource() == three || e.getSource() == four) {
            String button = ((JButton) e.getSource()).getText();
            num.setText(num.getText() + button);

            tempNumString += button;
            tempNum = Integer.parseInt(tempNumString);
        }
        
        if (e.getSource() == plus || e.getSource() == minus) {
            resultNum = tempNum;
            tempNumString = "";

            sign = ((JButton) e.getSource()).getText();
            num.setText(num.getText() + sign);
        }
        
        if (e.getSource() == equals) {
            if (sign.equals("+")) {
                resultNum += tempNum;
            } else if (sign.equals("-")) {
                resultNum -= tempNum;
            }
            results.setText(String.valueOf(resultNum));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
