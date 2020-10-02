package com.example.Shabir_Ahmad142_appdev;

import android.os.Parcel;
import android.os.Parcelable;

public class DataList implements Parcelable {
    private String id;
    private String cityName;
    private String localityName;
    private String ownerName;
    private String phoneNumber;
    private String prefferededLanguae;
    private String propertyName;
    private String applicationStatus;

    public DataList(){

    }

    public DataList(String id,String cityName, String localityName, String ownerName,String phoneNumber, String prefferededLanguae,String propertyName, String applicationStatus) {
        this.id = id;
        this.cityName = cityName;
        this.localityName = localityName;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.prefferededLanguae = prefferededLanguae;
        this.propertyName = propertyName;
        this.applicationStatus = applicationStatus;
    }

    protected DataList(Parcel in) {
        id = in.readString();
        cityName = in.readString();
        localityName = in.readString();
        ownerName = in.readString();
        phoneNumber = in.readString();
        prefferededLanguae = in.readString();
        propertyName = in.readString();
        applicationStatus = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(cityName);
        dest.writeString(localityName);
        dest.writeString(ownerName);
        dest.writeString(phoneNumber);
        dest.writeString(prefferededLanguae);
        dest.writeString(propertyName);
        dest.writeString(applicationStatus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataList> CREATOR = new Creator<DataList>() {
        @Override
        public DataList createFromParcel(Parcel in) {
            return new DataList(in);
        }

        @Override
        public DataList[] newArray(int size) {
            return new DataList[size];
        }
    };

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPrefferededLanguae(String prefferededLanguae) {
        this.prefferededLanguae = prefferededLanguae;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOwnerName() {
        return ownerName;
    }

    public String getPrefferededLanguae() {
        return prefferededLanguae;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }
}
