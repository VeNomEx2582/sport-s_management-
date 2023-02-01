package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    TextInputEditText users,passs;
    Button sgin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        users = (TextInputEditText) findViewById(R.id.loginusername);
        passs = (TextInputEditText) findViewById(R.id.loginpassword);
        sgin = (Button) findViewById(R.id.btnnextlogin) ;
        DB = new DBHelper(this);


        sgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = users.getText().toString();
                String passwor = passs.getText().toString();

                if (user.equals("") ||passwor.equals("")){
//                    users.setError("Enter the Username");
//                    passs.setError("Enter the Password");
                    Toast.makeText(Login.this, "Please Enter All the Fields!", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean chechuserpass = DB.checkusernamepassword(user,passwor);
                    //user exists or not
                    if (chechuserpass == true){
                        Toast.makeText(Login.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, HomeAcivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(Login.this, "invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }

    public void signup(View view) {
        Intent intent = new Intent(this,Sign.class);
        startActivity(intent);

    }
}