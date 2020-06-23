package com.example.autologinusingsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoggedInActivity extends AppCompatActivity {

    private Button logout;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        logout = findViewById(R.id.logout);
        session = new Session(this);

        if (!session.loggedin()) {
            logout();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(LoggedInActivity.this, MainActivity.class));
    }

    public void onBackPressed() {
        Intent start = new Intent(LoggedInActivity.this, MainActivity.class);
        startActivity(start);
        finishActivity(0);
    }
}
