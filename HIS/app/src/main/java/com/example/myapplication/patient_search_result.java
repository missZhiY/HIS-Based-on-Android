package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class patient_search_result extends Activity {
    private Button btn;
    private MyOpenHelper myOpenHelper;
    private TextView Patient_message_name;
    private TextView Patient_message_no;
    private TextView Patient_message_age;
    private TextView Patient_message_sex;
    private TextView Patient_message_id;
    private TextView Patient_message_section;
    private TextView Patient_message_diagnose;
    private TextView Patient_message_M_pay;
    private TextView Patient_message_In_date;
    private TextView Patient_message_Out_date;
    private TextView Patient_message_Bed_pay;
    private TextView Patient_message_deposit;
    private TextView Patient_message_Total_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_message);

        Patient_message_name = findViewById(R.id.patient_message_P_name);
        Patient_message_no = findViewById(R.id.patient_message_P_no);
        Patient_message_age = findViewById(R.id.patient_message_P_age);
        Patient_message_sex = findViewById(R.id.patient_message_P_sex);
        Patient_message_id = findViewById(R.id.patient_message_P_id);
        Patient_message_section = findViewById(R.id.patient_message_section);
        Patient_message_diagnose = findViewById(R.id.patient_message_diagnose);
        Patient_message_M_pay = findViewById(R.id.patient_message_M_pay);
        Patient_message_Bed_pay = findViewById(R.id.patient_message_Bed_pay);
        Patient_message_deposit = findViewById(R.id.patient_message_deposit);
        Patient_message_Total_pay = findViewById(R.id.patient_message_total);
        Patient_message_In_date = findViewById(R.id.patient_message_In_date);
        Patient_message_Out_date = findViewById(R.id.patient_message_Out_date);

        myOpenHelper = new MyOpenHelper(getApplicationContext());
        //获得点击的账号
        Intent intent = getIntent();
        String P_id = intent.getStringExtra("P_id");
        //设置信息
        setView(P_id);

        btn = findViewById(R.id.patient_message_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(patient_search_result.this, patientLogMenu.class);
                startActivity(intent1);
            }
        });

    }

    public void setView(String P_id){
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        Cursor cursor = db.query("ruyuandengjibiao",
                null,
                "P_id=?",
                new String[]{P_id},
                null,
                null,
                null);
        if(cursor!=null&&cursor.getCount()>0) {
            while(cursor.moveToNext()) {

                String name = cursor.getString(2);
                int no = cursor.getInt(0);
                String age = cursor.getString(4);
                String sex = cursor.getString(3);
                String section =cursor.getString(5);
                String diagnose = cursor.getString(9);
                int M_pay = cursor.getInt(12);
                int Bed_pay = cursor.getInt(13);
                int deposit = cursor.getInt(14);
                int total = cursor.getInt(15);
                String InDate = cursor.getString(7);
                String OutDate = cursor.getString(8);

                Patient_message_name.setText(name);
                Patient_message_no.setText(String.valueOf(no));
                Patient_message_age.setText(age);
                Patient_message_sex.setText(sex);
                Patient_message_id.setText(P_id);
                Patient_message_section.setText(section);
                Patient_message_diagnose.setText(diagnose);
                Patient_message_M_pay.setText(String.valueOf(M_pay));
                Patient_message_Bed_pay.setText(String.valueOf(Bed_pay));
                Patient_message_deposit.setText(String.valueOf(deposit));
                Patient_message_Total_pay.setText(String.valueOf(total));
                Patient_message_In_date.setText(InDate);
                Patient_message_Out_date.setText(OutDate);
            }
        }
        db.close();
    }
}
