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

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.viewHolder> {
    private ArrayList<Recyclerdataclass> recyclerdataclassArrayList;

    public recyclerAdapter(ArrayList<Recyclerdataclass> recyclerdataclassArrayList) {
        this.recyclerdataclassArrayList = recyclerdataclassArrayList;
    }
    public recyclerAdapter(String[] strdata) {
        this.strdata = strdata;
    }

    String strdata[];


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.transfermoneyrecouscefile,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Recyclerdataclass recyclerdataclass=recyclerdataclassArrayList.get(position);
        holder.img_contact.setImageResource(recyclerdataclass.getImage());
        holder.tv_mtomobile.setText(recyclerdataclass.getText());

    }

    @Override
    public int getItemCount() {
        return recyclerdataclassArrayList.size();

    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView img_contact;
        TextView tv_mtomobile;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img_contact=(ImageView) itemView.findViewById(R.id.img_contact);
            tv_mtomobile=(TextView) itemView.findViewById(R.id.tv_mtomobile);
        }
    }
}
