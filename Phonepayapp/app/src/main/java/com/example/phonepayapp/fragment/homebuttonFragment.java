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
import android.widget.TextView;

import com.example.phonepayapp.Adapterfile;
import com.example.phonepayapp.adapter.Adaptertransfer;
import com.example.phonepayapp.R;
import com.example.phonepayapp.model.Recyclerdataclass;
import com.example.phonepayapp.adapter.recyclerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class homebuttonFragment extends Fragment {
    RecyclerView recv_one,recv_two,recv_three,recv_four,recv_five,recv_six,recv_seven,recv_eight;
    TextView tv_moneytransfer;
    Timer sliderOneTimer, sliderTwoTimer;

    private int[] sliderImageId = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img4};
    ViewPager homeViewpager,viewPageadd;

    String hello[]={"1","2","3","4","5"};
    String recvthree[]={"1","2","3","4"};
    String dats[]={"1","2","3","4","5","6","7","8"};
    String recvfour[]={"1","2","3","4","5","6","7","8"};
    ArrayList<Recyclerdataclass> recyclerdataclassArrayList = new ArrayList<>();
    ArrayList<Recyclerdataclass> paybillsarraylist = new ArrayList<>();
    ArrayList<Recyclerdataclass> sponssoredarraylist = new ArrayList<>();
    ArrayList<Recyclerdataclass> insurancearraylist = new ArrayList<>();
    ArrayList<Recyclerdataclass> Investmentarraylist = new ArrayList<>();
    ArrayList<Recyclerdataclass> switcharraylist = new ArrayList<>();
    ArrayList<Recyclerdataclass> donationsarraylist = new ArrayList<>();
    ArrayList<Recyclerdataclass> brandarraylist = new ArrayList<>();
    private Context context;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_homebutton, container, false);
        recv_one=view.findViewById(R.id.recv_one);
        recv_two=view.findViewById(R.id.recv_two);
        recv_three=view.findViewById(R.id.recv_three);
        recv_four=view.findViewById(R.id.recv_four);
        recv_five=view.findViewById(R.id.recv_five);
        recv_six=view.findViewById(R.id.recv_six);
        recv_seven=view.findViewById(R.id.recv_seven);
        recv_eight=view.findViewById(R.id.recv_eight);

        initData();

        return view;
    }

    private void initData() {

        //Adding Items to the Array lIST.
        recyclerdataclassArrayList.add(new Recyclerdataclass(R.drawable.contact,"To Mobile \n Number"));
        recyclerdataclassArrayList.add(new Recyclerdataclass(R.drawable.bank,"To Bank \n UPI/ID"));
        recyclerdataclassArrayList.add(new Recyclerdataclass(R.drawable.selfdownlod,"To Self\nAccount"));
        recyclerdataclassArrayList.add(new Recyclerdataclass(R.drawable.bank,"Check Bank\nBalance"));



        paybillsarraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Mobile\nRecharge"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.satellite,"DTH"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.electricty,"Electricity"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.creditcard,"Credit Card\nBill"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.rent,"Rent\nPayment"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.loan,"Loan\nPayment"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.cylinder,"Book A\nCylinder"));
        paybillsarraylist.add(new Recyclerdataclass(R.drawable.rightarrow,"TEXT bharat"));

        sponssoredarraylist.add(new Recyclerdataclass(R.drawable.electricty,"Filpcart"));
        sponssoredarraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"RummyCircle"));
        sponssoredarraylist.add(new Recyclerdataclass(R.drawable.electricty,"Pharmeasy"));
        sponssoredarraylist.add(new Recyclerdataclass(R.drawable.mobilerecharge,"Firstgame"));









        homeViewpager=view.findViewById(R.id.viewPage);
        viewPageadd=view.findViewById(R.id.viewPageadd);
        tv_moneytransfer=view.findViewById(R.id.tv_moneytransfer);
        Adapterfile adapterView = new Adapterfile(context);
        homeViewpager.setAdapter(adapterView);
        sliderOneTimer = new Timer();
        sliderOneTimer.scheduleAtFixedRate(new SliderTimer(),5000,4000);
        viewPageadd.setAdapter(adapterView);
        sliderTwoTimer=new Timer();
        sliderTwoTimer.scheduleAtFixedRate(new Slidertimeradd(),5000,4000);





        recv_one.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        //recv_one.setAdapter(new Adaptertransfer(hello));
        recv_one.setAdapter(new Adaptertransfer(recyclerdataclassArrayList));
       /* recv_seven.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recv_seven.setAdapter(new Adaptertransfer(recvthree) );
*/
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,4){
            @Override
            public boolean canScrollVertically() {
                return true;
            }

        };
        recv_two.setLayoutManager(gridLayoutManager);
        recv_two.setAdapter(new recyclerAdapter(paybillsarraylist));
        recv_three.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_three.setAdapter(new recyclerAdapter(sponssoredarraylist));
        GridLayoutManager gridmanage=new GridLayoutManager(context,4);
        recv_four.setLayoutManager(gridmanage);
        recv_four.setAdapter(new recyclerAdapter(paybillsarraylist));
        GridLayoutManager gridthree=new GridLayoutManager(context,4);
        recv_five.setLayoutManager(gridthree);
        recv_five.setAdapter(new recyclerAdapter(paybillsarraylist));
        GridLayoutManager gridfour=new GridLayoutManager(context,4);
        recv_six.setLayoutManager(gridfour);
        recv_six.setAdapter(new recyclerAdapter(paybillsarraylist));
        recv_seven.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recv_seven.setAdapter(new recyclerAdapter(sponssoredarraylist) );
        GridLayoutManager gridfive=new GridLayoutManager(context,4);
        recv_eight.setLayoutManager(gridfive);
        recv_eight.setAdapter(new recyclerAdapter(paybillsarraylist));




    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (homeViewpager.getCurrentItem() < sliderImageId.length - 1) {
                        homeViewpager.setCurrentItem(homeViewpager.getCurrentItem() + 1);
                    } else {
                        homeViewpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    private class Slidertimeradd extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPageadd.getCurrentItem() < sliderImageId.length - 1) {
                        viewPageadd.setCurrentItem(viewPageadd.getCurrentItem() + 1);
                    } else {
                        viewPageadd.setCurrentItem(0);
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
        if(null!=sliderTwoTimer){
            sliderTwoTimer.cancel();
        }
    }
}