package com.example.apiapplication;

import static com.example.apiapplication.APICall.MODEL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Set;

public class ColorSwitch extends AppCompatActivity {
    TextView textView;
    TextView imageView[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_switch);
        textView = (TextView) findViewById(R.id.textView);
        TextView imageView[] = {
                (TextView) findViewById(R.id.imageView),
                (TextView) findViewById(R.id.imageView2),
                (TextView) findViewById(R.id.imageView3),
                (TextView) findViewById(R.id.imageView4),
                (TextView) findViewById(R.id.imageView5)


        };
        FloatingActionButton butt = findViewById(R.id.floatingActionButton);
        Activity activity = this;
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APICall call = new APICall();
                call.Retrieval(activity);

                for(int i = 0; i < MODEL.size(); i++)
                {
                    Model model = MODEL.get(i);
                    String temp[] = model.getPalette();
                    for(int j = 0; j < temp.length; j++)
                    {
                        textView.append(temp[j] + " ");
                        imageView[j].setBackgroundColor(Color.parseColor(temp[j]));
                    }

                }

            }
        });
    }
}