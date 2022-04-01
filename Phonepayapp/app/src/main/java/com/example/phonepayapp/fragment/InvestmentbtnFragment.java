package com.example.phonepayapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phonepayapp.Adapterfile;
import com.example.phonepayapp.R;
import com.example.phonepayapp.adapter.AdapterInvestment;
import com.example.phonepayapp.adapter.Adaptertransfer;
import com.example.phonepayapp.adapter.recyclerAdapter;
import com.example.phonepayapp.model.Investmentmodelclass;
import com.example.phonepayapp.model.Recyclerdataclass;
import com.example.phonepayapp.model.StoreModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class InvestmentbtnFragment extends Fragment {
    RecyclerView recv_Investmentideas,recv_funds,recv_Mutualfund;
    ViewPager viewPager_Investment;
    private int[] sliderImageId = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img4};
    private Context context;
    Timer sliderOneTimer, sliderTwoTimer;

    private View view;

    private Adaptertransfer investmentadapter;

    private ArrayList<Recyclerdataclass> investmentdataArraylist = new ArrayList<>();
    private ArrayList<Recyclerdataclass> mutualfunarrylist = new ArrayList<>();

    private ArrayList<Investmentmodelclass> topfundsarraylist = new ArrayList<>();




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public InvestmentbtnFragment() {
    }


    public static InvestmentbtnFragment newInstance(String param1, String param2) {
        InvestmentbtnFragment fragment = new InvestmentbtnFragment();
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
        view =  inflater.inflate(R.layout.fragment_investmentbtn, container, false);
        recv_Investmentideas=view.findViewById(R.id.recv_Investmentideas);
        recv_funds=view.findViewById(R.id.recv_funds);
        recv_Mutualfund=view.findViewById(R.id.recv_Mutualfund);
        viewPager_Investment=view.findViewById(R.id.viewPager_Investment);
        Adapterfile adapterView = new Adapterfile(context);
        viewPager_Investment.setAdapter(adapterView);
        sliderOneTimer = new Timer();
        sliderOneTimer.scheduleAtFixedRate(new InvestmentbtnFragment.SliderTimer(),5000,4000);
        investmentdata();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
    public void investmentdata(){

        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Mobile\nRecharge"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.satellite,"DTH"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.electricty,"Electricity"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.creditcard,"Credit Card\nBill"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.rent,"Rent\nPayment"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.loan,"Loan\nPayment"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.cylinder,"Book A\nCylinder"));
        investmentdataArraylist.add(new Recyclerdataclass(R.drawable.rightarrow,"TEXT bharat"));







        topfundsarraylist.add(new Investmentmodelclass(R.drawable.contact,"HDFC Bank padantiual fund", "Equility Value","3Y Return","56.25%pa","date 32/02/2252","Min Amount"));
        topfundsarraylist.add(new Investmentmodelclass(R.drawable.contact,"HDFC Bank padantiual fund", "Equility Value","3Y Return","56.25%pa","date 32/02/2252","Min Amount"));
        topfundsarraylist.add(new Investmentmodelclass(R.drawable.contact,"HDFC Bank padantiual fund", "Equility Value","3Y Return","56.25%pa","date 32/02/2252","Min Amount"));
        topfundsarraylist.add(new Investmentmodelclass(R.drawable.contact,"HDFC Bank padantiual fund", "Equility Value","3Y Return","56.25%pa","date 32/02/2252","Min Amount"));
        topfundsarraylist.add(new Investmentmodelclass(R.drawable.contact,"HDFC Bank padantiual fund", "Equility Value","3Y Return","56.25%pa","date 32/02/2252","Min Amount"));
        topfundsarraylist.add(new Investmentmodelclass(R.drawable.contact,"HDFC Bank padantiual fund", "Equility Value","3Y Return","56.25%pa","date 32/02/2252","Min Amount"));



        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,4){
            @Override
            public boolean canScrollVertically() {
                return true;
            }

        };
        recv_Investmentideas.setLayoutManager(gridLayoutManager);
        recv_Investmentideas.setAdapter(new recyclerAdapter(investmentdataArraylist));
        GridLayoutManager gridLayoutManagertwo=new GridLayoutManager(context,4){
            @Override
            public boolean canScrollVertically() {
                return true;
            }

        };
        recv_Mutualfund.setLayoutManager(gridLayoutManagertwo);
        recv_Mutualfund.setAdapter(new recyclerAdapter(investmentdataArraylist));
        recv_funds.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_funds.setAdapter(new AdapterInvestment(topfundsarraylist));

    }
    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager_Investment.getCurrentItem() < sliderImageId.length - 1) {
                        viewPager_Investment.setCurrentItem(viewPager_Investment.getCurrentItem() + 1);
                    } else {
                        viewPager_Investment.setCurrentItem(0);
                    }
                }
            });
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if(null!=sliderOneTimer){
            sliderOneTimer.cancel();
        }

    }
}
