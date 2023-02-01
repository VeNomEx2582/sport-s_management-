package com.example.playerinfovtp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id_id, name_id, clas_id,div_id,sport_id, phone_id,mail_id, addres_id;


    public MyAdapter(Context context,ArrayList id_id, ArrayList name_id, ArrayList clas_id, ArrayList div_id,ArrayList sport_id, ArrayList phone_id,ArrayList mail_id, ArrayList addres_id) {
        this.context = context;
        this.id_id = id_id;
        this.name_id = name_id;
        this.clas_id = clas_id;
        this.div_id = div_id;
        this.sport_id = sport_id;
        this.phone_id = phone_id;
        this.mail_id = mail_id;
        this.addres_id = addres_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id_id.setText(String.valueOf(id_id.get(position)));
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.clas_id.setText(String.valueOf(clas_id.get(position)));
        holder.div_id.setText(String.valueOf(div_id.get(position)));
        holder.sport_id.setText(String.valueOf(sport_id.get(position)));
        holder.phone_id.setText(String.valueOf(phone_id.get(position)));
        holder.mail_id.setText(String.valueOf(mail_id.get(position)));
        holder.addres_id.setText(String.valueOf(addres_id.get(position)));
    }
    @Override
    public int getItemCount() {
        return id_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_id,name_id,clas_id, div_id,sport_id, phone_id,mail_id, addres_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_id = itemView.findViewById(R.id.id);
            name_id = itemView.findViewById(R.id.name);
            clas_id = itemView.findViewById(R.id.std);
            div_id = itemView.findViewById(R.id.div);
            sport_id = itemView.findViewById(R.id.aakash);
            phone_id = itemView.findViewById(R.id.mobile);
            mail_id = itemView.findViewById(R.id.mail);
            addres_id = itemView.findViewById(R.id.address);
        }
    }
}
