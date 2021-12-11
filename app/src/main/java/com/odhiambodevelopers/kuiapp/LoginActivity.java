package com.odhiambodevelopers.kuiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.odhiambodevelopers.kuiapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_login);
        firebaseAuth= FirebaseAuth.getInstance();


        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                String email=binding.edtLoginEmail.getText().toString();
                String password=binding.edtLoginPassword.getText().toString();
                if(email.isEmpty()){
                    binding.edtLoginPassword.setError("Empty Email Address");
                }
                else if(password.isEmpty()){
                    binding.edtLoginPassword.setError("Empty password");
                }else {
                    binding.loginProgressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                        }

                    });}

            }


        });
    }
}