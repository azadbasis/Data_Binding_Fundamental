package com.me.databinding;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.me.databinding.databinding.DataViewBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataView extends FrameLayout {


//    private DataViewBinding binding;

    public DataView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
      //  binding=DataViewBinding.bind(this);
      //  setContentView(binding.getRoot());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        DataViewBinding binding = DataBindingUtil.findBinding(this);
        DataSource dataSource=DataSource.get("Data View");
        binding.setDataSource(dataSource);
    }
}
