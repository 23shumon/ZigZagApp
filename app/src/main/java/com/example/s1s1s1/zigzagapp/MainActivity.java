package com.example.s1s1s1.zigzagapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.s1s1s1.zigzagapp.adapter.VerticalAdapter;
import com.example.s1s1s1.zigzagapp.dataModel.HorizontalModel;
import com.example.s1s1s1.zigzagapp.dataModel.VerticalModel;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView verticalRV;
    private VerticalModel vm;
    private VerticalAdapter adapter;
    private ArrayList<VerticalModel>vmList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalRV=findViewById(R.id.verticalRV);
        Collections.shuffle(vmList);
        verticalRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new VerticalAdapter(this,vmList);
        verticalRV.setAdapter(adapter);
        addData();
    }

    public void addData(){

        ArrayList<HorizontalModel>horizontalModels=new ArrayList<>();
        horizontalModels.add(new HorizontalModel(R.mipmap.iphone_xr,"iPhone XR"));
        horizontalModels.add(new HorizontalModel(R.mipmap.xiaomi_redmi7pro,"Xiaomi Redmi 7"));
        horizontalModels.add(new HorizontalModel(R.mipmap.xperia_xz1,"EXPERIA ZX1"));
        horizontalModels.add(new HorizontalModel(R.mipmap.smasung_s10p,"SAMSUNG s10"));
        horizontalModels.add(new HorizontalModel(R.mipmap.xiaomi_mi8,"Xiaomi mi 8"));
        horizontalModels.add(new HorizontalModel(R.mipmap.iphone_xr,"iPhone XR"));
        horizontalModels.add(new HorizontalModel(R.mipmap.xiaomi_redmi7pro,"Xiaomi Redmi 7"));
        horizontalModels.add(new HorizontalModel(R.mipmap.xperia_xz1,"EXPERIA ZX1"));
        horizontalModels.add(new HorizontalModel(R.mipmap.smasung_s10p,"SAMSUNG s10"));
        horizontalModels.add(new HorizontalModel(R.mipmap.xiaomi_mi8,"Xiaomi mi 8"));
        vm = new VerticalModel(horizontalModels);
        for (int i=0;i<10;i++) {
            vmList.add(vm);
        }
        Collections.shuffle(vmList);
        Collections.shuffle(horizontalModels);

        adapter.notifyDataSetChanged();
    }
}
