package com.example.phonepayapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phonepayapp.R;
import com.example.phonepayapp.adapter.Adapterhistory_data;
import com.example.phonepayapp.adapter.Adapterstore_data;
import com.example.phonepayapp.model.Historymodeldataclass;
import com.example.phonepayapp.model.StoreModel;

import java.util.ArrayList;


public class historybtnFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    private View view;
    RecyclerView recv_historydata;
    private Adapterhistory_data historyAdapter;

    private ArrayList<Historymodeldataclass> historylist = new ArrayList<>();


    public historybtnFragment() {

    }

    public static historybtnFragment newInstance(String param1, String param2) {
        historybtnFragment fragment = new historybtnFragment();
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
        view = inflater.inflate(R.layout.fragment_historybtn, container, false);
        recv_historydata = view.findViewById(R.id.recv_historydata);
        recv_historydata.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        historyAdapter = new Adapterhistory_data(historylist);
        recv_historydata.setAdapter(historyAdapter);
        initData();

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void initData() {
        Historymodeldataclass model1 = new Historymodeldataclass();
        model1.setHistoryimg(R.drawable.profilepic);
        model1.setPaidto("STore-1");
        model1.setPaidamount("Cafe");
        model1.setPaidloaction("48 km Near awadh Palace");
        model1.setPaidtime("4.5");
        model1.setCreditto("(14)");
        historylist.add(model1);


        Historymodeldataclass model2 = new Historymodeldataclass();
        model2.setHistoryimg(R.drawable.profilepic);
        model2.setPaidto("STore-1");
        model2.setPaidamount("Cafe");
        model2.setPaidloaction("48 km Near awadh Palace");
        model2.setPaidtime("4.5");
        model2.setCreditto("(14)");
        historylist.add(model2);


        Historymodeldataclass model3 = new Historymodeldataclass();
        model3.setHistoryimg(R.drawable.profilepic);
        model3.setPaidto("STore-1");
        model3.setPaidamount("Cafe");
        model3.setPaidloaction("48 km Near awadh Palace");
        model3.setPaidtime("4.5");
        model3.setCreditto("(14)");
        historylist.add(model3);


        Historymodeldataclass model4 = new Historymodeldataclass();
        model4.setHistoryimg(R.drawable.profilepic);
        model4.setPaidto("STore-1");
        model4.setPaidamount("Cafe");
        model4.setPaidloaction("48 km Near awadh Palace");
        model4.setPaidtime("4.5");
        model4.setCreditto("(14)");
        historylist.add(model4);


        Historymodeldataclass model5 = new Historymodeldataclass();
        model5.setHistoryimg(R.drawable.profilepic);
        model5.setPaidto("STore-1");
        model5.setPaidamount("Cafe");
        model5.setPaidloaction("48 km Near awadh Palace");
        model5.setPaidtime("4.5");
        model5.setCreditto("(14)");
        historylist.add(model5);


        Historymodeldataclass model6 = new Historymodeldataclass();
        model6.setHistoryimg(R.drawable.profilepic);
        model6.setPaidto("STore-1");
        model6.setPaidamount("Cafe");
        model6.setPaidloaction("48 km Near awadh Palace");
        model6.setPaidtime("4.5");
        model6.setCreditto("(14)");
        historylist.add(model6);


        Historymodeldataclass model7 = new Historymodeldataclass();
        model7.setHistoryimg(R.drawable.profilepic);
        model7.setPaidto("STore-1");
        model7.setPaidamount("Cafe");
        model7.setPaidloaction("48 km Near awadh Palace");
        model7.setPaidtime("4.5");
        model7.setCreditto("(14)");
        historylist.add(model7);

        Historymodeldataclass model8 = new Historymodeldataclass();
        model8.setHistoryimg(R.drawable.profilepic);
        model8.setPaidto("STore-1");
        model8.setPaidamount("Cafe");
        model8.setPaidloaction("48 km Near awadh Palace");
        model8.setPaidtime("4.5");
        model8.setCreditto("(14)");
        historylist.add(model8);
    }


}