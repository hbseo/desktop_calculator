import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// v0.5.1

public class Serious extends JFrame implements ActionListener{
    JPanel panel;
    JFrame frame;
    JButton [] btn = new JButton[22];
    String[] btn_str = {"0","1","2","3","4","5","6","7","8","9","P","MOD",
                        "AVG","!","<-","C","/","*","%","(",")","-","+","=","."};
    // JButton [] num_btn = new JButton[10];
    // JButton Primebtn, MODbtn, AVGbtn, factorialbtn, deletebtn, clearbtn,
            // dividebtn, multiplebtn, percentbtn, leftbracketbtn, rightbracketbtn,
            // minusbtn, plusbtn, equalbtn, dotbtn;
    JTextField textField, textField2;
    ArrayList<JButton> button = new ArrayList<JButton>(); // Button ArrayList.
    ArrayList<Integer> number = new ArrayList<Integer>(); // 숫자 ArrayList.
    ArrayList<String> operator = new ArrayList<String>(); // 연산자 ArrayList.
    private String inlabel=""; // =입력 전까지 라벨에 들어 갈 식
    private String su=""; // 현재 입력 중인 숫자
    private String result=""; // 계산 결과

    // 생성자
    public Serious() {
        setTitle("Serious");
        setSize(320, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 레이아웃 설정
        setLayout(null);

        // 패널 설정
        panel = new JPanel();
        panel.setLayout(null); //패널의 Layout을 NULL
        panel.setBounds(0, 0, 320, 500); //패널의 크기 및 위치 지정 (x,y로 부터 넓이(width, 높이(height))

        // 텍스트 필드 설정
        textField = new JTextField("");
        textField.setHorizontalAlignment(JTextField.RIGHT);   // 우측정렬
        textField.setEditable(false); 		// 텍스트필드창에 텍스트쓰지못하게 잠금
        textField.setBounds(0,0,320,60);
        panel.add(textField);

        // 버튼 설정
        for (int i=0; i<22; i++)
            btn[i] = new JButton(btn_str[i]);

        //버튼 글씨색
        for (int i=0; i<10; i++)
            num_btn[i].setForeground(Color.BLACK);
        dotbtn.setForeground(Color.BLACK);
        leftbracketbtn.setForeground(Color.BLACK);
        rightbracketbtn.setForeground(Color.BLACK);
        percentbtn.setForeground(Color.BLACK);
        deletebtn.setForeground(Color.BLACK);
        clearbtn.setForeground(Color.RED);

        equalbtn.setForeground(Color.BLUE);
        plusbtn.setForeground(Color.BLUE);
        minusbtn.setForeground(Color.BLUE);
        multiplebtn.setForeground(Color.BLUE);
        dividebtn.setForeground(Color.BLUE);

        Color orange = new Color(255, 153, 000);

        Primebtn.setForeground(orange);
        MODbtn.setForeground(orange);
        AVGbtn.setForeground(orange);
        factorialbtn.setForeground(orange);

        // 버튼 배열
        for(int i=360;i>=240;i-=60){ //360, 300, 240
          for(int j=0;j<=160;j+=80){ //0, 80, 160
            btn[(j/80)*3+(2-(i-240)/60)+1].setBounts(j,i,80,60);
          }
        }
        // num_btn[7].setBounds(0,240,80,60);
        // num_btn[8].setBounds(80,240,80,60);
        // num_btn[9].setBounds(160,240,80,60);
        // num_btn[4].setBounds(0,300,80,60);
        // num_btn[5].setBounds(80,300,80,60);
        // num_btn[6].setBounds(160,300,80,60);
        // num_btn[1].setBounds(0,360,80,60);
        // num_btn[2].setBounds(80,360,80,60);
        // num_btn[3].setBounds(160,360,80,60);

        for (int i=0; i<10; i++)
            panel.add(num_btn[i]);
        num_btn[0].setBounds(0,420,160,60);
        Primebtn.setBounds(0,60,80,60);
        MODbtn.setBounds(80,60,80,60);
        AVGbtn.setBounds(160,60,80,60);
        factorialbtn.setBounds(240,60,80,60);
        deletebtn.setBounds(0,120,160,60);
        clearbtn.setBounds(160,120,80,60);
        dividebtn.setBounds(240,120,80,60);
        multiplebtn.setBounds(240,180,80,60);
        percentbtn.setBounds(0,180,80,60);
        leftbracketbtn.setBounds(80,180,80,60);
        rightbracketbtn.setBounds(160,180,80,60);
        minusbtn.setBounds(240,240,80,60);
        plusbtn.setBounds(240,300,80,60);
        dotbtn.setBounds(160,420,80,60);
        equalbtn.setBounds(240,360,80,120);




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
        String str=e.getActionCommand();
        if(str!="+" && str!="="){
          su+=str; //숫자 입력 업데이트
          inlabel+=str;
          textField.setText(inlabel); //라벨에 추가
        }
        if(str=="+"){
          number.add(Integer.parseInt(su)); //기호를 누르면 지금까지 입력한 수를 어레이리스트에 넣기
          inlabel+=str;
          textField.setText(inlabel); //라벨에 추가
          su=""; //입력한 수 비우기
          operator.add(str); //연산자 저장
        }
        if(str=="="){
          number.add(Integer.parseInt(su)); //기호를 누르면 지금까지 입력한 수를 어레이리스트에 넣기
          int sum=0; //총 합
          for(int i=0;i<number.size();i++)
            sum=sum+number.get(i); // 숫자 더하기
          result=sum+"";
          textField.setText(result); // 결과 출력하기
          su=""; inlabel=""; number.clear(); // 초기화
        }
    }
    public static void main(String[] args) {
        new Serious();
    }
}
