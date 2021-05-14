package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewAc extends AppCompatActivity {

    private EditText eName;
    private EditText ePass;
    private Button eLogin;
    private TextView eAttemp;

    private String Username = "Admin";
    private String Password = "123";

    boolean isValid = false;

    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        eName =  findViewById(R.id.edUser);
        ePass =  findViewById(R.id.edPass);
        eLogin = findViewById(R.id.btnLogin);
        eAttemp = findViewById(R.id.eAttemp);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPass = ePass.getText().toString();
                if(inputName.isEmpty() || inputPass.isEmpty())
                {
                    Toast.makeText(NewAc.this, "Pls enter all details",Toast.LENGTH_LONG).show();
                }else {
                    isValid = validate(inputName,inputPass);

                    if(!isValid){
                        counter --;

                        Toast.makeText(NewAc.this, "Incorrect",Toast.LENGTH_LONG).show();

                        eAttemp.setText("No off attemps remaining:" + counter);

                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }
                    }else {
                        Toast.makeText(NewAc.this, "Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(NewAc.this, MainActivity.class );
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private boolean validate(String name, String pass)
    {
        if(name.equals(Username) && pass.equals(Password))
        {
            return true;
        }
        return false;
    }
}