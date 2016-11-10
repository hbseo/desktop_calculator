import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

class MyFrame extends JFrame {
    MyFrame() {
        setTitle("테스트");
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.add(new JButton("1"));
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("3"));
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}
