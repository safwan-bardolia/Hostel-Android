package com.example.hostel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    int pos;



    public SliderAdapter(Context context) {
        this.context=context;
    }

    public int[] slide_images ={
            R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3
    };

    public String[] slide_headings = {
            "DELUX",
            "SEMI DELUX",
            "Dormitory"
    };

    public String[] slide_descrpition ={
            "(Fees Rs.26000 Per year) 2 student  in  room with small window.1.Free WIFI service,2.free laundry service,3.RO water filter,4.solar water heater,5.TV for Entertainment",
            "(Fees Rs.22000 Per year) 2 student  in  room with small window.1.free laundry service,2.RO water filter,3.solar water heater,4.TV for Entertainment",
            "(Fees Rs.16000 Per year) 2 student  in  room with small window.1.solar water heater,2.TV for Entertainment"


    };

    public String[] s1= {
            "Apply for Delux",
            "Apply for Semi-Delux",
            "Apply for Dormitory"

    };


    public int getCount() {
        return slide_headings.length;  //total no of slide
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) { //for sliding effect

        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView imageView=(ImageView) view.findViewById(R.id.slideImageView);
        TextView slideHeading=(TextView) view.findViewById(R.id.slideHeading);
        TextView slideDes=(TextView) view.findViewById(R.id.slideDescription);
        TextView but=(TextView) view.findViewById(R.id.register);

        imageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDes.setText(slide_descrpition [position]);
        but.setText(s1 [position]);





        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(position==0) {
                        Toast.makeText(context, "delux", Toast.LENGTH_SHORT).show();

                    }
                    else if (position==1) {
                        Toast.makeText(context, "semi-delux", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context, "Dormitory", Toast.LENGTH_SHORT).show();

                    }
            }
        });

        container.addView(view);

        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}



