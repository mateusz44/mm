package com.clockworkjava.kursspring.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Hotel {
    @NotNull
    @Size(min=2, max=20, message="min 2 znaki maximum 20 znakow")
    private String name;

    private int id;

    public Hotel (){}
    public Hotel(int id, String name ){
        this.id=id;this.name=name; }
    public Hotel(String name )
    {
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId(){
        return this.id;
    }
    public String toString()
    {
        return "Hotel " + name + "oferuje wpokoje w cenie "  ;
    }
}