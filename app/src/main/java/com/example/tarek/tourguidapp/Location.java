package com.example.tarek.tourguidapp;

public class Location {

    private String locationName;
    private String locationAddress;
    private String locationDescription;
    private int locationimageResourceID;

    public Location(String mName, String mAddress, String mDescription, int imageID) {
        locationName = mName;
        locationAddress = mAddress;
        locationDescription = mDescription;
        locationimageResourceID = imageID;
    }


    public String getLocationName() {
        return locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public int getLocationimageResourceID() {
        return locationimageResourceID;
    }
}
