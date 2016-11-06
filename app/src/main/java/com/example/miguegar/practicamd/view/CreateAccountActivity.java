package com.example.miguegar.practicamd.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.miguegar.practicamd.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Se manda llamar el metodo showToolbar con los parametros correspondientes
        showToolbar(getResources().getString(R.string.toolbar_tittle_create_account), true);
    }

    //Personalizar el Toolbar
    public void showToolbar(String tittle, boolean upButton) {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);                      //Para soporte a versiones anteriores.
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
