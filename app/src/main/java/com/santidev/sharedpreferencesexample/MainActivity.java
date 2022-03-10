package com.santidev.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //leer preferencias guardadas en disco solo lectura
        SharedPreferences preferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);

        /*

        //prefeencias para leer y escribir (version editable de las Shared preferences)
        SharedPreferences.Editor editor = preferences.edit();

        String username = "Santiago";
        int age = 21;
        boolean knowsShowToMakeApps = true;

        //guardamos las variable en la version editable de las shared preferences
        editor.putString("username", username);
        editor.putInt("age", age);
        editor.putBoolean("knowsHowToCode", knowsShowToMakeApps);
        //commit guarda la informacion anterior en disco
        editor.commit();


         */

        String username = preferences.getString("username", "nuevo usuario");
        int age = preferences.getInt("age", -1);
        boolean knowsHowToCode = preferences.getBoolean("knowsHowToCode", false);

        Log.d(TAG, "El usuario se llama " + username + " tiene " + age + "anios y" +
                (knowsHowToCode ? " sabe programar": " no sabe programar"));

        if(username.compareTo("nuevo usuario") == 0){
            //mostrar pantalla para seleccionar el nombre de usuario
        }
        if(age == -1){
            //la edad no ha sido configurada, mostrar un calendario para seleccionar la fecha de nacimiento
        }
    }
}