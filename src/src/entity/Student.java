package entity;

import java.util.Collections;

public class Student {
    private String id;
    private String name;
    private String birDate;
    private int  gender;

    public Student(){

    }

    public Student(String id,String name, int gender,String birDate){
        this.id = id;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirDate() {
        return birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birDate='" + birDate + '\'' +
                ", gender=" + gender +
                '}';
    }
}
