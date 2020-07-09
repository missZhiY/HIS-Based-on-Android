package com.example.myapplication;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class system_manage_clearData extends Activity {
    private Button btn;
    private ListView p_list;
    private List<Patient> patientList;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_list);

        btn = findViewById(R.id.patient_list_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(system_manage_clearData.this, system_manage.class);
                startActivity(intent);
            }
        });

        p_list = (ListView) findViewById(R.id.patient_list_patients);
        initPatientListView();

        //为listView设置长按事件
        p_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                //定义AlertDialog.Builder对象，当长按列表项的时候弹出确认删除对话框
                AlertDialog.Builder builder=new AlertDialog.Builder(system_manage_clearData.this);
                builder.setMessage("确定删除?");
                builder.setTitle("提示");
                //添加AlertDialog.Builder对象的setPositiveButton()方法
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Patient patient = patientList.remove(position);
                        if(patient!=null){
                            //找到删除的药物信息信息
                            int P_no = patient.getPatientNo();
                            SQLiteDatabase db = myOpenHelper.getWritableDatabase();
                            int delete = db.delete("ruyuandengjibiao", "P_no=?", new String[] {String.valueOf(P_no)});
                            if (delete>0) {
                                Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                            }
                            db.close();
                        }else {
                            Toast.makeText(getApplicationContext(), "删除失败", Toast.LENGTH_SHORT).show();
                            System.out.println("failed");
                        }
                        MyAdapter myAdapter = new MyAdapter();
                        myAdapter.notifyDataSetChanged();
                    }
                });
                //添加AlertDialog.Builder对象的setNegativeButton()方法
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create().show();
                return true;
            }
        });

    }

    private void initPatientListView() {
        // 在数据库中获取病人的信息
        myOpenHelper = new MyOpenHelper(getApplicationContext());
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        patientList = DBParserUtils.getPatient(db);
        db.close();
        //如果有信息才显示
        if (patientList!=null) {
            p_list.setAdapter(new MyAdapter());
        }
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            System.out.println("列表的size是");
            System.out.println(patientList.size());
            return patientList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.patient_list_item, null);
            } else {
                view = convertView;
            }
            // 找到我們的控件， 显示集合里面的数据
            TextView P_no = (TextView)view.findViewById(R.id.item_P_no);
            TextView P_Name = (TextView)view.findViewById(R.id.item_P_Name);
            TextView In_date = (TextView)view.findViewById(R.id.item_In_date);

            P_no.setText(String.valueOf(patientList.get(position).getPatientNo()));
            P_Name.setText(patientList.get(position).getPatientName());
            In_date.setText(patientList.get(position).getPatientDate());
            return view;
        }
    }
}
