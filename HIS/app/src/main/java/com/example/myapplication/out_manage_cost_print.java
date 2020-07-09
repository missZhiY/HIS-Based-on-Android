package com.example.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class out_manage_cost_print extends Activity {

    private Button btn;
    private TextView out_manage_et_name;
    private TextView out_manage_et_number;
    private TextView out_manage_et_mPay;
    private TextView out_manage_et_bedPay;
    private TextView out_manage_deposit;
    private TextView out_manage_et_total;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.out_manage_cost_print);

        out_manage_et_name = findViewById(R.id.out_manage_et_name);
        out_manage_et_number = findViewById(R.id.out_manage_et_number);
        out_manage_et_mPay = findViewById(R.id.out_manage_et_mPay);
        out_manage_et_bedPay = findViewById(R.id.out_manage_et_bedPay);
        out_manage_deposit = findViewById(R.id.out_manage_deposit);
        out_manage_et_total = findViewById(R.id.out_manage_et_total);

        myOpenHelper = new MyOpenHelper(getApplicationContext());
        //获得点击的账号
        Intent intent = getIntent();
        final String P_no = intent.getStringExtra("P_no");
        //设置信息
        setView(P_no);

        btn = findViewById(R.id.out_manage_bt_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(out_manage_cost_print.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setView(String P_no) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        Cursor cursor = db.query("ruyuandengjibiao",
                null,
                "P_no=?",
                new String[]{P_no},
                null,
                null,
                null);

        if(cursor!=null&&cursor.getCount()>0) {
            while(cursor.moveToNext()) {
                String name = cursor.getString(2);
                int no = cursor.getInt(0);
                int M_pay = cursor.getInt(12);
                int Bed_pay = cursor.getInt(13);
                int Deposit = cursor.getInt(14);
                int Total = cursor.getInt(15);


                out_manage_et_name.setText(name);
                out_manage_et_number.setText(String.valueOf(no));
                out_manage_et_mPay.setText(String.valueOf(M_pay));
                out_manage_et_bedPay.setText(String.valueOf(Bed_pay));
                out_manage_deposit.setText(String.valueOf(Deposit));
                out_manage_et_total.setText(String.valueOf(Total));
            }
        }
        db.close();
    }
}
