import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class calculator extends JFrame implements ActionListener{

    JPanel panel;
    JButton [] num_btn = new JButton[10];
    JButton Primebtn, MODbtn, AVGbtn, factorialbtn, deletebtn, clearbtn,
        dividebtn, multiplebtn, percentbtn, leftbracketbtn, rightbracketbtn,
        minusbtn, plusbtn, equalbtn, dotbtn;
    JTextField textField, textField2;
    private String first="";


    // 생성자
    public calculator() {
        setTitle("Serious");
        setSize(320, 560);       // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 설정
        setLayout(null);
//        JLayeredPane layeredPane = new JLayeredPane();
//        layeredPane.setBounds(0, 0, 320, 540);
//        layeredPane.setLayout(null);

        // 패널 설정
        panel = new JPanel();
        panel.setLayout(null); //패널의 Layout을 NULL
        panel.setBounds(0, 0, 320, 560); //패널의 크기 및 위치 지정 (x,y로 부터 넓이(width, 높이(height))

        // 텍스트 필드 설정

        textField = new JTextField("");
        textField2 = new JTextField("");

        textField.setHorizontalAlignment(JTextField.RIGHT);   // 우측정렬
        textField.setEditable(false); 		// 텍스트필드창에 텍스트쓰지못하게 잠금

        textField2.setHorizontalAlignment(JTextField.RIGHT);   // 우측정렬
        textField2.setEditable(false); 		// 텍스트필드창에 텍스트쓰지못하게 잠금

        textField.setBounds(0,0,320,60);
        textField2.setBounds(0,60,320,60);

        panel.add(textField);
        panel.add(textField2);

        // 버튼 설정
        for (int i=0; i<10; i++)
            num_btn[i] = new JButton(String.valueOf(i));
        Primebtn = new JButton("P");
        MODbtn = new JButton("MOD");
        AVGbtn = new JButton("AVG");
        factorialbtn = new JButton("!");
        deletebtn = new JButton("<-");
        clearbtn = new JButton("C");
        dividebtn = new JButton("/");
        multiplebtn = new JButton("x");
        percentbtn = new JButton("%");
        leftbracketbtn = new JButton("(");
        rightbracketbtn = new JButton(")");
        minusbtn = new JButton("-");
        plusbtn = new JButton("+");
        equalbtn = new JButton("=");
        dotbtn = new JButton(".");

        // 버튼 배열
        num_btn[0].setBounds(0,480,160,60);
        num_btn[7].setBounds(0,300,80,60);
        num_btn[8].setBounds(80,300,80,60);
        num_btn[9].setBounds(160,300,80,60);
        num_btn[4].setBounds(0,360,80,60);
        num_btn[5].setBounds(80,360,80,60);
        num_btn[6].setBounds(160,360,80,60);
        num_btn[1].setBounds(0,420,80,60);
        num_btn[2].setBounds(80,420,80,60);
        num_btn[3].setBounds(160,420,80,60);

        for (int i=0; i<10; i++)
            panel.add(num_btn[i]);

        dotbtn.setBounds(160,480,80,60);
        equalbtn.setBounds(240,420,80,120);
        plusbtn.setBounds(240,360,80,60);
        minusbtn.setBounds(240,300,80,60);
        percentbtn.setBounds(0,240,80,60);
        leftbracketbtn.setBounds(80,240,80,60);
        rightbracketbtn.setBounds(160,240,80,60);
        multiplebtn.setBounds(240,240,80,60);
        deletebtn.setBounds(0,180,160,60);
        clearbtn.setBounds(160,180,80,60);
        dividebtn.setBounds(240,180,80,60);
        Primebtn.setBounds(0,120,80,60);
        MODbtn.setBounds(80,120,80,60);
        AVGbtn.setBounds(160,120,80,60);
        factorialbtn.setBounds(240,120,80,60);

        //addActionListener 추가
        for (int i=0; i<10; i++)
            num_btn[i].addActionListener(this);
        dotbtn.addActionListener(this);
        equalbtn.addActionListener(this);
        plusbtn.addActionListener(this);
        minusbtn.addActionListener(this);
        percentbtn.addActionListener(this);
        leftbracketbtn.addActionListener(this);
        rightbracketbtn.addActionListener(this);
        multiplebtn.addActionListener(this);
        deletebtn.addActionListener(this);
        clearbtn.addActionListener(this);
        dividebtn.addActionListener(this);
        Primebtn.addActionListener(this);
        MODbtn.addActionListener(this);
        AVGbtn.addActionListener(this);
        factorialbtn.addActionListener(this);

        panel.add(dotbtn);
        panel.add(equalbtn);
        panel.add(plusbtn);
        panel.add(minusbtn);
        panel.add(percentbtn);
        panel.add(leftbracketbtn);
        panel.add(rightbracketbtn);
        panel.add(multiplebtn);
        panel.add(deletebtn);
        panel.add(clearbtn);
        panel.add(dividebtn);
        panel.add(Primebtn);
        panel.add(MODbtn);
        panel.add(AVGbtn);
        panel.add(factorialbtn);

        add(panel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String read;
        String str=e.getActionCommand();
        textField2.setText(first);
        read=textField2.getText();
        first=read+str;
        textField2.setText(first);
    }

    public static void main(String[] args) {
        new calculator();
    }
}
