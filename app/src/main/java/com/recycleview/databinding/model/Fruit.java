package com.recycleview.databinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.recycleview.databinding.BR;


public class Fruit extends BaseObservable {
    private String name;
    private int imageId;
    
    public Fruit( String name, int imageId ) {
        this.name = name;
        this.imageId = imageId;
    }
    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public int getImageId() {
        return imageId;
    }

    public void setName(String name){
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setImageId(int imageId){
        this.imageId = imageId;
        notifyPropertyChanged(BR.imageId);
    }
}