package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn1 = findViewById(R.id.menu_btn1);
        btn2 = findViewById(R.id.menu_btn2);
        btn3 = findViewById(R.id.menu_btn3);
        btn4 = findViewById(R.id.menu_btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu_btn1:
                intent = new Intent(MenuActivity.this, add_patient.class);
                startActivity(intent);
                break;

            case R.id.menu_btn2:
                intent = new Intent(MenuActivity.this, in_manage.class);
                startActivity(intent);
                break;

            case R.id.menu_btn3:
                intent = new Intent(MenuActivity.this, out_manage.class);
                startActivity(intent);
                break;

            case R.id.menu_btn4:
                intent = new Intent(MenuActivity.this, system_manage.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
