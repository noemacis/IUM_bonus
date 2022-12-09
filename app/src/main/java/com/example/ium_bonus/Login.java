package com.example.ium_bonus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button login;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        login = findViewById(R.id.loginbtn);
        error = findViewById(R.id.error);

        //admin
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInput();
                if(editUsername.getText().toString().equals("admin") && editPassword.getText().toString().equals("admin")){
                    //rimanda alla activity home admin
                }
                else
                {
                    //rimanda alla activity home generica
                }
            }
        });



    }

    boolean checkInput (){
        int errorsint = 0;
        if (editUsername.getText().toString().length() == 0){
            errorsint ++;
            editUsername.setError("Inserire il nome");
        }

        if (editPassword.getText().toString().length() == 0){
            errorsint ++;
            editPassword.setError("Inserire il cognome");
        }

        switch (errorsint){

            case 0:
                error.setVisibility(View.GONE);
                break;
            case 1:
                error.setVisibility(View.VISIBLE);
                error.setText("Si è verificato 1 errore");
                break;
            default:
                error.setVisibility(View.VISIBLE);
                error.setText("Si sono verificati " + errorsint +" errori");
                break;
        }
        //se non ci sono errori restituisce true
        return errorsint == 0;

    }

}