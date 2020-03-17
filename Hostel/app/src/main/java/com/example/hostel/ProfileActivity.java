package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.sql.DatabaseMetaData;

public class ProfileActivity extends AppCompatActivity {

    EditText editTextName,editTextMobileNo,editTextCity,editTextCollege,editTextCource;
    Button button;
    ImageButton imageButton;


    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

   // FirebaseStorage storage;        //storage will be used to create a FirebaseStorage instance
   // StorageReference storageReference;   //storageReference will point to the uploaded file




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextName=(EditText) findViewById(R.id.name);
        editTextMobileNo=(EditText) findViewById(R.id.mobile);
        editTextCity=(EditText) findViewById(R.id.city);
        editTextCollege=(EditText) findViewById(R.id.college);
        editTextCource=(EditText) findViewById(R.id.course);

        imageButton=(ImageButton) findViewById(R.id.user_profile_photo);
        button=(Button) findViewById(R.id.button);
        databaseReference= FirebaseDatabase.getInstance().getReference("userInfomation");
        firebaseAuth=FirebaseAuth.getInstance();






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUserProfile();
            }
        });



    }



    private void AddUserProfile() {

            String name = editTextName.getText().toString().trim();
            String mobileNo = editTextMobileNo.getText().toString().trim();
            String city = editTextCity.getText().toString().trim();
            String college = editTextCollege.getText().toString().trim();
            String cource = editTextCource.getText().toString().trim();

        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            editTextName.requestFocus();
            return;
        }
        else if (college.isEmpty()) {
            editTextCollege.setError("college is required");
            editTextCollege.requestFocus();
            return;
        }
        else if (mobileNo.isEmpty()) {
            editTextMobileNo.setError("Mobile no is required");
            editTextMobileNo.requestFocus();
            return;
        }

        else if (city.isEmpty()) {
            editTextCity.setError("city is required");
            editTextCity.requestFocus();
            return;
        }
        if (cource.isEmpty()) {
            editTextCource.setError("Password is required");
            editTextCource.requestFocus();
            return;
        }










        UserInfo uinfo=new UserInfo(
                    name,
                    city,
                    college,
                    cource
                    ,mobileNo
            );


            FirebaseDatabase.getInstance().getReference("userInformation")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(uinfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(ProfileActivity.this,"Data uploded successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ProfileActivity.this,admission_activity.class);
                    startActivity(intent);
                }
            });




        }
}


