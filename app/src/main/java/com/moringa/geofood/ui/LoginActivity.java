package com.moringa.geofood.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;
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
    private  FirebaseAuth.AuthStateListener mAuthListener;

    //progressDialog
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        //Auth Progress Dialog method

        createAuthProgressDialog();

        //Instance of firebase auth
        mLoginAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Intent takeUserToMainActivityIfCredentialsAreTrue = new Intent(LoginActivity.this, MainActivity.class);
                    takeUserToMainActivityIfCredentialsAreTrue.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(takeUserToMainActivityIfCredentialsAreTrue);
                    finish();
                }
            }
        };



        mRegisterTextView.setOnClickListener(this);
        mPasswordLoginButton.setOnClickListener(this);
    }
    //Defining the method
    private void createAuthProgressDialog(){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Connecting.......");
        mProgressDialog.setMessage("Authorising with database........");
        mProgressDialog.setCancelable(false);
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
            mEmailEditText.setError("Please Enter correct email");
            return;
        }

        if(userPassword.equals(" ")){
            mPasswordEditText.setError("Password Cannot be blank");
        }

        mProgressDialog.show();
        mLoginAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mProgressDialog.dismiss();
                Log.d(TAG, "Sign With Email :onComplete:" + task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.e(TAG, "onComplete: Sign InWith Email Failed", task.getException());
                    Toast.makeText(LoginActivity.this, "Error Occurred:Try giving correct details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        mLoginAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mLoginAuth.removeAuthStateListener(mAuthListener);
        }
    }

}