package com.example.s1s1s1.zigzagapp.dataModel;

import com.example.s1s1s1.zigzagapp.R;

import java.util.ArrayList;

public class VerticalModel {
    private ArrayList<HorizontalModel>horizontalModels;

    public VerticalModel(ArrayList<HorizontalModel> horizontalModels) {
        this.horizontalModels = horizontalModels;
    }

    public ArrayList<HorizontalModel> getHorizontalModels() {
        return horizontalModels;
    }

    public void setHorizontalModels(ArrayList<HorizontalModel> horizontalModels) {
        this.horizontalModels = horizontalModels;
    }


}
