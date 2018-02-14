package classwork2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.a081995gmail.ivany4.android.R;

import hw1.Singlton;

/**
 * Created by Archibal on 09.02.2018.
 */

public class classwork2Activity extends AppCompatActivity {
    public static final String KEY_TEXT = "KEY_TEXT";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classwork2_activity);
        String text = getIntent().getStringExtra(KEY_TEXT);

        }
    }

//    @Override
//    public void onBackPressed() {
//
//    }

