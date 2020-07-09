package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {
    /**
     * @param onClickListener 上下文
     *                        name:数据库的名字
     *                        Factory 目的创建cursor对象
     *                        version 数据库的版本 从1开始
     */
    public MyOpenHelper(Context onClickListener) {
        super(onClickListener, "HIS.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dengjibiaoSql = "create table ruyuandengjibiao(P_no integer primary key autoincrement, " +
                "P_id varchar(10) not null, " +
                "P_name varchar(10) not null, " +
                "P_sex varchar(6) not null, " +
                "P_age integer not null," +
                "section varchar(20) not null, " +
                "P_tel varchar(10), " +
                "In_date varchar(12) not null, " +
                "Out_date varchar(12)," +
                "diagnose varchar(20), " +
                "M_name varchar(10), " +
                "M_use varchar(20), " +
                "M_pay integer, " +
                "Bed_pay integer, " +
                "Deposit integer, " +
                "Total_pay integer, " +
                "Doc_no integer)";

        //住院病历表
        String zhuyuanSql = "create table zhuyuanbingli(P_no integer primary key, P_id varchar(32) not null, " +
                "P_name varchar(32) not null, P_sex varchar(32) not null, P_age integer, section varchar(32) not null," +
                "In_date varchar(32), Out_date varchar(32), Deposit integer, diagnose varchar(32), Bed_no integer not null)";
        //历史病历表
        String lishiSql = "create table lishibingli(P_no integer primary key, P_id varchar(32) not null, " +
                "P_name varchar(32) not null, P_sex varchar(32) not null, P_age integer, section varchar(32) not null, " +
                "In_date varchar(32), Out_date varchar(32), Total_Pay integer, Current_dia varchar(32), Bed_no integer not null)";
        //医嘱
        String yizhuSql = "create table yizhu(P_no integer primary key, P_name varchar(32) not null, section varchar(32) not null, " +
                "diagnose varchar(32), M_name varchar(32) not null, M_use varchar(100), M_pay integer not null, Doc_no integer)";
        //计费表
        String jifeiSql = "create table jifei(P_no integer primary key, P_name varchar(32) not null, Deposit integer, " +
                "M_pay integer not null, Bed_pay integer not null, Total_pay integer not null, Back_Money integer)";

        db.execSQL(dengjibiaoSql);
        db.execSQL(zhuyuanSql);
        db.execSQL(lishiSql);
        db.execSQL(yizhuSql);
        db.execSQL(jifeiSql);
        db.execSQL(dengjibiaoSql);
    }

    /**
     * 数据库版本更新时调用，适合做表的结构
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.i("数据库", "---版本更新" + oldVersion + "--->" + newVersion);
    }
}



   /*
        //入院登记表
        String dengjibiaoSql = "create table ruyuandengjibiao(P_no integer primary key autoincrement, "
                + "P_id varchar(32) not null, P_name varchar(32) not null, P_sex varchar(32) not null, P_age integer,"
                + "section varchar(32) not null, P_tel varchar(32), In_date varchar(32))";
        //住院病历表
        String zhuyuanSql = "create table zhuyuanbingli(P_no integer primary key, P_id varchar(32) not null, " +
                "P_name varchar(32) not null, P_sex varchar(32) not null, P_age integer, section varchar(32) not null," +
                "In_date varchar(32), Out_date varchar(32), Deposit integer, diagnose varchar(32), Bed_no integer not null)";
        //历史病历表
        String lishiSql = "create table lishibingli(P_no integer primary key, P_id varchar(32) not null, " +
                "P_name varchar(32) not null, P_sex varchar(32) not null, P_age integer, section varchar(32) not null, " +
                "In_date varchar(32), Out_date varchar(32), Total_Pay integer, Current_dia varchar(32), Bed_no integer not null)";
        //医嘱
        String yizhuSql = "create table yizhu(P_no integer primary key, P_name varchar(32) not null, section varchar(32) not null, " +
                "diagnose varchar(32), M_name varchar(32) not null, M_use varchar(100), M_pay integer not null, Doc_no integer)";
        //计费表
        String jifeiSql = "create table jifei(P_no integer primary key, P_name varchar(32) not null, Deposit integer, " +
                "M_pay integer not null, Bed_pay integer not null, Total_pay integer not null, Back_Money integer)";

        //病床表
        String bingchuangSql = "create table bingchuang(Bed_no integer primary key, Bed_state integer not null)";

        db.execSQL(dengjibiaoSql);
        db.execSQL(zhuyuanSql);
        db.execSQL(lishiSql);
        db.execSQL(yizhuSql);
        db.execSQL(jifeiSql);
        db.execSQL(bingchuangSql);
         */

