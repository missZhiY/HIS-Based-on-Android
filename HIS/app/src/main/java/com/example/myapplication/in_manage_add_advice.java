package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class in_manage_add_advice extends Activity {

    private Button btn;
    private EditText diagnose, M_name, M_use, M_pay, doc_no;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_advice);

        diagnose = findViewById(R.id.add_advice_diagnose);
        M_name = findViewById(R.id.add_advice_M_name);
        M_use = findViewById(R.id.add_advice_M_use);
        M_pay = findViewById(R.id.add_advice_M_pay);
        doc_no = findViewById(R.id.add_advice_Doctor_num);

        myOpenHelper = new MyOpenHelper(getApplicationContext());
        Intent intent = getIntent();
        final String P_no = intent.getStringExtra("P_no");

        btn = findViewById(R.id.submit_advice);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                String add_diagnose = diagnose.getText().toString().trim();
                String add_M_name = M_name.getText().toString().trim();
                String add_M_use = M_use.getText().toString().trim();
                String add_M_pay = M_pay.getText().toString().trim();
                String add_doc_no = doc_no.getText().toString().trim();

                SQLiteDatabase db = myOpenHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("diagnose", add_diagnose);
                values.put("M_name", add_M_name);
                values.put("M_use", add_M_use);
                values.put("M_pay", Integer.parseInt(add_M_pay));
                values.put("doc_no", Integer.parseInt(add_doc_no));

                int update = db.update("ruyuandengjibiao", values, "P_no=?", new String[] {P_no});
                if(update==1) {
                    Intent intent = new Intent(in_manage_add_advice.this, in_manage_look_patient.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "添加成功", 1).show();
                    finish();
                }else {
                    Intent intent = new Intent(in_manage_add_advice.this, in_manage_look_patient.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "添加失败", 1).show();
                }
            }
        });
    }

}
