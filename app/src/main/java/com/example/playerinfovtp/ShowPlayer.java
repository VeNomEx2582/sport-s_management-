package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowPlayer extends AppCompatActivity {


    DBHelper DB;
    RecyclerView recyclerView;
    ArrayList<String> id,name,clas,div,sport,phone,mail,address;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_player);

        DB = new DBHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        clas = new ArrayList<>();
        div = new ArrayList<>();
        sport =new ArrayList<>();
        phone = new ArrayList<>();
        mail = new ArrayList<>();
        address = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerV);
        adapter = new MyAdapter(this,id,name,clas,div,sport,phone,mail,address);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Entery Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                clas.add(cursor.getString(2));
                div.add(cursor.getString(3));
                sport.add(cursor.getString(4));
                phone.add(cursor.getString(5));
                mail.add(cursor.getString(6));
                address.add(cursor.getString(7));
            }
        }
    }

    public void arrowback(View view) {
        Intent i = new Intent(getApplicationContext(), PlayerAcivity.class);
        startActivity(i);
    }
}