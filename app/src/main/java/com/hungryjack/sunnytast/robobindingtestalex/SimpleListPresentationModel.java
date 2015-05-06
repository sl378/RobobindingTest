package com.hungryjack.sunnytast.robobindingtestalex;

import android.util.Log;
import android.widget.Toast;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.List;

/**
 * Created by alex.liu on 5/6/2015.
 */
@PresentationModel
public class SimpleListPresentationModel implements HasPresentationModelChangeSupport {
    private String TAG = "SimpleListPresentationModel";
    private final PresentationModelChangeSupport mChangeSupport;
    private List<String> mListObjects;
    public SimpleListPresentationModel(List<String> objects){
        this.mChangeSupport = new PresentationModelChangeSupport(this);
        mListObjects = objects;
    }
//    public int getItemLayout(){
//        return R.layout.list_item_layout;
//    }

    @ItemPresentationModel(SimpleListItemPresentationModel.class)
    public List<String> getListSource(){
        return  mListObjects;
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return mChangeSupport;
    }

    public void refresh(){
        mChangeSupport.firePropertyChange("listSource");
        Log.i(TAG, "SimpleListPresentationModel refreshed");
    }
}
