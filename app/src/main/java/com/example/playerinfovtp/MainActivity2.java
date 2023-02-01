package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView img;
    TextView tv1,tv2,tv3,tv4,tv5;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


//        ima=findViewById(R.id.court_img);
        img=(ImageView)findViewById(R.id.desc_img);
        tv1=(TextView)findViewById(R.id.desc_header);
        tv2=(TextView)findViewById(R.id.desc_desc);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);

        btn= (Button) findViewById(R.id.btn);

//        ima.setImageResource(getIntent().getIntExtra("courtimg",0));
        img.setImageResource(getIntent().getIntExtra("imagename",0));
        tv1.setText(getIntent().getStringExtra("header"));
        tv2.setText(getIntent().getStringExtra("desc"));
        tv3.setText(getIntent().getStringExtra("tv3"));
        tv4.setText(getIntent().getStringExtra("tv4"));
        tv5.setText(getIntent().getStringExtra("tv5"));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddPlayer.class);
                startActivity(intent);
            }
        });


    }
    public void arrowback(View view) {
        Intent i = new Intent(this,HomeAcivity.class);
        startActivity(i);
    }
}