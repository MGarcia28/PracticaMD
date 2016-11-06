package com.example.miguegar.practicamd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.miguegar.practicamd.view.ContainerActivity;
import com.example.miguegar.practicamd.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goContainer(View view) {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
