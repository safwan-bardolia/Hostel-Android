package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_LONG;

public class admission_activity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button apply;
    String add_room;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_activity);
        databaseReference= FirebaseDatabase.getInstance().getReference("userInfomation");
        firebaseAuth=FirebaseAuth.getInstance();

        radioGroup=findViewById(R.id.radio_grp);
        apply=findViewById(R.id.apply_btn);

        builder=new AlertDialog.Builder(this);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                if(radioId==R.id.dor_radi)
                {
                 add_room="Dormitory (Fees:18000)";
                    FirebaseDatabase.getInstance().getReference("userInformation/Room type")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(add_room).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            builder.setMessage("You have successfully registered with room: " + "Dormitory (Fees:18000)")
                                    .setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent=new Intent(admission_activity.this,last.class);
                                    startActivity(intent);
                                }
                            });


                        }
                    });
                    AlertDialog alert=builder.create();
                    alert.setTitle("Notification");
                    alert.show();

                }
                else if(radioId==R.id.semi_deluxradi)
                {
                    add_room="Semi-Delux(Fees:22000)";
                    FirebaseDatabase.getInstance().getReference("userInformation/Room type")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(add_room).addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            builder.setMessage("You have successfully registered with room: " + "Semi-Delux(Fees:22000)")
                                .setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent=new Intent(admission_activity.this,last.class);
                                        startActivity(intent);
                                    }
                                });

                        }
                    });

                    AlertDialog alert=builder.create();
                    alert.setTitle("Notification");
                    alert.show();

                }
                else
                {
                    add_room="Delux(Fees:26000)";
                    FirebaseDatabase.getInstance().getReference("userInformation/Room type")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(add_room).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            builder.setMessage("You have successfully registered with room: " + "Delux(Fees:26000)")
                                    .setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent=new Intent(admission_activity.this,last.class);
                                    startActivity(intent);
                                }
                            });

                        }
                    });

                    AlertDialog alert=builder.create();
                    alert.setTitle("Notification");
                    alert.show();

                }

            }
        });
    }
    public void openDialog(String msg){

    }

}
