import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class calc  implements ActionListener{
    JFrame frame;
    JTextField textField;
    JPanel panel1;
    JPanel panelNorth;
    GridLayout grid;
    JButton JBu;
    String[] strGrid={"7","8","9","4","5","6","1","2","3","0","."};
    private String first="";

    public calc(){
        frame=new JFrame("계산기");
        panel1=new JPanel();
        panelNorth=new JPanel();
        textField=new JTextField("0");
    }
    public void gui(){
        // KeyStroke keystroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        // textField.registerKeyboardAction(, keystroke, JComponent.WHEN_FOCUSED);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        panelNorth.setLayout(new BorderLayout());
        panelNorth.add(BorderLayout.CENTER,textField);
        panel1.setLayout(new GridLayout(4,3,6,6));

        for(int i=0; i<strGrid.length; i++){
            JBu=new JButton(strGrid[i]);
            JBu.addActionListener(this);
            JBu.setBackground(new Color( 241,244,249));
            panel1.add(JBu);
        }
        frame.add(BorderLayout.NORTH,panelNorth);
        frame.add(BorderLayout.CENTER,panel1);
        frame.setResizable(false);
        frame.setSize(220,310);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        String read;
        String str=e.getActionCommand();
        textField.setText(first);
        textField.getText();
        read=textField.getText();
        first=read+str;
        textField.setText(first);
        textField.getText();
    }

    public static void main(String[] args){
        calc cal=new calc();
        cal.gui();
    }
}


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.*;
//
// class calc implements ActionListener{
//   JFrame frame;
//   JPanel panel1;
//   JPanel panelNorth;
//   JButton JBu;
//   JTextField textField;
//   private String first="";
//   String[] strGrid={"7","8","9","4","5","6","1","2","3","0","."};
//   // Container contentPane = getContentPane();
//   // contentPane.setLayout(null);
//
//   public clac(){
//     frame=new JFrame("계산기");
//     panel1=new JPanel();
//     panelNorth=new JPanel();
//     textField=new JTextField("0");
//   }
//   public void gui(){
//     panelNorth.add(BorderLayout.NORTH,textField);
//     textField.setHorizontalAlignment(JTextField.RIGHT);
//     panel1.setLayout(new GridLayout(4,3,6,6));
//     panel1.setBackground(new Color(222,232,244));
//     textField.setEditable(false);
//     textField.getText();
//     // JButton Button1 = new JButton("1");
//     // JButton Button2 = new JButton("2");
//     // JButton Button3 = new JButton("3");
//     // JButton Button4 = new JButton("4");
//     // JButton Button5 = new JButton("5");
//     // JButton Button6 = new JButton("6");
//     // JButton Button7 = new JButton("7");
//     // JButton Button8 = new JButton("8");
//     // JButton Button9 = new JButton("9");
//     // JButton Button0 = new JButton("0");
//     // JButton Button_dot = new JButton(".");
//     // Button7.setBounds(5,5,75,75);
//     // Button8.setBounds(80,5,75,75);
//     // Button9.setBounds(155,5,75,75);
//     // Button4.setBounds(5,80,75,75);
//     // Button5.setBounds(80,80,75,75);
//     // Button6.setBounds(155,80,75,75);
//     // Button1.setBounds(5,155,75,75);
//     // Button2.setBounds(80,155,75,75);
//     // Button3.setBounds(155,155,75,75);
//     // Button0.setBounds(5,230,150,75);
//     // Button_dot.setBounds(155,230,75,75);
//     // contentPane.add(Button7);
//     // contentPane.add(Button8);
//     // contentPane.add(Button9);
//     // contentPane.add(Button4);
//     // contentPane.add(Button5);
//     // contentPane.add(Button6);
//     // contentPane.add(Button1);
//     // contentPane.add(Button2);
//     // contentPane.add(Button3);
//     // contentPane.add(Button0);
//     // contentPane.add(Button_dot);
//     for(int i=0; i<11; i++){
//       JBu=new JButton(strGrid[i]);
//       JBu.addActionListener(this);
//       JBu.setBackground(new Color(241,244,249));    // 버튼 집어넣기
//       panel1.add(JBu);
//     }
//     frame.setTitle("Hotkey");
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.add(BorderLayout.NORTH,panelNorth);
//     frame.add(BorderLayout.CENTER,panel1);
//     frame.setResizable(false);                                  //창 크기 변경 못하게 막는다.
//     frame.setSize(220,310);                                    //frame 의 크기
//     frame.setVisible(true);
//   }
//   public void actionPerformed(ActionEvent e){
//     String str=e.getActionCommand();
//     System.out.println(str);
//     textField.setText(first);
//     textField.getText();
//   }
//   public static void main(String[] args) {
//     calc cal=new calc();
//     cal.gui();
//   }
// }
