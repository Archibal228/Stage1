package com.a081995gmail.ivany4.android.classwork2.homework6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.a081995gmail.ivany4.android.R;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HomeWork6Activity extends AppCompatActivity {
    private List<JsonModel.Person> people = new ArrayList<>();
    RecyclerView personList;
    PeopleAdapter peopleAdapter;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work6);
        search = findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());

            }
        });

        JSONArray jsonArray = null;
        String jsonFileContent = null;
        try {
            jsonFileContent = readFile("People.json");
            Log.e("Json",jsonFileContent);
            Gson gson = new Gson();
            JsonModel j = gson.fromJson(jsonFileContent,JsonModel.class);
            people.addAll(j.getPeople());
            initData(people);

        } catch (IOException e) {
            e.printStackTrace();
        }
        personList = findViewById(R.id.list_people);
        personList.setAdapter(peopleAdapter);
        personList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void filter(String s){
        ArrayList<JsonModel.Person> searchList = new ArrayList<>();
        for (JsonModel.Person person : people){
            if(person.getName().toLowerCase().contains(s.toLowerCase())) {
                searchList.add(person);
            }
        }
        peopleAdapter.setItems(searchList);
    }

    private String readFile(String fileName) throws IOException
    {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));
        String content = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            content = content + line;
        }
        return content;
    }
    private void initData(List<JsonModel.Person> people){
        peopleAdapter = new PeopleAdapter();
        peopleAdapter.setItems(people);

    }
}
