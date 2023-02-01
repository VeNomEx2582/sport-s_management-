package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CourtDiagram extends AppCompatActivity {



    ImageView btMenu;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    public static void closerDrawer(DrawerLayout drawerLayout) {
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_diagram);

        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(new MainAdapter(this,HomeAcivity.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closerDrawer(drawerLayout);

    }

    public void youtube(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=iamDm4nxIlY&ab_channel=KhelNowTV");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube1(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=5e_0ux9qD50&ab_channel=GamerMania");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void youtube2(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=SFR2ipKamPs&ab_channel=SainaNehwal");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void youtube3(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=z_bSu7fajf0&ab_channel=UltimateKhoKho");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube4(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=31YF4oTUgp4&ab_channel=SonyLIV");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube5(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=eEWOmZfuZbA&ab_channel=WorldJudoGallery");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void youtube6(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=KCZXo1mDv-g&ab_channel=ActionClips.");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube7(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=CsvCbR6F52I&ab_channel=BRUTALTV");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube8(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=E0Xl1f-fXLo&ab_channel=TokyoStreetView-JapanTheBeautiful");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube9(View view) {
        Uri uri = Uri.parse("");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void youtube10(View view) {
    }
}