package com.example.s1s1s1.zigzagapp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s1s1s1.zigzagapp.R;
import com.example.s1s1s1.zigzagapp.dataModel.HorizontalModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    private Context context;
    private ArrayList<HorizontalModel>hmList;

    public HorizontalAdapter(Context context, ArrayList<HorizontalModel> hmList) {
        this.context = context;
        this.hmList = hmList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.horizontal_column,viewGroup,false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder horizontalViewHolder, int i) {
        Collections.shuffle(hmList);
        final HorizontalModel horizontalModel=hmList.get(i);
        horizontalViewHolder.textView.setText(horizontalModel.getName());
        horizontalViewHolder.imageView.setImageResource(horizontalModel.getImage());

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.alpha);
        horizontalViewHolder.imageView.startAnimation(animation);

        horizontalViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullView(horizontalModel);
            }
        });
    }

    private void fullView(HorizontalModel horizontalModel) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View fullView= inflater.inflate(R.layout.fullscreeen,null,false);
        final Dialog fullScreenDilog=new Dialog(context,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        fullScreenDilog.setContentView(fullView);

        Button closeBtn=fullScreenDilog.findViewById(R.id.btnClose);
        ImageView fullScreenView=fullScreenDilog.findViewById(R.id.fullView);
        fullScreenView.setImageResource(horizontalModel.getImage());
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreenDilog.dismiss();
            }
        });

        fullScreenDilog.show();
    }


    @Override
    public int getItemCount() {
        return hmList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
            imageView=itemView.findViewById(R.id.imageview);
        }
    }
}
