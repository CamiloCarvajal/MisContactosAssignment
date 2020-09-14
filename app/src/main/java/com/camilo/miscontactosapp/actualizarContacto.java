package com.camilo.miscontactosapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;


public class actualizarContacto extends AppCompatActivity {

    private TextView tvName;
    private TextView tvBirthDay;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contacto);

        Bundle params = getIntent().getExtras();
        ArrayList<contacto> contact = (ArrayList<contacto>) params.get("contact");
        String name = params.getString("name");
        String birthday = params.getString("birthDay");
        String phone = params.getString("phone");
        String email        = params.getString("email");
        String description  = params.getString("description");

        getTextViews();

        tvName.setText(name);
        tvBirthDay.setText(getResources().getString(R.string.birthDay) + ": " + birthday);
        tvPhone.setText(getResources().getString(R.string.phone) + ": " + phone);
        tvEmail.setText(getResources().getString(R.string.email) + ": " + email);
        tvDescription.setText(getResources().getString(R.string.description) + ": " + description);
    }


    public void actualizarInfo(View view) {

        Intent i = new Intent(actualizarContacto.this, MainActivity.class);
        getTextViews();

        i.putExtra("name", tvName.getText());
        i.putExtra("birthDay", tvBirthDay.getText().toString().replace(getResources().getString(R.string.birthDay) + ": ", ""));
        i.putExtra("phone", tvPhone.getText().toString().replace(getResources().getString(R.string.phone) + ": ", ""));
        i.putExtra("email", tvEmail.getText().toString().replace(getResources().getString(R.string.email) + ": ", ""));
        i.putExtra("description", tvDescription.getText().toString().replace(getResources().getString(R.string.description) + ": ", ""));

        startActivity(i);
        finish();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(actualizarContacto.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    private void getTextViews() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvBirthDay = (TextView) findViewById(R.id.tvBirthDay);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
    }


}