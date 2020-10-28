package com.moringa.geofood.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.geofood.R;

import java.util.concurrent.BlockingDeque;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = " ";

    @BindView(R.id.passwordLoginButton) Button mPasswordLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.registerTextView) TextView mRegisterTextView;

    //Variable of firebaseAuth
    private FirebaseAuth mLoginAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        //Instance of firebase auth
        mLoginAuth = FirebaseAuth.getInstance();

        mRegisterTextView.setOnClickListener(this);
        mPasswordLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mRegisterTextView){
            Intent register = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(register);
            finish();
        }

        if(v == mPasswordLoginButton){
            loginWithPassword();
        }

    }

    private void loginWithPassword(){
        String userEmail = mEmailEditText.getText().toString().trim();
        String userPassword = mPasswordEditText.getText().toString().trim();

        //if user email is empty
        if(userEmail.equals(" ")){
            mEmailEditText.setError("Please Enter your email");
            return;
        }

        if(userPassword.equals(" ")){
            mPasswordEditText.setError("Password Cannot be blank");
        }

        mLoginAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "Sign With Email :onComplete:" + task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.e(TAG, "onComplete: Sign InWith Email Failed", task.getException());
                    Toast.makeText(LoginActivity.this, "Error Occured:Try giving correct details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}