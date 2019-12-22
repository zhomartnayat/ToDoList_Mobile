package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView item_title,item_desc,item_date;
    DatabaseReference reference ;
    ArrayList<MyItems> myItems;
    Button btnAddNew;
    Adapter adapter;
    RecyclerView ouritems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item_title=findViewById(R.id.title_of_item);
        item_desc=findViewById(R.id.desc);
        item_date=findViewById(R.id.data_of_item);
        btnAddNew=findViewById(R.id.btnAddNewItem);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this,NewItem.class);
                startActivity(a);
            }
        });


        ouritems=findViewById(R.id.ouritems);
        ouritems.setLayoutManager(new LinearLayoutManager(this));
        myItems=new ArrayList<MyItems>();

        reference= FirebaseDatabase.getInstance().getReference().child("ToDoList");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                        MyItems items=dataSnapshot1.getValue(MyItems.class);
                        myItems.add(items);
                    }
                    adapter=new Adapter(MainActivity.this,myItems);
                    ouritems.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"No Data in Database",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
