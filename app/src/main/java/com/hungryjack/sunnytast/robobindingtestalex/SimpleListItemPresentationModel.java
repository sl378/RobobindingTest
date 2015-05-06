package com.hungryjack.sunnytast.robobindingtestalex;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * Created by alex.liu on 5/6/2015.
 */

public class SimpleListItemPresentationModel implements ItemPresentationModel<String> {
    private String mLabel;
    public String getItemLabel(){
        return mLabel;
    }
    @Override
    public void updateData(String s, ItemContext itemContext) {
        mLabel = s;
    }
}
