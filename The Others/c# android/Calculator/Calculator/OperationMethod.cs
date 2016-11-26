using System.Text;
using Jace; // 31 번줄 설명

namespace Calculator
{
    static class OperationMethod
    {

        // 계산을 하는 메서드 

        public static string answer(StringBuilder text)
        {
            double result = 0.00;

            // Substring(n) - n번 위치부터 끝까지

            if (!text.ToString().Substring(0).Equals("."))
            {
                if (text.Length != 0)
                {   

                    //  제일 뒤에 있는것이 연산자인지 검사

                    if ((text.ToString().Substring(text.Length - 1)).Equals("+") || (text.ToString().Substring(text.Length - 1)).Equals("-") || (text.ToString().Substring(text.Length - 1)).Equals("*") || (text.ToString().Substring(text.Length - 1)).Equals("/"))
                    {
                        text.Length -= 1;
                    }
                    else
                    {
                        // Visual studio 기준 
                        // 도구 - NutGet 패키지 관리자 - 패키지 관리자 콘솔
                        // Install-Package Jace 입력
                        // https://www.nuget.org/packages/Jace

                        CalculationEngine engine = new CalculationEngine();
                        result = engine.Calculate(text.ToString());
                    }
                }
            }
            else
            {
                text.Clear();
                text.Append("0.0");
            }

            return result.ToString();
        }

        // 뒤에서부터 하나씩 지워주는 메서드

        public static string delete(StringBuilder text)
        {
            if (text.Length != 0)
            {
                text.Length -= 1;
            }

            return text.ToString();
        }

        // 점을 찍어주는 메서드
        // 앞에 점이 이미 찍혀있으면 뒤에 점을 못찍음
        // ex) 12.5 + 상태로 2.5를 누르려하면 .이 안찍힘

        public static string dot(StringBuilder text, string btnText)
        {
            if (!text.ToString().Contains("."))
                if (text.ToString() == string.Empty)
                    text.Append("0.");
                else
                    text.Append(".");

            return text.ToString();
        }

        // 연산자 뒤에 붙여주는 메서드

        public static string operationDisplay(StringBuilder text, string btnText, string txtDisplay)
        {
            // IsNullOrEmpty(value) -  매개 변수 value가 null 이거나 빈 문자열("")이면 true 이고, 그렇지 않으면 false입니다.
            // https://msdn.microsoft.com/ko-kr/library/system.string.isnullorempty(v=vs.110).aspx
            if (!string.IsNullOrEmpty(txtDisplay))
            {
                // 숫자뒤에 연산자가 있는상태로 또 연산자를 누를시 연산자만 바뀌도록 텍스트를 한번 지워줌
                // ex) text.Clear(); 가 없는 상태로 5 + 에서 - 를 누르면 5 + 5 - 로 출력이됨
                // ex) text.Clear(); 가 있으면 5 + 에서 - 를 누르면 5 - 로 출력
                text.Clear();
                text.Append(txtDisplay);
            }

            if (text.Length == 0)
                text.Append("0");

            // 마지막 텍스트가 연산자일경우 그 연산자를 지워줌
            else if ((text.ToString().Substring(text.Length - 1)).Equals("+") || (text.ToString().Substring(text.Length - 1)).Equals("-") || (text.ToString().Substring(text.Length - 1)).Equals("*") || (text.ToString().Substring(text.Length - 1)).Equals("/"))
                text.Length -= 1;


            return text.Append(btnText).ToString();
        }
    }
}
