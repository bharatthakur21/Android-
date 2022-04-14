package com.smt.livway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smt.livway.apipacakage.RecyclerResponseclass;
import com.smt.livway.databinding.HistorypageresouscefileBinding;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.viewHolder> {

    private ArrayList<RecyclerResponseclass.Datum> recyclerdataclassArrayList;
    String data[];



    private Context mContext;

    public HistoryAdapter(Context context, ArrayList<RecyclerResponseclass.Datum> recyclerdataclassArrayList) {
        this.recyclerdataclassArrayList = recyclerdataclassArrayList;
        this.mContext=context;
    }

    public HistoryAdapter(String[] data) {
        this.data = data;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.historypageresouscefile,parent,false);
        HistorypageresouscefileBinding binding = HistorypageresouscefileBinding.inflate(LayoutInflater.from(mContext),parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return new viewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        RecyclerResponseclass.Datum dataModelClass = recyclerdataclassArrayList.get(position);
        holder.binding.textviewName.setText(dataModelClass.getFirstName() +"  "+dataModelClass.getLastName());
        holder.binding.textViewNumber.setText(dataModelClass.getMobileNumber());
        holder.binding.textViewAddress.setText(dataModelClass.getAddress()+" "+dataModelClass.getApartment()+" "+dataModelClass.getCity()+" "+dataModelClass.getCountry());


    }

    @Override
    public int getItemCount() {
        return recyclerdataclassArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        HistorypageresouscefileBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding=HistorypageresouscefileBinding.bind(itemView);
        }
    }
}
