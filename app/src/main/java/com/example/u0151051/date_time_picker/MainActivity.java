package com.example.u0151051.date_time_picker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText et,et1;
    Button bt,bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewid();
    }
    void findviewid(){
        //我們只是利用EditText顯現不用輸入,所以在xml檔的EditText中加入android:editable="false"讓EditText不能打字
        et=(EditText) findViewById(R.id.editText);
        et1=(EditText) findViewById(R.id.editText2);
        bt=(Button) findViewById(R.id.button);
        bt1=(Button) findViewById(R.id.button2);
        bt.setOnClickListener(c1);
        bt1.setOnClickListener(c2);
    }
    View.OnClickListener c1=new View.OnClickListener() {
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
    View.OnClickListener c2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar calendar=Calendar.getInstance();
            int h=calendar.get(Calendar.HOUR);
            int mm=calendar.get(Calendar.MINUTE);
            //時間選擇對話框 TimePickerDialog(類別,監聽器,int 小時,int分鐘,是否24小時制);
            TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,timeSetListener,h,mm,false);
            timePickerDialog.show();

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
    //時間選擇對話框專用監聽器
    TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            et1.setText( hourOfDay+":"+minute);
        }
    };
}
