package com.example.mayandroid;

public class MyListData {

    private String name;
    private String desc;
    private int imageid;

    public MyListData(String name, String desc, int imageid) {
        this.name = name;
        this.desc = desc;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
