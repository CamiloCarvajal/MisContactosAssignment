package com.camilo.miscontactosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class actualizarContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contacto);

        Bundle params = getIntent().getExtras();
        ArrayList<contacto> contact = (ArrayList<contacto>) params.get("contact");
        String name         = params.getString("name");
        String birtday      = params.getString("birthDay");
        String phone        = params.getString("phone");
        String email        = params.getString("email");
        String description  = params.getString("description");


        TextView tvName         = (TextView)findViewById(R.id.tvName);
        TextView tvBirthDay     = (TextView)findViewById(R.id.tvBirthDay);
        TextView tvPhone        = (TextView)findViewById(R.id.tvPhone);
        TextView tvEmail        = (TextView)findViewById(R.id.tvEmail);
        TextView tvDescription  = (TextView)findViewById(R.id.tvDescription);

        tvName.setText(name);
        tvBirthDay.setText(getResources().getString(R.string.birthDay) + ": " + birtday);
        tvPhone.setText(getResources().getString(R.string.phone) + ": "+ phone);
        tvEmail.setText(getResources().getString(R.string.email) + ": " + email);
        tvDescription.setText(getResources().getString(R.string.description) + ": "+ description);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(actualizarContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }


}