package com.example.bobohealth;

public class CalorieItem
{
    private int id;
    private String foodname;
    private String foodca;
    public CalorieItem(String 测试卡路里, float v){
        super();
        foodname="";
        foodca="";
    }
    public CalorieItem(String curName,String curRate){
        super();
        this.foodname=foodname;
        this.foodca=foodca;
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getfoodname(){
        return foodname;
    }
    public void setfoodname(String foodname) {
        this.foodname = foodname;
    }
    public String getfoodca(){
        return foodca;
    }
    public void setfoodca(String foodca) {
        this.foodca = foodca;
    }
}
