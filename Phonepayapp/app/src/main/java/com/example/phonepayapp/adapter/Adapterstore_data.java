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
import com.example.phonepayapp.model.StoreModel;

import java.util.ArrayList;

public class Adapterstore_data extends RecyclerView.Adapter<Adapterstore_data.ViewHolder> {
    private ArrayList<StoreModel> storeModelArrayList;


    public Adapterstore_data(ArrayList<StoreModel> storeModelArrayList) {
        this.storeModelArrayList = storeModelArrayList;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.storedesignresource,parent,false);
        ViewHolder  viewHolder  = new ViewHolder(view);
        return   viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreModel storeModel = storeModelArrayList.get(position);
        holder.profile_image.setImageResource(storeModel.getStoreImage());

        holder.tv_Storename.setText(storeModel.getStoreType());
        holder.tv_StoreType.setText(storeModel.getStoreName());
        holder.tv_StoreTiming.setText(storeModel.getStoreDetail());
        holder.tv_Storerating.setText(storeModel.getStoreRating());
        holder.tv_ratingvalue.setText(storeModel.getStoreRatingCount());





    }

    @Override
    public int getItemCount() {
        return storeModelArrayList.size();
    }

    public class  ViewHolder extends  RecyclerView.ViewHolder{
         ImageView profile_image,img_comment,img_Storeratingstar;
         TextView tv_Storename,tv_StoreType,tv_StoreTiming,tv_Storerating,tv_ratingvalue;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             profile_image=(ImageView) itemView.findViewById(R.id.profile_image);
             img_comment=(ImageView) itemView.findViewById(R.id.img_comment);
             img_Storeratingstar=(ImageView) itemView.findViewById(R.id.img_Storeratingstar);
             tv_Storename=(TextView) itemView.findViewById(R.id.tv_Storename);
             tv_StoreType=(TextView) itemView.findViewById(R.id.tv_StoreType);
             tv_StoreTiming=(TextView) itemView.findViewById(R.id.tv_StoreTiming);
             tv_Storerating=(TextView) itemView.findViewById(R.id.tv_Storerating);
             tv_ratingvalue=(TextView) itemView.findViewById(R.id.tv_ratingvalue);
             tv_Storename=(TextView) itemView.findViewById(R.id.tv_Storename);


         }

     }
}
