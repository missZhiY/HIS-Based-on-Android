package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBParserUtils {
    public static List<Patient> getPatient(SQLiteDatabase db){
        List<Patient> patientList = null;
        Cursor cursor = db.rawQuery("select * from ruyuandengjibiao", null);
        if (cursor != null && cursor.getCount() > 0){
            patientList = new ArrayList<Patient>();
            while (cursor.moveToNext()){
                Patient patient = new Patient();
                int P_no = cursor.getInt(0);
                //String P_id = cursor.getString(1);
                String P_name = cursor.getString(2);
                //String P_sex = cursor.getString(3);
                //int P_age = cursor.getInt(4);
                //String section = cursor.getString(5);
                //String tel = cursor.getString(6);
                String In_date = cursor.getString(7);
                //String Out_date = cursor.getString(8);
                //String diagnose = cursor.getString(9);
                //String M_name = cursor.getString(10);
                //String M_use = cursor.getString(11);
                //int M_pay = cursor.getString(12);
                //int Bed_pay = cursor.getString(13);
                //int Deposit = cursor.getString(14);
                //int Total_pay = cursor.getString(15);
                //int doc_no = cursor.getString(16);

                patient.setNo(P_no);
                //patient.setId(P_id);
                patient.setName(P_name);
                //patient.setSex(P_sex);
                //patient.setAge(P_age);
                //patient.setSection(section);
                //patient.setTel(tel);
                patient.setDate(In_date);
                patientList.add(patient);
            }
        }
        return patientList;
    }

    public static Boolean insertPatient(SQLiteDatabase db, Patient patient){
        ContentValues values = new ContentValues();
        values.put("P_id", patient.getPatientId());
        values.put("P_name", patient.getPatientName());
        values.put("P_sex", patient.getPatientSex());
        values.put("P_age", patient.getPatientAge());
        values.put("section", patient.getPatientSection());
        values.put("P_tel", patient.getPatientTel());
        values.put("In_date", patient.getPatientDate());
        values.put("Bed_pay",100);
        values.put("Deposit",200);

        long insert = db.insert("ruyuandengjibiao",null,values);
        if (insert > 0){
            return true;
        }else {
            return false;
        }
    }
}
