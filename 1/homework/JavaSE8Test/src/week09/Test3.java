package week09;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Calculate {
    public double cal(double data1, double data2, String op) {
        // TODO Auto-generated method stub
        double rel = 0;
        switch (op) {
        case "+":
            rel = data1 + data2;
            break;
        case "-":
            rel = data1 - data2;
            break;
        case "*":
            rel = data1 * data2;
            break;
        case "/":
            rel = data1 / data2;
            break;
        default:
            break;
        }
        return rel;
    }
}


public class Test3 extends JFrame implements ActionListener{
 JLabel label1 = new JLabel("第一位操作数");
    JLabel label2 = new JLabel("第二位操作数");
    JLabel label3 = new JLabel("计算结果");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField = new JTextField();
    JButton button1 = new JButton("+");
    JButton button2 = new JButton("-");
    JButton button3 = new JButton("*");
    JButton button4 = new JButton("/");  
//    JButton button = new JButton("计算");
    public Test3() {
        try {
            Init();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    private void Init() throws Exception{
        // TODO Auto-generated method stub
        getContentPane().setLayout(null);
        label1.setBounds(new Rectangle(78, 60, 105, 31));
        label2.setBounds(new Rectangle(80, 146, 87, 32));
        textField1.setBounds(new Rectangle(185, 59, 152, 28));
        textField2.setBounds(new Rectangle(187, 143, 151, 30));
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
//        button.addActionListener(this);
        textField.setEnabled(false);
        textField.setBounds(new Rectangle(189, 196, 150, 30));
        label3.setBounds(new Rectangle(81, 196, 10745, 26));
        button1.setBounds(new Rectangle(113, 111, 44, 23));
        button2.setBounds(new Rectangle(176, 112, 48, 23));
        button3.setBounds(new Rectangle(235, 112, 43, 23));
        button4.setBounds(new Rectangle(295, 110, 38, 24));
//        button.setBounds(new Rectangle(154, 248, 129, 34));
        this.getContentPane().add(label1);
        this.getContentPane().add(label3);
        this.getContentPane().add(textField);
        this.getContentPane().add(label2);
        this.getContentPane().add(textField2);
        this.getContentPane().add(textField1);
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.getContentPane().add(button3);
        this.getContentPane().add(button4);
//        this.getContentPane().add(button);
        this.setTitle("简易计算器");
        this.setVisible(true);
        this.setSize(450, 350);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //获取数据
     String d1 = textField1.getText();
     String d2 = textField2.getText();
        String op = " " ;  //运算符号
        if (e.getActionCommand().equals("+")) {
            op = button1.getText();
        } else if (e.getActionCommand().equals("-")) {
            op = button2.getText();
        } else if (e.getActionCommand().equals("*")) {
            op = button3.getText();
        } else if (e.getActionCommand().equals("/")) {
            op = button4.getText();
        }
        //将数据转换为double类型进行计算
        double data1 = Double.parseDouble(d1);
        double data2 = Double.parseDouble(d2);
        Calculate calculate = new Calculate();
        double result = calculate.cal(data1, data2, op);
        textField.setText(String.valueOf(result));
    }
    public static void main(String[] args) {
        new Test3();
    }
}

