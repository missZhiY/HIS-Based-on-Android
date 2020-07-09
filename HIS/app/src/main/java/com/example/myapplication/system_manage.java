package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class system_manage extends Activity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_menu);

        btn1 = findViewById(R.id.search_his);
        btn2 = findViewById(R.id.system_menu_back);
        btn3 = findViewById(R.id.clear);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_his:
                intent = new Intent(system_manage.this, system_manage_search.class);
                startActivity(intent);
                break;

            case R.id.system_menu_back:
                intent = new Intent(system_manage.this, MenuActivity.class);
                startActivity(intent);
                break;

            case R.id.clear:
                intent = new Intent(system_manage.this, system_manage_clearData.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
