import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// v0.5.1

public class Serious extends JFrame implements ActionListener{
    JPanel panel;
    JFrame frame;
    JButton [] num_btn = new JButton[10];
    JButton Primebtn, MODbtn, AVGbtn, factorialbtn, deletebtn, clearbtn,
            dividebtn, multiplebtn, percentbtn, leftbracketbtn, rightbracketbtn,
            minusbtn, plusbtn, equalbtn, dotbtn;
    JTextField textField, textField2;
    // ArrayList<Integer> number = new ArrayList<Integer>();  		// 숫자 ArrayList.
    // ArrayList<String> operator = new ArrayList<String>();  		// 연산자 ArrayList.
    private String inlabel=""; // =입력 전까지 라벨에 들어 갈 식
    private String su=""; // 현재 입력 중인 숫자
    // private String result=""; // 계산 결과

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
        for (int i=0; i<10; i++)
            num_btn[i] = new JButton(String.valueOf(i));
        Primebtn = new JButton("P");
        MODbtn = new JButton("MOD");
        AVGbtn = new JButton("AVG");
        factorialbtn = new JButton("!");
        deletebtn = new JButton("<-");
        clearbtn = new JButton("C");
        dividebtn = new JButton("/");
        multiplebtn = new JButton("*");
        percentbtn = new JButton("%");
        leftbracketbtn = new JButton("(");
        rightbracketbtn = new JButton(")");
        minusbtn = new JButton("-");
        plusbtn = new JButton("+");
        equalbtn = new JButton("=");
        dotbtn = new JButton(".");

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
        num_btn[0].setBounds(0,420,160,60);
        num_btn[7].setBounds(0,240,80,60);
        num_btn[8].setBounds(80,240,80,60);
        num_btn[9].setBounds(160,240,80,60);
        num_btn[4].setBounds(0,300,80,60);
        num_btn[5].setBounds(80,300,80,60);
        num_btn[6].setBounds(160,300,80,60);
        num_btn[1].setBounds(0,360,80,60);
        num_btn[2].setBounds(80,360,80,60);
        num_btn[3].setBounds(160,360,80,60);

        for (int i=0; i<10; i++)
            panel.add(num_btn[i]);

        dotbtn.setBounds(160,420,80,60);
        equalbtn.setBounds(240,360,80,120);
        plusbtn.setBounds(240,300,80,60);
        minusbtn.setBounds(240,240,80,60);
        percentbtn.setBounds(0,180,80,60);
        leftbracketbtn.setBounds(80,180,80,60);
        rightbracketbtn.setBounds(160,180,80,60);
        multiplebtn.setBounds(240,180,80,60);
        deletebtn.setBounds(0,120,160,60);
        clearbtn.setBounds(160,120,80,60);
        dividebtn.setBounds(240,120,80,60);
        Primebtn.setBounds(0,60,80,60);
        MODbtn.setBounds(80,60,80,60);
        AVGbtn.setBounds(160,60,80,60);
        factorialbtn.setBounds(240,60,80,60);

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
        System.out.println("=> "+str);
        // "P" "MOD" "AVG" "!" "<-" "C"
        if(str!="+" && str!="-" && str!="*" && str!="/" && str!="(" && str!=")" && str!="="){
          // su+=str; //숫자 입력 업데이트
          inlabel+=str;
          System.out.println("=> ");
          textField.setText(inlabel); //라벨에 추가
        }
        else if(str=="+" || str=="-" || str=="*" || str=="/" || str=="(" || str==")"){
          // number.add(Integer.parseInt(su)); //기호를 누르면 지금까지 입력한 수를 어레이리스트에 넣기
          inlabel+=" "+str+" ";
          textField.setText(inlabel); //라벨에 추가
          // su=""; //입력한 수 비우기
          // operator.add(str); //연산자 저장
        }
        else if(str=="="){
          // number.add(Integer.parseInt(su)); //기호를 누르면 지금까지 입력한 수를 어레이리스트에 넣기
//          int sum=0; //총 합
//          for(int i=0;i<number.size();i++)
//            sum=sum+number.get(i); // 숫자 더하기
//          result=sum+"";
          InfixCalc calc = new InfixCalc(inlabel);
          calc.findOrder();
          // System.out.println("=> "+calc.returnResult());
          textField.setText(Double.toString(calc.returnResult())); // 결과 출력하기
          // su="";
          inlabel=""; // 초기화
          // number.clear();
        }
    }
    public static void main(String[] args) {
        new Serious();
    }
}

class InfixCalc{
	private String inputStream;
	//입력받은 수식을 저장
	private Stack<Character> operator = new Stack<Character>();
	//여기는 operator를 저장해줌.(입력된 순서대로)
	private Stack<Double> operand = new Stack<Double>();
	//여기는 operame를 저장(나눗셈 때문에, double형으로 저장하였음. float할까 고민하다가 그냥 더블로 함.)
	private Vector<Integer> list = new Vector<Integer>();
	//list는 *와 /의 연산 순서를 저장한다.
	/*
	 * 예를 들어서
	 * 2 * 3 + 4 / 5 * 6 - 7
	 * 을 입력한다고 했을때 위 vector에는
	 * [0 , 2 , 3]
	 * 이 저장된다. +, - 연산보다 * , / 연산을 먼저 해주기 위해서 저장을 해놓는 것이다.
	 *
	 */
	private double result = 0;
	//값이 저장된다.

	public InfixCalc(){ ; }
	//defaule constructor

	public InfixCalc(String input){
		inputStream = input;
		//생성할 때 같이 입력한 수식을 inputStream에 저장한다.
	}

	public void findOrder(){
		//위의 list vector를 만들고, inputStream에서 operator 와 operand를 나누어 각각 저장해준다.

		StringTokenizer st = new StringTokenizer(inputStream);
		//inputStream을 공백을 기준으로 나누어서 리턴해준다.
		//리턴 형식은 String이기 때문에 operator는 char형으로 변환시켜 저장하고, operand는 double형으로 변경해서 저장한다.

		int countMul = 0; // 곱셈과 나눗셈이 앞에 나온 갯수를 저장한다.
		int totalCount = 0; //현재의 index를 저장하기 위해 사용한다.

		while(st.countTokens() > 1){
			//마지막 연산에서는 operand 하나만 남기 때문에 여기서 입력을 하면 안된다.
			//while문 밖에서 따로 입력
			operand.push(Double.parseDouble(st.nextToken()));
			//operand를 저장함.
			String oper = st.nextToken();
			//operator를 StringTokenizer에서 잘라서 집어넣음.

			char[] tempOpper = oper.toCharArray();
			//입력된 oper를 char형으로 바꿔 저장한다.

			operator.push(tempOpper[0]);
			//operator를 저장한다.

			switch(tempOpper[0])
			{
			case '*':
				list.add(totalCount-countMul);
				countMul++;
				break;
			case '/':
				list.add(totalCount-countMul);
				countMul++;
				break;
			}
			/*
			 * 위의 switch 문은 list를 저장하는 부분이다.
			 * 참고로 알아둬야 할 것은.
			 * * , /연산을 +, - 보다 먼저 계산하여 다시 operand에 저장한다는 것이다.
			 * 예를 들으면,
			 * 2 + 3 * 4 / 8 - 5
			 * 를 예로 들면
			 * 처음 *의 순서로 1 이 list에 저장이 된다.
			 * 그러면 operand를
			 * 2 + 12 / 8 - 5로 바꾸어 준다 이제 /의 index는 1이다. 그러면 list를
			 * 다시
			 * 1로 저장한다. 결국 [1 , 1]이 저장된다.
			 * 나중에 줄어있을 index를 예측하여 저장하는 것이다.
			 * 물론 줄어든 index의 값은 *, / 가 앞에서 등장한 횟수가 된다.
			 * 그래서 totalCount에서 coutMul을 빼서 저장해준다.
			 */

			totalCount++;
		}

		operand.push(Double.parseDouble(st.nextToken()));
		//operand를 저장한다.(마지막 operand - 제대로 입력된 식의 경우 무조건 operand가 operator보다 하나 작기 때문에 이렇게 저장)

		calc();
	}

	private void calc(){
		//직접 연산을 하는 부분.

		int a = list.size();
		int i = 0;
		//while문에서 사용할 변수들.

		//아래의 while문은 *, / 을 연산하는 부분이다.
		while(a > 0){
			int temp = list.get(i); // while문 순서대로 입력되어있는 *와 / 의 index값을 불러온다.

			char tempSaveOperator;
			double[] tempSaveOperand = {0 , 0};
			tempSaveOperator = operator.get(temp);
			tempSaveOperand[0] = operand.get(temp);
			tempSaveOperand[1] = operand.get(temp+1);
			//list에 입력되어 있는 index값을 이용해 operand와 operator를 불러와 저장한다.

			if(tempSaveOperator == '*')
				operand.set(temp, tempSaveOperand[0] * tempSaveOperand[1]);
			else if(tempSaveOperator == '/')
				operand.set(temp, tempSaveOperand[0] / tempSaveOperand[1]);
			//*와 /를 구분해서 각각 연산을 하고, 해당 index에 다시 저장한다.

			operand.remove(temp+1);
			operator.remove(temp);
			//연산이 끝난 operator와 operand를 제거한다.(operand operator의 우측에 있는 operand로 연산이 끝났으므로 필요가 없다.


			i++;
			a--;
		}

		//이제부터 +과 -을 계산한다. operand와 operator의 첫번째 index부터 연산한다.
		//result에 결과를 저장한다.
		int size = operator.size();
		int index = 1;
		result = operand.get(0);
		while(size > 0)
		{

			char tempSaveOperator;
			tempSaveOperator = operator.get(index-1);
			double tempSaveOperand = operand.get(index);
			switch(tempSaveOperator){
			case '+':
				result += tempSaveOperand;
				break;
			case '-':
				result -= tempSaveOperand;
				break;
			}
			size--;
			index++;
		}
	}

	public double returnResult(){
		return result;
	}
}
