package com.example.uidesignloginpage;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;

import androidx.appcompat.app.AppCompatActivity;

public class Signup_page extends AppCompatActivity {

    SQLiteDatabase db;

    EditText name, email, pass, confirm;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        name = findViewById(R.id.Name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        confirm = findViewById(R.id.confirm);
        signup = findViewById(R.id.button);


        db = openOrCreateDatabase("UserDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT)");


        signup.setOnClickListener(v -> {

            String n = name.getText().toString();
            String e = email.getText().toString();
            String p = pass.getText().toString();
            String c = confirm.getText().toString();

            if(n.isEmpty() || e.isEmpty() || p.isEmpty() || c.isEmpty()){
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
            }
            else if(!p.equals(c)){
                Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
            }
            else {

                ContentValues cv = new ContentValues();
                cv.put("name", n);
                cv.put("email", e);
                cv.put("password", p);

                db.insert("users", null, cv);

                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show();

                // Clear fields
                name.setText("");
                email.setText("");
                pass.setText("");
                confirm.setText("");
            }
        });
    }
}