import javax.swing.*;
import java.awt.*;

class test extends JFrame {
    test() {
        setTitle("스윙 테스트");                                 // 프레임에 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // 프레임 윈도우를 닫으면 프로그램 종료
        Container contentPane = getContentPane();             // 컨텐트 팬을 알아낸다
        contentPane.setBackground(Color.GREEN);                // 배경색을 설정
        contentPane.setLayout(new FlowLayout());              // 컨텐트 팬에 FlowLayout 달기

        contentPane.add(new JButton("1"));                    // 버튼 생성
        contentPane.add(new JButton("2"));                    // 버튼 생성
        contentPane.add(new JButton("3"));                    // 버튼 생성

        setSize(450,200);                                     // 프레임 크기를 450 x 200으로 설정
        setVisible(true);                                     // 프레임을 화면에 출력
    }
    public static void main(String[] args) {
        new test();
    }
}
