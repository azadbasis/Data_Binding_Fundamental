package com.me.databinding;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.me.databinding.databinding.FragmentDataBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDataBinding binding = FragmentDataBinding.inflate(inflater, container, false);
//        return inflater.inflate(R.layout.fragment_data, container, false);
        DataSource dataSource=DataSource.get("Fragment Binding");
        binding.setDataSource(dataSource);
        return binding.getRoot();
    }
}
