package com.example.bobohealth;

public class WeightItem
{
    private int id;
    private String foodname;
    private String foodca;
    public WeightItem(String 测试卡路里, float v){
        super();
        foodname="";
        foodca="";
    }
    public WeightItem(String curName, String curRate){
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