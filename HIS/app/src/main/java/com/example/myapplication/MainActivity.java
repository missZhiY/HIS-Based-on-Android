package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.log_btn);
        btn2 = findViewById(R.id.log_btn_patient);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.log_btn:
                intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                break;

            case R.id.log_btn_patient:
                intent = new Intent(MainActivity.this, patientLogMenu.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}