package com.odhiambodevelopers.kuiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.odhiambodevelopers.kuiapp.databinding.ActivityAuthDashboardBinding;

public class AuthDashboardActivity extends AppCompatActivity {

    ActivityAuthDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityAuthDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AuthDashboardActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        binding.buttonBoardSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AuthDashboardActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}