package com.camilo.miscontactosapp;

import android.widget.DatePicker;
import android.widget.TextView;

public class contacto {

    String name;
    String birthDay;
    String phone;
    String email;
    String description;


    public contacto(String name, String birthDay, String phone, String email, String description) {
        this.name           = name;
        this.birthDay       = birthDay;
        this.phone          = phone;
        this.email          = email;
        this.description    = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
