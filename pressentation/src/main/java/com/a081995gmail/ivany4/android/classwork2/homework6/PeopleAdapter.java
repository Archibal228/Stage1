package com.a081995gmail.ivany4.android.classwork2.homework6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a081995gmail.ivany4.android.R;

import java.util.ArrayList;
import java.util.List;


public class PeopleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<JsonModel.Person> itemList = new ArrayList<>();

    public void setItems (List<JsonModel.Person> itemList){
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();//метод заставляет перерисовать элементы
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false);
return  new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder myHolder = (Holder) holder;
        final JsonModel.Person person = itemList.get(position);
        myHolder.id.setText(String.valueOf(person.getId()));
        myHolder.name.setText(person.getName());
        myHolder.lastname.setText(person.getSurname());
        myHolder.age.setText(String.valueOf(person.getAge()));
        myHolder.isDDegree.setText(String.valueOf(person.getIsDegree()));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    static  class Holder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        TextView lastname;
        TextView age;
        TextView isDDegree;
        public Holder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.id_person);
            name = itemView.findViewById(R.id.name_person);
            lastname = itemView.findViewById(R.id.lastname_person);
            age = itemView.findViewById(R.id.age_person);
            isDDegree = itemView.findViewById(R.id.degree);

        }

    }
}
