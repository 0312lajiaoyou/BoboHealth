package com.example.bobohealth;

public class WeightItem
{
    private int id;
    private Float weight;
    private String date;
    public WeightItem(Float weight, String date){
        super();
        this.weight=weight;
        this.date=date;
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Float getweight(){
        return weight;
    }
    public void setweight(Float weight) {
        this.weight = weight;
    }
    public String getdate(){
        return date;
    }
    public void setdate(String date) {
        this.date = date;
    }
}
