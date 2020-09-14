package com.camilo.miscontactosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button siguiente = (Button) findViewById(R.id.siguiente);




        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contacto c = loadContact();
                ArrayList<contacto> contactList = loadContactList(c);


                Intent intent = new Intent(MainActivity.this, actualizarContacto.class);
                intent.putExtra("name", c.getName());
                intent.putExtra("birthDay", c.getBirthDay());
                intent.putExtra("phone", c.getPhone());
                intent.putExtra("email", c.getEmail());
                intent.putExtra("description", c.getDescription());

                startActivity(intent);
//                finish();
            }
        });
    }

    private contacto loadContact(){
        TextInputLayout name        = (TextInputLayout) findViewById(R.id.tifullName);
        DatePicker birthDay         = (DatePicker) findViewById(R.id.tiBirthday);
        TextInputLayout phone       = (TextInputLayout) findViewById(R.id.tiPhone);
        TextInputLayout email       = (TextInputLayout) findViewById(R.id.tiEmail);
        TextInputLayout description = (TextInputLayout) findViewById(R.id.tiDescription);
        String date                 = String.valueOf(birthDay.getDayOfMonth()) + "/" +
                                      String.valueOf(birthDay.getMonth()+1) + "/" +
                                      String.valueOf(birthDay.getYear());

        return new contacto(name.getEditText().getText().toString(),
                            date,
                            phone.getEditText().getText().toString(),
                            email.getEditText().getText().toString(),
                            description.getEditText().getText().toString());
    }

    private ArrayList<contacto> loadContactList(contacto c){
        ArrayList<contacto> contactList  = new ArrayList<>();
        contactList.add(c);
        return contactList;

    }






}