package com.example.ium_bonus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Registrazione extends AppCompatActivity {

    EditText username,password_1,password_2,citta,data;
    Button registrazione;
    TextView error;

    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione);

        username = findViewById(R.id.rusername);
        password_1 = findViewById(R.id.rpassword);
        password_2 = findViewById(R.id.rpassword2);
        citta = findViewById(R.id.citta);
        data = findViewById(R.id.data);

        registrazione = findViewById(R.id.btnsingUp);
        error = findViewById(R.id.error);


        persona = new Persona();

        //oggetto intent e prendo il contesto della prima activity con .this e la seconda di destinazione.class
        // e uso startActivity controllo se i campi sono pieni vai avanti altrimenti dai errore
        registrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInput()) {

                    updatePerson();

                    Intent backlogin = new Intent(Registrazione.this, Login.class);
                    startActivity(backlogin);

                }

            }
        });
    }

    void doPositiveClick(Calendar date){

        this.persona.setBitrthDate(date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        data.setText(format.format(date.getTime()));
    }

    void showDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    boolean checkInput (){
        String textToCheck;

        int errorsint = 0;
        if (username.getText().toString().length() == 0){
            errorsint ++;
            username.setError("Inserire il nome");
        }

        if (password_1.getText().toString().length() == 0){
            errorsint ++;
            password_1.setError("Inserire la password");
        }
        if (password_2.getText().toString().length() == 0){
            errorsint ++;
            password_2.setError("Inserire la password");
        }
        if(!(password_1.getText().toString().equals(password_2.getText().toString()))){
            errorsint ++;
            password_1.setError("le password non coincidono");
            password_2.setError("le password non coincidono");
        }
        /*MANCANO CONTROLI PASSWORD CITTà, E LINK DA LOGIN A REGISTRAZIONE*/

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

    void updatePerson(){
        String username = this.username.getText().toString();
        this.persona.setUsername(username);

        String password = this.password_1.getText().toString();
        this.persona.setPassword(password);

        String citta = this.citta.getText().toString();
        this.persona.setCitta(citta);



    }


}