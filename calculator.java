/**
 * Created by HB on 2016. 11. 13..
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class calculator extends JFrame {

    JPanel panel;
    JButton [] num_btn = new JButton[10];
    JButton Primebtn, MODbtn, AVGbtn, factorialbtn, deletebtn, clearbtn,
        dividebtn, multiplebtn, percentbtn, leftbracketbtn, rightbracketbtn,
        minusbtn, plusbtn, equalbtn, dotbtn;

    // 생성자
    public calculator() {
        setTitle("Serious");
        setSize(320, 540);       // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 설정
        setLayout(null);
//        JLayeredPane layeredPane = new JLayeredPane();
//        layeredPane.setBounds(0, 0, 320, 540);
//        layeredPane.setLayout(null);

        // 패널 설정
        panel = new JPanel();
        panel.setLayout(null); //패널의 Layout을 NULL
        panel.setBounds(0, 0, 320, 540); //패널의 크기 및 위치 지정 (x,y로 부터 넓이(width, 높이(height))




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
        num_btn[0].setBounds(0,0,160,60);
        for (int i = 1; i < 4; i++) {
            int x=0,y=60;
            for (int j = 0; j < 3; j++) {
                num_btn[i+j].setBounds(x,y,80,60);
                x += 80;
            }
            y += 60;
        }

        for (int i=0; i<10; i++)
            panel.add(num_btn[i]);

        dotbtn.setBounds(160,0,80,60);
        equalbtn.setBounds(240,0,80,120);
        plusbtn.setBounds(240,120,80,60);
        minusbtn.setBounds(240,180,80,60);
        percentbtn.setBounds(0,240,80,60);
        leftbracketbtn.setBounds(80,240,80,60);
        rightbracketbtn.setBounds(160,240,80,60);
        multiplebtn.setBounds(240,240,80,60);
        deletebtn.setBounds(0,300,160,60);
        clearbtn.setBounds(160,300,80,60);
        dividebtn.setBounds(240,300,80,60);
        Primebtn.setBounds(0,360,80,60);
        MODbtn.setBounds(80,360,80,60);
        AVGbtn.setBounds(160,360,80,60);
        factorialbtn.setBounds(240,360,80,60);

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



    public static void main(String[] args) {
        new calculator();
    }
}