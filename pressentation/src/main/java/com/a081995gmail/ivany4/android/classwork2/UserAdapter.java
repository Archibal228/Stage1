package com.a081995gmail.ivany4.android.classwork2;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a081995gmail.ivany4.android.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archibal on 23.02.2018.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> itemList = new ArrayList<>();
    private  onUserClickListener listener;

    public void setItems (List<User> itemList){
       this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();//метод заставляет перерисовать элементы
    }

    public void setListener (onUserClickListener listener){
        this.listener = listener;
    }

    //Создаёт холдер который содержит layout - xml , он кешируется, т.е.
    //для разных позиций может использоваться один и тот же
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new Holder(view);
    }
//вызывается для каждого элемента, используется для заполнения данных item - один элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
Holder meHolder = (Holder)holder;
final User user = itemList.get(position);
meHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (listener != null) listener.onClick(user,position);
    }
});
Glide.with(meHolder.imageView.getContext()).load("https://ldpr.ru/static/uploads/6dce5a7c9e_IMG_1833.JPG").into(meHolder.imageView); //Glid!!!!!!!!!!
meHolder.nameTextView.setText(user.getName());
meHolder.sunameTextView.setText(user.getSuname());
    }
//размер
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class Holder extends RecyclerView.ViewHolder{
ImageView imageView;
TextView nameTextView;
TextView sunameTextView;
        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter", "Holder");
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView= itemView.findViewById(R.id.nameTextView);
            sunameTextView= itemView.findViewById(R.id.nameTextView2);

        }
    }
    interface  onUserClickListener{
        void onClick(User user, int position);
    }
}
