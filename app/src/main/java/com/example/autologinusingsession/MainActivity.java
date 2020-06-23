package com.example.autologinusingsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        if(session.loggedin()){
            startActivity(new Intent(MainActivity.this,LoggedInActivity.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();

                if(user_name.equals("tanvir") && pass_word.equals("rafi")) {
                    session.setLoggedin(true);
                    Toast.makeText(getApplicationContext(), "username: " + user_name+ " & password: " + pass_word, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        startActivity(homeIntent);
        finish();
        System.exit(0);
    }
}
