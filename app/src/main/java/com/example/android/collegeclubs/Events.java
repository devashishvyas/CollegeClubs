package com.example.android.collegeclubs;

public class Events {
    private String Date;
    private String Description;
    private String Name;
    private String Venue;
    private String PhotoUrl;

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public Events() {
    }

    public Events(String date, String description, String name, String venue) {
        Date = date;
        Description = description;
        Name = name;
        Venue = venue;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }
}
