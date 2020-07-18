package com.me.databinding.DynamicBinding;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.me.databinding.R;
import com.me.databinding.databinding.ActivityDynamicBinding;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_dynamic);
        ActivityDynamicBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_dynamic);
        binding.setStr("Muhammad ");
        binding.setImageUrl("http://www.alexwolfps.com/images/beans.jpg");
    }
}
