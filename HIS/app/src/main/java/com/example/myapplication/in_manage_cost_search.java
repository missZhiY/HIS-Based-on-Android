package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class in_manage_cost_search extends Activity {

    private Button cost_search_ok, cost_search_rtn;
    private EditText cost_search_P_no;
    private ListView p_list;
    private List<Patient> patientList;
    private Intent intent;
    private MyOpenHelper myOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cost_search);

        cost_search_P_no = findViewById(R.id.cost_search_P_no);
        cost_search_ok = findViewById(R.id.cost_search_ok);
        cost_search_rtn = findViewById(R.id.cost_search_rtn);

        myOpenHelper = new MyOpenHelper(getApplicationContext());
        cost_search_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String P_no = cost_search_P_no.getText().toString();
                intent = new Intent(in_manage_cost_search.this, out_manage_cost_print.class);
                intent.putExtra("P_no", P_no);
                startActivity(intent);
            }
        });
        cost_search_rtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(in_manage_cost_search.this, in_manage.class);
                startActivity(intent);
            }
        });

        p_list = findViewById(R.id.cost_search_list);
        initPatientListView();
        p_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView item_P_no = view.findViewById(R.id.item_P_no);
                String P_no = item_P_no.getText().toString();
                Intent intent = new Intent(in_manage_cost_search.this, out_manage_cost_print.class);
                intent.putExtra("P_no", P_no);
                startActivity(intent);
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
