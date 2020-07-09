package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class system_manage_search extends Activity {

    private EditText et_account;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_search);
        et_account = findViewById(R.id.system_search_et_account);

        btn = findViewById(R.id.system_search_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String P_id = et_account.getText().toString();
                Intent intent = new Intent(system_manage_search.this, system_search_result.class);
                intent.putExtra("P_id", P_id);
                startActivity(intent);
            }
        });
    }
}
