package com.a081995gmail.ivany4.android.classwork2.homework6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HomeWork6Activity extends AppCompatActivity {
    String json;
    private List<JsonModel> jsonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String json = null;
        JSONArray jsonArray = null;
        String jsonFileContent = null;
        try {
            jsonFileContent = readFile("People.json");
            Log.e("Json",jsonFileContent);
            Gson gson = new Gson();
            JsonModel j = gson.fromJson(jsonFileContent,JsonModel.class);
            List<JsonModel.Person> name = new ArrayList<>();

            name.addAll(j.getPeople());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readFile(String fileName) throws IOException
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
}
