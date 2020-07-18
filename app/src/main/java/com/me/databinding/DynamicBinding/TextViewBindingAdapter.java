package com.me.databinding.DynamicBinding;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;

public class TextViewBindingAdapter {

    @BindingAdapter("bind:numberText")
    public static void setNumberText(TextView view, int number){
        view.setText(String.valueOf(number));
    }
}
