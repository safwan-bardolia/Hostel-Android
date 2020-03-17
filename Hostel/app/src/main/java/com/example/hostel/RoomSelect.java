package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//onboarding screen

public class RoomSelect extends AppCompatActivity {

    private ViewPager mslidViewPager;
    TextView apply_but;
     int currentPage;

    private SliderAdapter sliderAdapter;
    Context context;
    public void getnextactivity() {
        Intent intent=new Intent(RoomSelect.this,last.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_select);

        mslidViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        apply_but=findViewById(R.id.apply);




        sliderAdapter=new SliderAdapter(this);

        mslidViewPager.setAdapter(sliderAdapter);







        /*
        ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage=position;


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };*/

    }

}


