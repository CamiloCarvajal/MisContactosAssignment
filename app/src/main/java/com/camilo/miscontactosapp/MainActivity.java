package com.camilo.miscontactosapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private TextInputLayout name;
    private DatePicker birthDay;
    private TextInputLayout phone;
    private TextInputLayout email;
    private TextInputLayout description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle params = getIntent().getExtras();
        if (params != null) {
            getTextInputLayout();
            String[] date = params.getString("birthDay").split("/", 5);

            birthDay.init(Integer.parseInt(date[2]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]), null);
            name.getEditText().setText(params.getString("name"));
            phone.getEditText().setText(params.getString("phone"));
            email.getEditText().setText(params.getString("email"));
            description.getEditText().setText(params.getString("description"));
        }


        Button siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contacto c = loadContact();

                Intent intent = new Intent(MainActivity.this, actualizarContacto.class);
                intent.putExtra("name", c.getName());
                intent.putExtra("birthDay", c.getBirthDay());
                intent.putExtra("phone", c.getPhone());
                intent.putExtra("email", c.getEmail());
                intent.putExtra("description", c.getDescription());

                startActivity(intent);
                finish();
            }
        });
    }


    private contacto loadContact(){
        getTextInputLayout();
        String date                 = String.valueOf(birthDay.getDayOfMonth()) + "/" +
                                      String.valueOf(birthDay.getMonth()+1) + "/" +
                String.valueOf(birthDay.getYear());

        return new contacto(name.getEditText().getText().toString(),
                date,
                phone.getEditText().getText().toString(),
                email.getEditText().getText().toString(),
                description.getEditText().getText().toString());
    }


    private void getTextInputLayout() {
        name = (TextInputLayout) findViewById(R.id.tifullName);
        birthDay = (DatePicker) findViewById(R.id.tiBirthday);
        phone = (TextInputLayout) findViewById(R.id.tiPhone);
        email = (TextInputLayout) findViewById(R.id.tiEmail);
        description = (TextInputLayout) findViewById(R.id.tiDescription);
    }

}