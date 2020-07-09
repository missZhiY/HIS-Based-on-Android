package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class in_manage extends Activity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_manage_menu);

        btn1 = findViewById(R.id.in_manage_menu_search);
        btn2 = findViewById(R.id.in_manage_menu_paySearch);
        btn3 = findViewById(R.id.in_manage_menu_ret_btn);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.in_manage_menu_search:
                intent = new Intent(in_manage.this, in_manage_look_patient.class);
                startActivity(intent);
                break;

            case R.id.in_manage_menu_paySearch:
                intent = new Intent(in_manage.this, in_manage_cost_search.class);
                startActivity(intent);
                break;

            case R.id.in_manage_menu_ret_btn:
                intent = new Intent(in_manage.this, MenuActivity.class);
                startActivity(intent);

            default:
                break;
        }
    }
}
