package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UpdatePlayer extends AppCompatActivity {

    TextInputEditText id,name,clas,div,sport,phone,address,mail;
    DBHelper db;
    Button show,up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_player);

        id = (TextInputEditText) findViewById(R.id.addidup);
        name = (TextInputEditText) findViewById(R.id.addnameup);
        clas = (TextInputEditText) findViewById(R.id.addclassup);
        div = (TextInputEditText) findViewById(R.id.adddivup);
        sport = (TextInputEditText) findViewById(R.id.aakashu);
        phone = (TextInputEditText) findViewById(R.id.addmobileup);
        mail = (TextInputEditText) findViewById(R.id.addmailup);
        address = (TextInputEditText) findViewById(R.id.addaddressup);
        show = (Button) findViewById(R.id.btnshowup);
        up = (Button) findViewById(R.id.btnupdateup) ;
        db = new DBHelper(this);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String idi = id.getText().toString();
                boolean fine1=true;
                if(idi.equals("")){
                    id.setError("Enter id");
                }
                else {
                    try{
                        String ID = id.getText().toString();
                        long id = Long.parseLong(ID);
                        String namaa=db.getName(id);
                        String classs=db.getClas(id);
                        String divv=db.getDiv(id);
                        String sports=db.getSport(id);
                        String mobileno=db.getMobile(id);
                        String maill=db.getMail(id);
                        String addresss=db.getAddress(id);
                        name.setText(namaa);
                        clas.setText(classs);
                        div.setText(divv);
                        sport.setText(sports);
                        phone.setText(mobileno);
                        mail.setText(maill);
                        address.setText(addresss);
                    }
                    catch (Exception ex)
                    {
                        fine1=false;
                        //Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "No Records...", Toast.LENGTH_SHORT).show();
                    }
                    finally {
                        if(fine1) {
                            Toast.makeText(getApplicationContext(), "Records Show Successfully...", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                sendmail();
//                sendMessage();


                boolean fine2 = true;
                try {
                    String nam = name.getText().toString();
                    String cal = clas.getText().toString();
                    String di = div.getText().toString();
                    String spor = sport.getText().toString();
                    String phon = phone.getText().toString();
                    String mai = mail.getText().toString();
                    String addres = address.getText().toString();
                    //db.SaveData(first,last);
                    String ID = id.getText().toString();
                    long id = Long.parseLong(ID);
                    db.UpdateDetail(id,nam, cal, di,spor, phon,mai,addres);
                }
                catch (Exception ex){
                    fine2=false;
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }
                finally {
                    if(fine2){
                        Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void arrowback(View view) {
        Intent intent = new Intent(UpdatePlayer.this, PlayerAcivity.class);
        startActivity(intent);
    }
}