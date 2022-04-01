package com.example.phonepayapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonepayapp.R;
import com.example.phonepayapp.model.Historymodeldataclass;
import com.example.phonepayapp.model.StoreModel;

import java.util.ArrayList;

public class Adapterhistory_data extends RecyclerView.Adapter<Adapterhistory_data.ViewHolder>{
    private ArrayList<Historymodeldataclass>historymodelarraylist;


    public Adapterhistory_data(ArrayList<Historymodeldataclass> historymodelarraylist) {
        this.historymodelarraylist = historymodelarraylist;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.historydesignresource,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Historymodeldataclass historymodeldataclass= historymodelarraylist.get(position);
        holder.img_historyprofilimage.setImageResource(historymodeldataclass.getHistoryimg());
        holder.tv_paidto.setText(historymodeldataclass.getPaidto());
        holder.tv_paidamount.setText(historymodeldataclass.getPaidamount());

        holder.tv_paidloaction.setText(historymodeldataclass.getPaidloaction());

        holder.tv_paidtime.setText(historymodeldataclass.getPaidtime());

        holder.tv_creditto.setText(historymodeldataclass.getCreditto());

    }

    @Override
    public int getItemCount() {
        return historymodelarraylist.size();
    }






    public  class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_historyprofilimage,img_sourceimage;
        TextView tv_paidto,tv_paidamount,tv_paidloaction,tv_paidtime,tv_creditto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_historyprofilimage=(ImageView) itemView.findViewById(R.id.img_historyprofilimage);
            img_sourceimage=(ImageView) itemView.findViewById(R.id.img_sourceimage);
            tv_paidto=(TextView) itemView.findViewById(R.id.tv_paidto);
            tv_paidamount=(TextView) itemView.findViewById(R.id.tv_paidamount);
            tv_paidloaction=(TextView) itemView.findViewById(R.id.tv_paidloaction);
            tv_paidtime=(TextView) itemView.findViewById(R.id.tv_paidtime);
            tv_creditto=(TextView) itemView.findViewById(R.id.tv_creditto);
        }
    }
}
