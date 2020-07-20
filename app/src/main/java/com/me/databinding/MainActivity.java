package com.me.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.me.databinding.DynamicBinding.DynamicActivity;
import com.me.databinding.databinding.ActivityMainBinding;
import com.me.databinding.databinding.ExpressionsBinding;
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
        //TODO: Setup yogurt menu
        ExpressionsBinding raspberryBinding =
                ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
        raspberryBinding.setItem(new MenuItem(false, "Raspberry", "$2.99", 2));
        binding.menu.addView(raspberryBinding.getRoot());

        ExpressionsBinding vanillaSpecialBinding =
                ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
        vanillaSpecialBinding.setItem(new MenuItem(true, "Vanilla", "$0.99", 1));
        binding.menu.addView(vanillaSpecialBinding.getRoot());
//        Button tvButton = findViewById(R.id.tvButton);
//        tvButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, DynamicActivity.class));
//            }
//        });
        binding.setCustomAdapterListener(new CustomAdapterListeners());
        binding.setListener(new Listener(binding));
    }

    public class CustomAdapterListeners implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, DynamicActivity.class));
        }
    }

    public static class Listener implements View.OnClickListener {
        ActivityMainBinding binding;

        public Listener(com.me.databinding.databinding.ActivityMainBinding binding) {
            this.binding = binding;
        }

        @Override
        public void onClick(View view) {
        int number=binding.getNumber();
        binding.setNumber(++number);
        }
    }
     @BindingAdapter("bind:numberText")
    public static void setNumber(TextView textView, int number) {
        textView.setText(String.valueOf(number));
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
            DataSource dataSource = DataSource.get("Item Binding-" + position);
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
