package com.systemintegration.uncc.texttospeechproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    EditText emailField;
    EditText passwordField;
    EditText passwordConfirmField;
    Button register;

    String email;
    String passwordEntered;
    String confirmPasswordEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        passwordConfirmField = findViewById(R.id.confirmPasswordField);

        register = findViewById(R.id.signUpButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailField.getText().toString();
                passwordEntered = passwordField.getText().toString();
                confirmPasswordEntered = passwordConfirmField.getText().toString();

//                if(isConnected()){
//                    //Do store user info
//                }
            }
        });

//        auth.createUserWithEmailAndPassword(email, passwordEntered)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = auth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });


    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        //updateUI(currentUser);
    }
}
