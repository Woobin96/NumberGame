package com.wooeun18.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //뷰들 참조변수 멤버
    EditText et;
    Button btn;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml 객체들을 찾아와서 참조에 대입
        et= findViewById(R.id.et);
        btn= findViewById(R.id.btn);
        tv= findViewById(R.id.tv);

        //사용자가 맞춰야할 정답 숫자를 저장할 변수
        int com;

        //컴뷰터 정답 값  랜덥
        Random rnd= new Random();
        com= rnd.nextInt(501)+ 500; //500-1000

        //버튼이 클릭 되는 것을 듣는 리스너 객체 생성
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText 의 글씨(숫자) 를 얻어오기.
                String s= et.getText().toString();
                //문자열을 숫자로 변환
                int num= Integer.parseInt(s);

                //얻어온 글씨와 정답슷자(com)가 같은지 비교 . 변환 한거랑 비교
                if(num>com){
                    tv.setText(num+"보다 작습니다 .");
                }else if(num<com){
                    tv.setText(num+"보다 큽니다");
                }else{
                    tv.setText("정답입니다.\n 축하합니다.");
                }
                et.setText("");
            }
        };

        //버튼에 리스너객체 설정
        btn.setOnClickListener(listener);




    }
}