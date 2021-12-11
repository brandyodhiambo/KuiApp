package com.odhiambodevelopers.kuiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.odhiambodevelopers.kuiapp.databinding.ActivityAddPostBinding;

public class AddPostActivity extends AppCompatActivity {
    ActivityAddPostBinding binding;
    DatabaseReference databaseReference;
    String  userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseReference = FirebaseDatabase.getInstance().getReference();

        binding.buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = binding.edtPostTitle.getText().toString();
                String description = binding.editPostDescription.getText().toString();

                if (title.isEmpty()) {
                    binding.edtPostTitle.setError("Empty Title");
                } else if (description.isEmpty()) {
                    binding.editPostDescription.setError("Empty Title");
                } else {
                    Post post =new Post(title,description,userName);
                    databaseReference.child("posts").push().setValue (post);
                }
            }
        });

    }

    private void getUserName() {
        databaseReference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                userName = user.getUsername();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })

    }
}