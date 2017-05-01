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

public class Loginactivity extends Activity {

    private EditText txtEmailLogin;
    private EditText txtPwd;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        txtEmailLogin = (EditText) findViewById(R.id.emaillogin);
        txtPwd = (EditText) findViewById(R.id.pwdlogin);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void logbtn_Click(View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(Loginactivity.this, "Please Wait..", "Processing..", true);


        firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(), txtPwd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

               // if (task.isSuccessful()) {
                    Toast.makeText(Loginactivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Loginactivity.this, NavigationActivity.class);
                    //i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);
               // }
//                else{
//                    Log.e("Error", task.getException().toString());
//                    Toast.makeText(Loginactivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}
