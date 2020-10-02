package com.example.Shabir_Ahmad142_appdev;

public class ApplicationForm {
    private String phoneNumber;
    private String propertyName;
    private String cityName;
    private String localityName;
    private String ownerName;
    private String prefferededLanguae;
    private String applicationStatus;


    public ApplicationForm(){

    }

    public ApplicationForm(String propertyName,String phoneNumber, String cityName, String localityName, String ownerName, String prefferededLanguae,String applicationStatus) {
        this.phoneNumber = phoneNumber;
        this.propertyName = propertyName;
        this.cityName = cityName;
        this.localityName = localityName;
        this.ownerName = ownerName;
        this.prefferededLanguae = prefferededLanguae;
        this.applicationStatus = applicationStatus;
    }


    public String getPropertyName() {
        return propertyName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getLocalityName() {
        return localityName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPrefferededLanguae() {
        return prefferededLanguae;
    }
}
