package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class patientLogMenu extends Activity implements View.OnClickListener{
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_log);

        btn1 = findViewById(R.id.patientLog_search_his);
        btn2 = findViewById(R.id.patientLog_search);
        btn3 = findViewById(R.id.patientLog_back);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.patientLog_search_his:
                intent = new Intent(patientLogMenu.this, patient_search.class);
                startActivity(intent);
                break;

            case R.id.patientLog_search:
                intent = new Intent(patientLogMenu.this, patient_cost_search.class);
                startActivity(intent);
                break;

            case R.id.patientLog_back:
                intent = new Intent(patientLogMenu.this, MainActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
