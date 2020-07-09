package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class add_patient extends Activity {

    private EditText edit_name, edit_id, edit_age, edit_sex;
    private EditText edit_section, edit_in_time, edit_tel;
    private Button btn;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient);

        edit_name = findViewById(R.id.edit_name);
        edit_id = findViewById(R.id.edit_id);
        edit_sex = findViewById(R.id.edit_sex);
        edit_age = findViewById(R.id.edit_age);
        edit_section = findViewById(R.id.edit_section);
        edit_in_time = findViewById(R.id.edit_in_time);
        edit_tel = findViewById(R.id.edit_tel);

        myOpenHelper = new MyOpenHelper(getApplicationContext());
        btn = findViewById(R.id.edit_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                Patient patient = judgeInputMessage();
                SQLiteDatabase db = myOpenHelper.getWritableDatabase();

                if (patient != null){
                    if (DBParserUtils.insertPatient(db, patient)){
                        Toast.makeText(getApplicationContext(), "添加成功",1).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),"添加失败",1).show();
                    }
                    db.close();
                }
            }
        });
    }

    @SuppressLint("WrongConstant")
    public Patient judgeInputMessage() {
        String P_id = edit_id.getText().toString().trim();
        String P_name = edit_name.getText().toString().trim();
        String P_sex = edit_sex.getText().toString().trim();
        String P_age = edit_age.getText().toString().trim();
        String section = edit_section.getText().toString().trim();
        String P_tel = edit_tel.getText().toString().trim();
        String In_date = edit_in_time.getText().toString().trim();

        Patient patient = new Patient();

        if (P_id.equals("")){
            Toast.makeText(getApplicationContext(), "身份证号不能为空", 1).show();
            return null;
        }
        if (P_name.equals("")){
            Toast.makeText(getApplicationContext(), "姓名不能为空", 1).show();
            return null;
        }
        if (P_sex.equals("")){
            Toast.makeText(getApplicationContext(), "性别不能为空", 1).show();
            return null;
        }
        if (P_age.equals("")){
            Toast.makeText(getApplicationContext(), "年龄不能为空", 1).show();
            return null;
        }
        if (section.equals("")){
            Toast.makeText(getApplicationContext(), "科属不能为空", 1).show();
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.parse(In_date);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "生产日期请输入正确的格式，如2020-03-06", 1).show();
            return null;
        }

        try {
             Integer.valueOf(P_age);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "请输入正确年龄，只能是数字", 1).show();
            return null;
        }

        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        Cursor cursor = db.query("ruyuandengjibiao", new String[]{"P_id"}, "P_id=?",new String[]{P_id},
                null,null,null);
        if (cursor != null && cursor.getCount()>0){
            Toast.makeText(getApplicationContext(),"该病人已在医院中",1).show();
            return null;
        }
        db.close();

        patient.setId(P_id);
        patient.setName(P_name);
        patient.setSex(P_sex);
        patient.setAge(Integer.parseInt(P_age));
        patient.setSection(section);
        patient.setTel(P_tel);
        patient.setDate(In_date);

        return patient;
    }
}
