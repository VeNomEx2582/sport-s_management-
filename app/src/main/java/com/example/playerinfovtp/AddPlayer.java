package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddPlayer extends AppCompatActivity {


    TextInputEditText name, clas, div, sportc, phone, whatsapp, mail;
    Button ad, send;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        name = (TextInputEditText) findViewById(R.id.addname);
        clas = (TextInputEditText) findViewById(R.id.addclass);
        div = (TextInputEditText) findViewById(R.id.adddiv);
        sportc = (TextInputEditText) findViewById(R.id.aakash);
        phone = (TextInputEditText) findViewById(R.id.addmobile);
        mail = (TextInputEditText) findViewById(R.id.addmail);
        whatsapp = (TextInputEditText) findViewById(R.id.whatsappno);
        ad = (Button) findViewById(R.id.btnaddstudent);

        db = new DBHelper(this);

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(AddPlayer.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendMeaasge();
                } else {
                    ActivityCompat.requestPermissions(AddPlayer.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }


                String nam = name.getText().toString();
                String cl = clas.getText().toString();
                String di = div.getText().toString();
                String sport = sportc.getText().toString();
                String phon = phone.getText().toString();
                String mai = mail.getText().toString();
                String whats = whatsapp.getText().toString();


                if (nam.equals("") || cl.equals("") || di.equals("") || sport.equals("") || phon.equals("") || mai.equals("") || whats.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter All the Fill...", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkDatastudent = db.insertDatastudent(nam, cl, di, sport, phon, mai, whats);
                    if (checkDatastudent == true) {
                        Toast.makeText(AddPlayer.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddPlayer.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void sendMeaasge() {
        String nam = name.getText().toString();
        String sport = sportc.getText().toString();
        String phon = phone.getText().toString();
        String mai = mail.getText().toString();


        if (!nam.equals("") && !nam.equals("") && !sport.equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phon, null, "Register Successfully . Your Name - " + nam + " Email -" + mai + " Sport - " + sport + ".", null, null);
            Toast.makeText(this, "Sms sent successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please Enter All the Fill", Toast.LENGTH_SHORT).show();
        }



    }
    public void arrowback (View view){
        Intent i = new Intent(getApplicationContext(), PlayerAcivity.class);
        startActivity(i);
    }
}
