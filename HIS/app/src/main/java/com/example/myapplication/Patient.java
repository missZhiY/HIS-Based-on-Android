package com.example.myapplication;

public class Patient {
    private int P_no;
    private String P_id;
    private String P_name;
    private int P_age;
    private String P_sex;
    private String P_section;
    private String In_date;
    private String Out_date;
    private String P_tel;
    private String diagnose;
    private String M_name;
    private String M_use;
    private int M_pay;
    private int Bed_pay;
    private int Deposit;
    private int Total_pay;
    private int doc_no;


    public int getPatientNo() {
        return P_no;
    }
    public String getPatientId() {
        return P_id;
    }
    public String getPatientName() {
        return P_name;
    }
    public int getPatientAge() {
        return P_age;
    }
    public String getPatientSex() {
        return P_sex;
    }
    public String getPatientSection() {
        return P_section;
    }
    public String getPatientDate() {
        return In_date;
    }
    public String getPatientOutDate() {
        return Out_date;
    }
    public String getPatientTel() {
        return P_tel;
    }
    public String getPatientDiagnose() {
        return diagnose;
    }
    public String getPatientM_name() {
        return M_name;
    }
    public String getPatientM_use() {
        return M_use;
    }
    public int getPatientM_pay() {
        return M_pay;
    }
    public int getPatientBed_pay() {
        return Bed_pay;
    }
    public int getPatientDeposit() {
        return Deposit;
    }
    public int getPatientTotal_pay() {
        return Total_pay;
    }
    public int getPatientDoc_no() {
        return doc_no;
    }



    public void setNo(int P_no){ this.P_no = P_no;}
    public void setId(String id) {
        this.P_id = id;
    }
    public void setName(String name) {
        this.P_name = name;
    }
    public void setAge(int age) {
        this.P_age = age;
    }
    public void setSex(String sex) {
        this.P_sex = sex;
    }
    public void setSection(String section) {
        this.P_section = section;
    }
    public void setDate(String date) {
        this.In_date = date;
    }
    public void setOutDate(String date) {
        this.Out_date = date;
    }
    public void setTel(String tel) {
        this.P_tel = tel;
    }
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
    public void setM_name(String M_name) {
        this.M_name = M_name;
    }
    public void setM_use(String M_use) {
        this.M_use = M_use;
    }
    public void setM_pay(int M_pay) {
        this.M_pay = M_pay;
    }
    public void setBed_pay(int Bed_pay) {
        this.Bed_pay = Bed_pay;
    }
    public void setTotal_pay_pay(int Total_pay) {
        this.Total_pay = Total_pay;
    }
    public void setDeposit(int Deposit) {
        this.Deposit = Deposit;
    }
    public void setDoc_no(int doc_no) {
        this.doc_no = doc_no;
    }
}
