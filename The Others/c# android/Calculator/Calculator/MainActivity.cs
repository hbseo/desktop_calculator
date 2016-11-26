using Android.App;
using Android.Widget;
using Android.OS;
using System.Text;


namespace Calculator
{
    [Activity(Label = "Calculator", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity
    {
        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            // Get our button from the layout resource,
            // and attach an event to it
            // Button button = FindViewById<Button>(Resource.Id.MyButton);

            // 계산 과정과 결과를 보여주는 텍스트필드 

            EditText txtDisplay = FindViewById<EditText>(Resource.Id.txtDisplay);

            // 버튼 찾기

            Button btn1 = FindViewById<Button>(Resource.Id.btn1);
            Button btn2 = FindViewById<Button>(Resource.Id.btn2);
            Button btn3 = FindViewById<Button>(Resource.Id.btn3);
            Button btn4 = FindViewById<Button>(Resource.Id.btn4);
            Button btn5 = FindViewById<Button>(Resource.Id.btn5);
            Button btn6 = FindViewById<Button>(Resource.Id.btn6);
            Button btn7 = FindViewById<Button>(Resource.Id.btn7);
            Button btn8 = FindViewById<Button>(Resource.Id.btn8);
            Button btn9 = FindViewById<Button>(Resource.Id.btn9);
            Button btn0 = FindViewById<Button>(Resource.Id.btn0);
            Button btnClear = FindViewById<Button>(Resource.Id.btnC);
            Button btnPlus = FindViewById<Button>(Resource.Id.btnPlus);
            Button btnMinus = FindViewById<Button>(Resource.Id.btnMinus);
            Button btnTimes = FindViewById<Button>(Resource.Id.btnTimes);
            Button btnDivide = FindViewById<Button>(Resource.Id.btnDivide);
            Button btnDel = FindViewById<Button>(Resource.Id.btnBack);
            Button btnEqual = FindViewById<Button>(Resource.Id.btnEqual);
            Button btnDot = FindViewById<Button>(Resource.Id.btnDot);

            // 실질적으로 계산을하게되는 ArrayList 비슷한 것?
            // https://msdn.microsoft.com/ko-kr/library/system.text.stringbuilder(v=vs.110).aspx

            StringBuilder strText = new StringBuilder();


            // 버튼 클릭시 이벤트 처리

            // strText 에 Append 해준 값을 txtDisplay 에서 보여줌
            btn1.Click += delegate { txtDisplay.Text = strText.Append(btn1.Text).ToString(); };
            btn2.Click += delegate { txtDisplay.Text = strText.Append(btn2.Text).ToString(); };
            btn3.Click += delegate { txtDisplay.Text = strText.Append(btn3.Text).ToString(); };
            btn4.Click += delegate { txtDisplay.Text = strText.Append(btn4.Text).ToString(); };
            btn5.Click += delegate { txtDisplay.Text = strText.Append(btn5.Text).ToString(); };
            btn6.Click += delegate { txtDisplay.Text = strText.Append(btn6.Text).ToString(); };
            btn7.Click += delegate { txtDisplay.Text = strText.Append(btn7.Text).ToString(); };
            btn8.Click += delegate { txtDisplay.Text = strText.Append(btn8.Text).ToString(); };
            btn9.Click += delegate { txtDisplay.Text = strText.Append(btn9.Text).ToString(); };
            btn0.Click += delegate { txtDisplay.Text = strText.Append(btn0.Text).ToString(); };

            // strText 를 초기화 해주고 txtDisplay 역시 초기화해줌
            btnClear.Click += delegate { strText.Clear(); txtDisplay.Text = ""; };

            // 사칙연산
            btnPlus.Click += delegate { txtDisplay.Text = OperationMethod.operationDisplay(strText, btnPlus.Text, txtDisplay.Text); };
            btnMinus.Click += delegate { txtDisplay.Text = OperationMethod.operationDisplay(strText, btnMinus.Text, txtDisplay.Text); };
            btnTimes.Click += delegate { txtDisplay.Text = OperationMethod.operationDisplay(strText, "*", txtDisplay.Text); };
            btnDivide.Click += delegate { txtDisplay.Text = OperationMethod.operationDisplay(strText, btnDivide.Text, txtDisplay.Text); };

            // 뒤에서부터 하나씩 지움
            btnDel.Click += delegate { txtDisplay.Text = OperationMethod.delete(strText); };

            // = 연산
            btnEqual.Click += delegate{ txtDisplay.Text = OperationMethod.answer(strText); strText.Clear(); };

            // .처리
            btnDot.Click += delegate { txtDisplay.Text = OperationMethod.dot(strText, btnDot.Text); };

        }
    }

}

