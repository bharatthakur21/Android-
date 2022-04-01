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
import com.example.phonepayapp.adapter.AdapterInvestment;
import com.example.phonepayapp.adapter.Adaptertransfer;
import com.example.phonepayapp.adapter.recyclerAdapter;
import com.example.phonepayapp.model.Recyclerdataclass;

import java.util.ArrayList;


public class InsaurancebtnFragment extends Fragment {
    RecyclerView recv_MotorandYravel,recv_LifeandAccident,recv_Health,recv_Others;
    private View view;
    private Context context;
    private ArrayList<Recyclerdataclass> MotorandtravelArraylist = new ArrayList<>();
    private ArrayList<Recyclerdataclass> lifeandaccidentArraylist = new ArrayList<>();
    private ArrayList<Recyclerdataclass> Healthaylist = new ArrayList<>();
    private ArrayList<Recyclerdataclass> OthersArraylist = new ArrayList<>();





    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public InsaurancebtnFragment() {

    }


    public static InsaurancebtnFragment newInstance(String param1, String param2) {
        InsaurancebtnFragment fragment = new InsaurancebtnFragment();
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
        view =  inflater.inflate(R.layout.fragment_insaurancebtn, container, false);
        recv_MotorandYravel=view.findViewById(R.id.recv_MotorandYravel);
        recv_LifeandAccident=view.findViewById(R.id.recv_LifeandAccident);
        recv_Health=view.findViewById(R.id.recv_Health);
        recv_Others=view.findViewById(R.id.recv_Others);
        insaurancedata();
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
    public void  insaurancedata(){


        MotorandtravelArraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Bike"));
        MotorandtravelArraylist.add(new Recyclerdataclass(R.drawable.satellite,"Car"));
        MotorandtravelArraylist.add(new Recyclerdataclass(R.drawable.electricty,"Domestic\nTravel"));
        MotorandtravelArraylist.add(new Recyclerdataclass(R.drawable.creditcard,"InterNational\nTravel"));



        lifeandaccidentArraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Term Life"));
        lifeandaccidentArraylist.add(new Recyclerdataclass(R.drawable.satellite,"Accident"));
        lifeandaccidentArraylist.add(new Recyclerdataclass(R.drawable.electricty,"Guranted\nReturns"));



        Healthaylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Health"));
        Healthaylist.add(new Recyclerdataclass(R.drawable.satellite,"Health++"));
        Healthaylist.add(new Recyclerdataclass(R.drawable.electricty,"Covid-19"));
        Healthaylist.add(new Recyclerdataclass(R.drawable.creditcard,"Super\nTop up"));


        OthersArraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Mobile"));




        recv_MotorandYravel.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_MotorandYravel.setAdapter(new Adaptertransfer(MotorandtravelArraylist));
        recv_LifeandAccident.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_LifeandAccident.setAdapter(new Adaptertransfer(lifeandaccidentArraylist));
        recv_Health.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_Health.setAdapter(new Adaptertransfer(Healthaylist));
        recv_Others.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_Others.setAdapter(new Adaptertransfer(OthersArraylist));


    }

}