package com.example.android.collegeclubs;

public class Clubs {

    private String Contact_No;
    private String Description;
    private String Head;
    private String Name;
    private String Website;

    public Clubs(String contact_No, String description, String head, String name, String website) {
        Contact_No = contact_No;
        Description = description;
        Head = head;
        Name = name;
        Website = website;
    }
    public Clubs()
    {

    }

    public String getContact_No() {
        return Contact_No;
    }

    public void setContact_No(String contact_No) {
        Contact_No = contact_No;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHead() {
        return Head;
    }

    public void setHead(String head) {
        Head = head;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}
