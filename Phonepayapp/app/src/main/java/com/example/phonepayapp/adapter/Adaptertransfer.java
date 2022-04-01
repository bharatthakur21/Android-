package com.example.phonepayapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonepayapp.R;
import com.example.phonepayapp.model.Recyclerdataclass;

import java.util.ArrayList;

public class Adaptertransfer extends RecyclerView.Adapter<Adaptertransfer.holder> {


    private ArrayList<Recyclerdataclass> recyclerdataclassArrayList;
    String data[];

    public Adaptertransfer(ArrayList<Recyclerdataclass> recyclerdataclassArrayList) {
    this.recyclerdataclassArrayList = recyclerdataclassArrayList;
    }

    public Adaptertransfer(String[] data) {
        this.data = data;
    }




    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.transfermoneyrecouscefile,parent,false);
        holder holder=new holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        Recyclerdataclass recyclerdataclass = recyclerdataclassArrayList.get(position);
        holder.img_contact.setImageResource(recyclerdataclass.getImage());
        holder.tv_mtomobile.setText(recyclerdataclass.getText());




    }

    @Override
    public int getItemCount() {
        return recyclerdataclassArrayList.size();
    }


    public class holder extends RecyclerView.ViewHolder {
        ImageView img_contact;
        TextView tv_mtomobile;
        public holder(@NonNull View itemView) {
            super(itemView);
            img_contact=(ImageView) itemView.findViewById(R.id.img_contact);
            tv_mtomobile=(TextView) itemView.findViewById(R.id.tv_mtomobile);

        }
    }


}
