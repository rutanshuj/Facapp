package com.example.laksh_pc.facapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registrationactivity extends Activity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationactivity);
        txtEmailAddress = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.pwdtxt);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void rgtbtn_Click(View v)    {

        final ProgressDialog progressDialog = ProgressDialog.show(Registrationactivity.this, "Please wait..", "Processing.." ,true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(), txtPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()) {
                    Toast.makeText(Registrationactivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Registrationactivity.this, Loginactivity.class);
                    startActivity(i);
                } else {
                    Log.e("Error", task.getException().toString());
                    Toast.makeText(Registrationactivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
