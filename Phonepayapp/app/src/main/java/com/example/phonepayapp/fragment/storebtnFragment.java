package com.example.phonepayapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.phonepayapp.R;
import com.example.phonepayapp.activity.MainActivity;
import com.example.phonepayapp.adapter.Adapterstore_data;
import com.example.phonepayapp.adapter.Adaptertransfer;
import com.example.phonepayapp.adapter.recyclerAdapter;
import com.example.phonepayapp.model.StoreModel;

import java.util.ArrayList;


public class storebtnFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Context context;
    private View view;
    RecyclerView recv_storedata;

    SearchView edt_searchstores;
    private Adapterstore_data storeAdapter;

    private ArrayList<StoreModel> storeList  = new ArrayList<>();

    public storebtnFragment() {
    }

    public static storebtnFragment newInstance(String param1, String param2) {
        storebtnFragment fragment = new storebtnFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_storebtn, container, false);
        recv_storedata=view.findViewById(R.id.recv_storedata);
        edt_searchstores=view.findViewById(R.id.edt_searchstores);
        recv_storedata.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        storeAdapter = new Adapterstore_data(storeList);
        recv_storedata.setAdapter(storeAdapter);
        edt_searchstores.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });
        initData();
        return  view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void initData() {
          StoreModel model1 = new StoreModel();
          model1.setStoreImage(R.drawable.img1);
          model1.setStoreName("STore-1");
          model1.setStoreType("Cafe");
          model1.setStoreDetail("48 km hhfgkjhfkjghskjhgkjd");
          model1.setStoreRating("4.5");
          model1.setStoreRatingCount("(14)");
          storeList.add(model1);

          StoreModel model2 = new StoreModel(R.drawable.profilepic, "Store -2","MEdical",
                  "67 km OPN CLOSE At 10 ","4.0", "(20)");
          storeList.add(model2);

        StoreModel model3 = new StoreModel(R.drawable.profilepic, "Store -2","Chai Valley",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model3);

        StoreModel model4 = new StoreModel(R.drawable.profilepic, "Store -2","Hotel Rudra",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model4);
        StoreModel model5 = new StoreModel(R.drawable.profilepic, "Store -2","Hospital",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model5);

        StoreModel model6 = new StoreModel(R.drawable.profilepic, "Store -2","MEdical",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model6);

        StoreModel model7 = new StoreModel(R.drawable.profilepic, "Store -2","MEdical",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model7);

        StoreModel model8 = new StoreModel(R.drawable.profilepic, "Store -2","MEdical",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model8);

        StoreModel model9 = new StoreModel(R.drawable.profilepic, "Store -2","MEdical",
                "67 km OPN CLOSE At 10 ","4.0", "(20)");
        storeList.add(model9);


    }
}