package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlendMode;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{

    FirebaseAuth mAuth;
    EditText editTextemail,editTextPassword;
    ProgressBar progressBar;
    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();


        editTextemail =(EditText)findViewById(R.id.editText);
        editTextPassword=(EditText) findViewById(R.id.editText2);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        findViewById(R.id.textView2).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

    }


    private void userlogin() {

        String email = editTextemail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextemail.setError("Please Enter valid Email");
            editTextemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Password is too small");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);

                if(task.isSuccessful()) {
                   finish();                       //not come back to the login page
                    Intent intent=new Intent(MainActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    //clear all previous activity
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    //if user already logged in


   /* @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser()!=null) {      //user already logged in
            //finish();
            startActivity(new Intent(this,ProfileActivity.class));  //start profile activity
        }

    }
*/
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.textView2:
                finish();
                startActivity(new Intent(this,signup.class));
                break;


            case R.id.button2:
                userlogin();

                break;
        }
    }
}
