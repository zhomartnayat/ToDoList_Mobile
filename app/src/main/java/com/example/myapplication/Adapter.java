package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<MyItems> myItems;
    public Adapter(Context c,ArrayList<MyItems> items){
        this.context=c;
        this.myItems=items;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item,parent , false));
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.itemtitle.setText(myItems.get(position).getItemtitle());
      holder.itemdesc.setText(myItems.get(position).getItemdesc());
      holder.itemdate.setText(myItems.get(position).getItemdate());
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
            TextView itemtitle,itemdesc,itemdate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
         itemtitle=itemView.findViewById(R.id.title_of_item);
             itemdesc=itemView.findViewById(R.id.desc);
             itemdate=itemView.findViewById(R.id.data_of_item);

        }
    }
}
