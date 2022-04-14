package com.example.recyclerprogramdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.holder>{


    String names[];
    private bharatnewint callinterface;

    public RecyclerAdapter(String[] names, bharatnewint callinterface) {
        this.names = names;
        this.callinterface = callinterface;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.recourcedesignfile,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.btn_Projectname.setText(names[position]);
        holder.btn_Projectname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callinterface.newmethod(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.length;
    }


    class holder extends RecyclerView.ViewHolder
    {
        Button btn_Projectname;
        public holder(@NonNull View itemView) {
            super(itemView);
            btn_Projectname =  itemView.findViewById(R.id.btn_Projectname);
        }
    }
    public interface bharatnewint {
        void newmethod (int position);
    }
}
