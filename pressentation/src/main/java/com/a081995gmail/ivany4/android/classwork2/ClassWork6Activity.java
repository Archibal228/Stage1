package com.a081995gmail.ivany4.android.classwork2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.a081995gmail.ivany4.android.R;

import java.util.ArrayList;
import java.util.List;

public class ClassWork6Activity extends AppCompatActivity {
    private RecyclerView recyclerViewl;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work6);

        List<User> userList = new ArrayList<>();
        userList.add(new User("", "User1 ", "Surname1"));
        userList.add(new User("", "User2 ", "Surname2"));
        userList.add(new User("", "User3 ", "Surname3"));
        userList.add(new User("", "User4 ", "Surname4"));
        userList.add(new User("", "User5 ", "Surname5"));
        userAdapter = new UserAdapter();
        userAdapter.setItems(userList);
        recyclerViewl = findViewById(R.id.recycle);
        recyclerViewl.setAdapter(userAdapter);
        recyclerViewl.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewl.setHasFixedSize(true);
        userAdapter.setListener(new UserAdapter.onUserClickListener() {
            @Override
            public void onClick(User user, int position) {
                Toast.makeText(ClassWork6Activity.this, user.getName() + position, Toast.LENGTH_SHORT).show();;
            }
        });
    }
}
