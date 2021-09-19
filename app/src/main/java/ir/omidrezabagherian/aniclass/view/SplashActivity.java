package ir.omidrezabagherian.aniclass.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ir.omidrezabagherian.aniclass.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Intent page splash to page login
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToLogin = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(goToLogin);
                finish();
            }
        }, 3000);

    }
}