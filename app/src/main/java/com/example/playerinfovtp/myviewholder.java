package com.example.playerinfovtp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder
{
   ImageView img;
   TextView t1,t2,t3,t4,t5;
    public myviewholder(@NonNull View itemView)
    {
        super(itemView);
//        ima=itemView.findViewById(R.id.court_img);
        img=(ImageView)itemView.findViewById(R.id.img1);
        t1=(TextView)itemView.findViewById(R.id.t1);
        t2=(TextView)itemView.findViewById(R.id.t2);
        t3=(TextView)itemView.findViewById(R.id.t3);
        t4=(TextView)itemView.findViewById(R.id.t4);
        t5=(TextView)itemView.findViewById(R.id.t5);

    }
}
