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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class out_manage extends Activity {

    private Button btn;
    private EditText out_manage_leave_et_number, out_manage_leave_et_leaveTime;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.out_manage_leave);

        out_manage_leave_et_number = findViewById(R.id.out_manage_leave_et_number);
        out_manage_leave_et_leaveTime = findViewById(R.id.out_manage_leave_et_leaveTime);

        myOpenHelper = new MyOpenHelper(getApplicationContext());

        btn = (Button) findViewById(R.id.out_manage_leave_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                String P_no = out_manage_leave_et_number.getText().toString();
                String leave_time = out_manage_leave_et_leaveTime.getText().toString().trim();

                SQLiteDatabase db = myOpenHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("Out_date", leave_time);
                //更新出院时间
                int update = db.update("ruyuandengjibiao", values, "P_no=?", new String[]{P_no});
                //更新总费用
                Cursor cursor = db.query("ruyuandengjibiao", null, "P_no=?", new String[]{P_no}, null, null, null);
                if(cursor!=null&&cursor.getCount()>0) {
                    while(cursor.moveToNext()) {
                        int M_pay = cursor.getInt(12);
                        int Bed_pay = cursor.getInt(13);
                        int Deposit = cursor.getInt(14);
                        int sum = M_pay + Bed_pay + Deposit;
                        ContentValues values1 = new ContentValues();
                        values1.put("Total_pay", sum);
                        db.update("ruyuandengjibiao",values1,"P_no=?", new String[]{P_no});
                        //int Total = cursor.getInt(15);
                    }
                }
                db.close();

                //操作成功就跳转
                if(update==1) {
                    Intent intent = new Intent(out_manage.this, out_manage_cost_print.class);
                    intent.putExtra("P_no", P_no);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "操作成功", 1).show();
                    finish();
                }else {
                    Intent intent = new Intent(out_manage.this, MenuActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "操作失败", 1).show();
                }
            }
        });
    }
}
