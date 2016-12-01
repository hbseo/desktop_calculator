/**
* Calc.java
*스택을 이용하여 중위표현을 후위표현으로 바꾸는 메소드
*후위표기 수식을 스택을 이용한 연산을 수행하는 메소드
* 수식등의 괄호가 맞는지 확인하는 메소드
*/
class Calc {
  //-------------------------------------------------------------------
  //스택을 이용하여 중위표현을 후위표현으로 바꾸는 메소드
  //-------------------------------------------------------------------
    String  postfix(String infixExp) {
        Double value;
        //숫자의 끝임을 알려주는 flag
        //소수점 수식도 처리하기 위해서...
        boolean endOfNumber = false;
        String postfixExp = new String();
        ArrayStack stk = new ArrayStack();
        for(int i = 0; i < infixExp.length(); i++){
            switch(infixExp.charAt(i)){
                //피연산자는 그대로 출력한다.
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    postfixExp = postfixExp.concat(infixExp.charAt(i)+"");
                    endOfNumber = true;
                    break;
                //왼쪽괄호인 경우에는 스택에 push 한다.
                case '(':
                    if(endOfNumber == true){
                        postfixExp = postfixExp.concat(" ");
                        endOfNumber = false;
                    }
                    stk.push(new Character('('));
                    break;
                //우측괄호인 경우 좌괄호가 나올때까지 pop하여 출력하고
                //좌괄호는 pop하여 버린다.
                case ')':
                    if(endOfNumber == true){
                        postfixExp = postfixExp.concat(" ");
                        endOfNumber = false;
                    }
                    while(((Character)stk.peek()).charValue() != '(' )
                        postfixExp = postfixExp.concat(((Character)stk.pop()).toString());
                    Object openParen = stk.pop();
                    break;
                case '+':
                case '-':
                case 'x':
                case '/':
                    if(endOfNumber == true){
                        postfixExp = postfixExp.concat(" ");
                        endOfNumber = false;
                    }
                     //연산자를 만나면 스택에서 그 연산자보다 낮은 우선순위의 연산자를 만날 때까지
                    //팝하여 출력한 뒤에 자신을 푸시한다.(우선순위가 같거나 높은것은 팝한다.)
                    while (!stk.isEmpty() && ((Character)stk.peek()).charValue() != '('
                            &&  getPrec(infixExp.charAt(i)) <= getPrec(((Character)stk.peek()).charValue())){
                        postfixExp = postfixExp.concat(((Character)stk.pop()).toString());
                    }
                    stk.push(new Character(infixExp.charAt(i)));
                    break;
                }
            }
            if(endOfNumber == true){
                postfixExp = postfixExp.concat(" ");
                endOfNumber = false;
            }
      //모든 작업이 끝나면 스택에 있는 연산자들을 모두 팝하여 출력한다.
            while(!stk.isEmpty()){
                postfixExp = postfixExp.concat(((Character)stk.pop()).toString());
            }
            System.out.println(postfixExp);
            return postfixExp;
        }
      //----------------------------------------------------------------------
      //후위표기 수식을 스택을 이용한 연산을 수행하는 메소드
      //----------------------------------------------------------------------
        Double result(String postfixExp){
        System.out.println(postfixExp);
        Double value, buffer;
        String temp = new String();
        ArrayStack stk = new ArrayStack();
        for(int i=0;i<postfixExp.length();i++){
            switch(postfixExp.charAt(i)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    //여기까지는 아직 공백을 만나지 않았으므로 수식의 끝이 아니다.
                    temp = temp.concat(postfixExp.charAt(i)+"");
                    break;
                case ' ':
                    //공백을 만나서야 비로서 수식을 스택에 넣는다.
                    //공백을 만나기전에 수식이 여러개 있었다면 temp에 붙어서 저장되어 있다.
                    stk.push(new Double(temp));
                    temp = new String();
                    break;
                case '+':
                    value = new Double(((Double)stk.pop()).doubleValue() + ((Double)stk.pop()).doubleValue());
                    stk.push(value);
                    break;
                case '-':
                    buffer = new Double(((Double)stk.pop()).doubleValue());
                    value = new Double(((Double)stk.pop()).doubleValue() - buffer.doubleValue());
                    stk.push(value);
                    break;
                case 'x':
                    value = new Double(((Double)stk.pop()).doubleValue() * ((Double)stk.pop()).doubleValue());
                    stk.push(value);
                    break;
                case '/':
                    buffer = new Double(((Double)stk.pop()).doubleValue());
                    value = new Double(((Double)stk.pop()).doubleValue() / buffer.doubleValue());
                    stk.push(value);
                    break;
                }
            }
            return (Double)stk.peek();
        }
      //------------------------------------------
      //연산자의 우선순위를 Return
      //------------------------------------------
        int getPrec(char op) {
        int prec = 0;
        switch (op){
            case '+':
            case '-':
                prec = 1;
                break;
            case 'x':
            case '/':
                prec = 2;
                break;
        }
        return prec;
    }
        //-----------------------------------------
        //괄호의 정확성 검사
     //-----------------------------------------
    static boolean bracketsBalance (String exp) {
        ArrayStack stk = new ArrayStack(exp.length() +1);
        for(int i=0;i<exp.length();i++){
          //Scan across the expression
            char ch = exp.charAt(i);
            if(ch=='['||ch=='('){
                stk.push( new Character(ch));
            }
            else if(ch==']'||ch==')'){
            //empty means brackets unmatched
                if(stk.isEmpty())
                    return false;
                char charFromStack=((Character)stk.pop()).charValue();
                if(ch==']'&&charFromStack!='['||(ch==')'&&charFromStack!='('))
                    return false;
            } // end if
        } // end for loop
        return stk.isEmpty();  //empty means matched,  else unmatched
    }
}
