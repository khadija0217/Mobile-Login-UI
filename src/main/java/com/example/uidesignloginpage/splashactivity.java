package com.example.uidesignloginpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashactivity extends AppCompatActivity {
    ConstraintLayout loginBtn,Signupbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        loginBtn = findViewById(R.id.loginbtn);
        Signupbtn = findViewById(R.id.signupbtn);

        loginBtn.setOnClickListener(v -> {

            Intent intent = new Intent(splashactivity.this, Loginactivity.class);
            startActivity(intent);

        });
        Signupbtn.setOnClickListener(v -> {
            Intent intent = new Intent(splashactivity.this, Signup_page.class);
            startActivity(intent);
        });
    }
}