package com.example.u0151051.date_time_picker;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewid();
    }
    void findviewid(){
        //我們只是利用EditText顯現不用輸入,所以在xml檔的EditText中加入android:editable="false"讓EditText不能打字
        et=(EditText) findViewById(R.id.editText);
        bt=(Button) findViewById(R.id.button);
        bt.setOnClickListener(c);
    }
    View.OnClickListener c=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 我們用Calendar取得年月日,但Calendar是系統等級,不能用new
            Calendar calendar=Calendar.getInstance();
            int y=calendar.get(Calendar.YEAR);
            int m=calendar.get(Calendar.MONTH);
            int d=calendar.get(Calendar.DATE);
            //日期選擇對話框DatePickerDialog(類別,監聽器,int 年,int月,int日);
            DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,dateSetListener,y,m,d);
            datePickerDialog.show();
        }
    };
    //日期選擇對話框專用監聽器
    DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //人類的世界如果是10月2號(1~12月)那java世界就是9月25號(0~11月)所以月份要加一
            et.setText(year+"/"+(month+1)+"/"+dayOfMonth);
        }
    };
}
