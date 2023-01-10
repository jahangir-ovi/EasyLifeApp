package com.example.easylifeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylifeapp.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegestrationActivity extends AppCompatActivity {

    MaterialButton signupbutton;
    EditText name,emailid,pass;
    TextView signup;

    FirebaseAuth auth;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        signupbutton = findViewById(R.id.signupButton);
        name = findViewById(R.id.username);
        emailid = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        signup = findViewById(R.id.signUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               createUser();
            }

            private void createUser() {
                String userName = name.getText().toString();
                String userEmail = emailid.getText().toString();
                String userPassword = pass.getText().toString();

                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(RegestrationActivity.this, "Name is Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(userEmail)){
                    Toast.makeText(RegestrationActivity.this, "Email is Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(userPassword)){
                    Toast.makeText(RegestrationActivity.this, "Password is Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userName.length() < 6){
                    Toast.makeText(RegestrationActivity.this, "Password must be grater than 6 latter", Toast.LENGTH_SHORT).show();
                }

                // Create User

               auth.createUserWithEmailAndPassword(userEmail,userPassword)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()){

                                   UserModel userModel = new UserModel(userName,userEmail,userPassword);
                                   String id = task.getResult().getUser().getUid();
                                   database.getReference().child("Users").child(id).setValue(userModel);

                                   Toast.makeText(RegestrationActivity.this, "Regestration Successfully", Toast.LENGTH_SHORT).show();
                               }
                               else {
                                   Toast.makeText(RegestrationActivity.this, "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
            }
        });


    }

    public void registraton(View view){
        Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(intent);
    }
}