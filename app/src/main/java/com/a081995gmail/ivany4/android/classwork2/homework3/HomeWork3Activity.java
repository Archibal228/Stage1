package com.a081995gmail.ivany4.android.classwork2.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.a081995gmail.ivany4.android.BuildConfig;
import com.a081995gmail.ivany4.android.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.leakcanary.LeakCanary;

public class HomeWork3Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btndwn;
    private EditText url;
    private ImageView dwn_pic;
    private TextView name_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work3);
       /* if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }*/
        btndwn = findViewById(R.id.dwn_btn);
        url = findViewById(R.id.url_text);
        dwn_pic = findViewById(R.id.dwn_img);
        btndwn.setOnClickListener(this);
        name_text = findViewById(R.id.name);

    }

    @Override
    public void onClick(View view) {
        //Picasso.with(this).load(url.getText().toString()).into(dwn_pic);
        Glide.with(this).load(url.getText().toString()).apply(RequestOptions.circleCropTransform()).into(dwn_pic);
        //img.setImageURI(url.getText().toString());
        name_text.setText(BuildConfig.API_ENDPOINT);
    }
}
