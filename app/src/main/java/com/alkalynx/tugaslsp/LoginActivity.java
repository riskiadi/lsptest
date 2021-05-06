package com.alkalynx.tugaslsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEdt, passwordEdt;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdt = findViewById(R.id.usernameEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        signInBtn = findViewById(R.id.signInBtn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameEdt.getText().toString().equals("admin") && passwordEdt.getText().toString().equals("admin") || usernameEdt.getText().toString().equals("user") && passwordEdt.getText().toString().equals("user")){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                    if(usernameEdt.getText().toString().equals("admin") && passwordEdt.getText().toString().equals("admin")){
                        Intent intent = new Intent(LoginActivity.this, CustomerActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }

                }else{
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}