package com.example.myapplication;

public class MyItems {
    String itemtitle;
    String itemdesc;
    String itemdate;

    public MyItems(String itemtitle, String itemdesc, String itemdate) {
        this.itemtitle = itemtitle;
        this.itemdesc = itemdesc;
        this.itemdate = itemdate;
    }

    public String getItemtitle() {
        return itemtitle;
    }

    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public String getItemdate() {
        return itemdate;
    }

    public void setItemdate(String itemdate) {
        this.itemdate = itemdate;
    }
}
