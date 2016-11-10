import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class GridTest extends JFrame {
    GridTest() {
        setTitle("GridTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        JButton Button1 = new JButton("1");
        JButton Button2 = new JButton("2");
        JButton Button3 = new JButton("3");
        JButton Button4 = new JButton("4");
        JButton Button5 = new JButton("5");
        JButton Button6 = new JButton("6");
        JButton Button7 = new JButton("7");
        JButton Button8 = new JButton("8");
        JButton Button9 = new JButton("9");
        JButton Button0 = new JButton("0");
        JButton Button_dot = new JButton(".");
        Button7.setBounds(5,5,75,75);
        Button8.setBounds(80,5,75,75);
        Button9.setBounds(155,5,75,75);
        Button4.setBounds(5,80,75,75);
        Button5.setBounds(80,80,75,75);
        Button6.setBounds(155,80,75,75);
        Button1.setBounds(5,155,75,75);
        Button2.setBounds(80,155,75,75);
        Button3.setBounds(155,155,75,75);
        Button0.setBounds(5,230,150,75);
        Button_dot.setBounds(155,230,75,75);
        contentPane.add(Button7);
        contentPane.add(Button8);
        contentPane.add(Button9);
        contentPane.add(Button4);
        contentPane.add(Button5);
        contentPane.add(Button6);
        contentPane.add(Button1);
        contentPane.add(Button2);
        contentPane.add(Button3);
        contentPane.add(Button0);
        contentPane.add(Button_dot);
        setSize(250,350);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GridTest();
    }
}
