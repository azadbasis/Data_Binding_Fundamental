package com.me.databinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.databinding.databinding.ActivityMainBinding;
import com.me.databinding.databinding.ItemViewBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 7/10/2020 Inflate layout
        //  setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // TODO: 7/10/2020 Find layout element and assign to local variable
        //   TextView hello = (TextView) findViewById(R.id.hello);

        // TODO: 7/10/2020 Get data
        DataSource dataSource = DataSource.get("Azharul Islam");
        DataSource includeSource = DataSource.get("Include DataSource");

        // TODO: 7/10/2020 Assign value to element property
        // hello.setText(dataSource.getMessage());
        // TODO: 7/11/2020 Bind the data to the view
        // TODO: 7/11/2020 set once per bound variable
        // TODO: 7/11/2020 One line per attribute binding,plus a line to set the bound variable
        binding.setDataSource(dataSource);
        binding.setIncludeSource(includeSource);
      // TODO: 7/17/2020 Setup recyclerview
        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(new DataSourceAdapter(getLayoutInflater()));
    }

    private class DataSourceAdapter extends RecyclerView.Adapter<ViewHolder> {
        private LayoutInflater layoutInflater;

        public DataSourceAdapter(LayoutInflater layoutInflater) {
            this.layoutInflater = layoutInflater;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemViewBinding binding = ItemViewBinding.inflate(layoutInflater, parent, false);
            return new ViewHolder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            DataSource dataSource = DataSource.get("Item Binding" + position);
            ItemViewBinding binding = DataBindingUtil.getBinding(holder.itemView);
            binding.setDataSource(dataSource);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
