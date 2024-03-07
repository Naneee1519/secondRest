package com.example.secondRest;

import jakarta.persistence.*;

@Entity

@Table(name = "Owners_Table")
public class AppEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String Flat_Number;

    private String Owner_Name;

    private  String Phone_Number;

    private String Address;

    private String Type;

    public String getFlat_Number() {
        return Flat_Number;
    }

    public void setFlat_Number(String flat_Number) {
        Flat_Number = flat_Number;
    }

    public String getOwner_Name() {
        return Owner_Name;
    }

    public void setOwner_Name(String owner_Name) {
        Owner_Name = owner_Name;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
