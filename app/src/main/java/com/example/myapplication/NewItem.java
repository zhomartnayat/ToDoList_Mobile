package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Random;

public class NewItem extends AppCompatActivity {
    TextView itemtitle,itemdesc,itemdate;
    EditText inputtitle,inputdesc,inputdate;
    Button btn_SaveTask,btn_Cancel;
    DatabaseReference reference;
    Integer collectionNum=new Random().nextInt();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        itemtitle=findViewById(R.id.title_of_item);
        itemdesc=findViewById(R.id.desc);
        itemdate=findViewById(R.id.data_of_item);
        inputtitle=findViewById(R.id.inputtitle);
        inputdesc=findViewById(R.id.inputdesc);
        inputdate=findViewById(R.id.inputdate);
        btn_SaveTask=findViewById(R.id.btn_savetask);
        btn_Cancel=findViewById(R.id.btn_cancel);
        btn_SaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                reference= FirebaseDatabase.getInstance().getReference().child("New items").child("Item"+collectionNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("itemdate").setValue(inputtitle.getText().toString());
                        dataSnapshot.getRef().child("itemdesc").setValue(inputdesc.getText().toString());
                        dataSnapshot.getRef().child("itemdate").setValue(inputdate.getText().toString());
                        Intent a=new Intent(NewItem.this,MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
