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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.odhiambodevelopers.kuiapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.editRegisterEmail.getText().toString();
                String phoneNumber=binding.edtRegisterPhoneNum.getText().toString();
                String name=binding.editRegisterUserName.getText().toString();
                String password=binding.edtRegisterPassword.getText().toString();
                String regNo=binding.editRegisterRegNo.getText().toString();

                if(email.isEmpty()){
                    binding.editRegisterEmail.setError("Empty Email");
                }
                else if(password.isEmpty()){
                    binding.edtRegisterPassword.setError("Required");
                }
                else  if(phoneNumber.isEmpty()){
                    binding.edtRegisterPhoneNum.setError("Required");
                }
                else  if(name.isEmpty()){
                    binding.editRegisterUserName.setError("Required");
                }
                else  if(regNo.isEmpty()){
                    binding.editRegisterRegNo.setError("Required");
                }
                else {
                    binding.RegisterProgressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(email,password).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        User user=new User(name,regNo,phoneNumber,email);
                                        String  userId=firebaseAuth.getCurrentUser().getUid();
                                        databaseReference.child(userId).setValue(user);

                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"Account creation was not succeful",Toast.LENGTH_SHORT).show();
                                        binding.RegisterProgressBar.setVisibility(View.GONE);
                                    }
                                }

                            });
                }

            }
        });

        binding.textViewHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}