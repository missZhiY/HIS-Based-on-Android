package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class patient_cost_search extends Activity {

    private Button btn;
    private EditText cost_search_P_no;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_cost_search);

        cost_search_P_no = findViewById(R.id.patient_search_et_account);
        btn = findViewById(R.id.patient_search_ok);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String P_no = cost_search_P_no.getText().toString();
                intent = new Intent(patient_cost_search.this, patient_cost_result.class);
                intent.putExtra("P_no", P_no);
                startActivity(intent);
            }
        });
    }
}
