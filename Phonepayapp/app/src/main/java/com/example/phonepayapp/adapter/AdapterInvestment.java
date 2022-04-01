package com.example.phonepayapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonepayapp.R;
import com.example.phonepayapp.model.Investmentmodelclass;
import com.example.phonepayapp.model.StoreModel;

import java.util.ArrayList;

public class AdapterInvestment extends RecyclerView.Adapter<AdapterInvestment.Viewholder> {
    private ArrayList<Investmentmodelclass> Investementmodelarrylist;


    public AdapterInvestment(ArrayList<Investmentmodelclass> Investementmodelarrylist) {
        this.Investementmodelarrylist = Investementmodelarrylist;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.resourcetopfundsinvestment,parent,false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Investmentmodelclass investmentmodelclass = Investementmodelarrylist.get(position);
        holder.imgbankprofile.setImageResource(investmentmodelclass.getBankimage());

        holder.tv_bankname.setText(investmentmodelclass.getBankname());
        holder.tv_qualityvalue.setText(investmentmodelclass.getBankqualityvalue());
        holder.tv_byreturn.setText(investmentmodelclass.getBankreturn());
        holder.tv_returnpersent.setText(investmentmodelclass.getBanklreturnpersent());
        holder.tv_returndate.setText(investmentmodelclass.getBankreturndate());
        holder.tv_minamount.setText(investmentmodelclass.getBankminamount());



    }

    @Override
    public int getItemCount() {
        return Investementmodelarrylist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgbankprofile;
        TextView tv_bankname,tv_qualityvalue,tv_byreturn,tv_returnpersent,tv_returndate,tv_minamount,tv_amountvalue;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgbankprofile=(ImageView) itemView.findViewById(R.id.imgbankprofile);
            tv_bankname=(TextView) itemView.findViewById(R.id.tv_bankname);
            tv_qualityvalue=(TextView) itemView.findViewById(R.id.tv_qualityvalue);
            tv_byreturn=(TextView) itemView.findViewById(R.id.tv_byreturn);
            tv_returnpersent=(TextView) itemView.findViewById(R.id.tv_returnpersent);
            tv_returndate=(TextView) itemView.findViewById(R.id.tv_returndate);
            tv_minamount=(TextView) itemView.findViewById(R.id.tv_minamount);
            tv_amountvalue=(TextView) itemView.findViewById(R.id.tv_amountvalue);



        }
    }
}
