package com.example.s1s1s1.zigzagapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.s1s1s1.zigzagapp.R;
import com.example.s1s1s1.zigzagapp.dataModel.HorizontalModel;
import com.example.s1s1s1.zigzagapp.dataModel.VerticalModel;

import java.util.ArrayList;
import java.util.Collections;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private Context context;
    private ArrayList<VerticalModel>vmList;

    public VerticalAdapter(Context context, ArrayList<VerticalModel> vmList) {
        this.context = context;
        this.vmList = vmList;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.vertical_row,viewGroup,false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder verticalViewHolder, int i) {
        VerticalModel verticalModel=vmList.get(i);
        ArrayList<HorizontalModel>hmList=verticalModel.getHorizontalModels();

        verticalViewHolder.horizontalRV.setHasFixedSize(true);
        HorizontalAdapter horizontalAdapter=new HorizontalAdapter(context,hmList);
        verticalViewHolder.horizontalRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        verticalViewHolder.horizontalRV.setAdapter(horizontalAdapter);
    }

    @Override
    public int getItemCount() {
        return vmList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView horizontalRV;
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalRV=itemView.findViewById(R.id.horizontalRV);
        }
    }
}
