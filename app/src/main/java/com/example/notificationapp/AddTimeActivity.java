package com.example.notificationapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddTimeActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private EditText e;
    private Button b1,b2;
    private Alarm alarm;
    private boolean boo;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);
        timePicker=findViewById(R.id.ti);
        e=findViewById(R.id.editTextTextPersonName4);
        b1=findViewById(R.id.button9);
        b2=findViewById(R.id.button11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int  hour =timePicker.getCurrentHour();
              int  min =timePicker.getCurrentMinute();
                String name =e.getText().toString().trim();
                DataBaseHelper dataBaseHelper =new DataBaseHelper(getApplicationContext());
                alarm =new Alarm(hour,min,true,name);
                dataBaseHelper.addAlarm(alarm);
                boo=true;
                onBackPressed();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Toast.makeText(getApplicationContext(),"All alarms are turned off",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void finish() {
        Intent intent =new Intent();
        intent.putExtra("needRefresh",boo);
        this.setResult(RESULT_OK,intent);
        super.finish();
    }
}