import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class GridTest extends JFrame {
    GridTest() {
        setTitle("GridTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4,3,5,5));
        contentPane.add(new JButton("7"));
        contentPane.add(new JButton("8"));
        contentPane.add(new JButton("9"));
        contentPane.add(new JButton("4"));
        contentPane.add(new JButton("5"));
        contentPane.add(new JButton("6"));
        contentPane.add(new JButton("1"));
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("3"));
        contentPane.add(new JButton("0"));
        contentPane.add(new JButton("."));
        setSize(250,350);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GridTest();
    }
}
