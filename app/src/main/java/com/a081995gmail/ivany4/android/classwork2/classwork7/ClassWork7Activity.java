package com.a081995gmail.ivany4.android.classwork2.classwork7;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.a081995gmail.ivany4.android.R;

public class ClassWork7Activity extends AppCompatActivity {
private boolean isOneVisibal = true;
private static final  String  Shared_Preff_Name = "name";
    private static final  String  Key_Name = "name";
    private  SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work7);

        sharedPreferences = getSharedPreferences(Shared_Preff_Name, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(Key_Name,"hello").apply();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    changeFragment();
                Log.d("aaaaaaa","dddddddd");

            }
        });
//        if (savedInstanceState == null){
//            showFragment(OneFragment.getInstance());
//        }
//
//        }
//    }
//    private  void changeFragment(){
//        if(isOneVisibal){
//            showFragment(TwoFragment.getInstance());
//            isOneVisibal = false;
//        }else{
//            showFragment(OneFragment.getInstance());
//            isOneVisibal = true;
//        }


    }
    private  void showFragment(android.support.v4.app.Fragment fragment, boolean addToBackStack){

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();



        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(fragment.getTag());
      //  if(addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass())
                fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String text = sharedPreferences.getString(Key_Name,"");
        Log.e("aaa","text = " + text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putString(Key_Name,"Hello").apply();
    }
}
