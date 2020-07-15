package com.me.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.me.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 7/10/2020 Inflate layout
        //  setContentView(R.layout.activity_main);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        // TODO: 7/10/2020 Find layout element and assign to local variable
        //   TextView hello = (TextView) findViewById(R.id.hello);

        // TODO: 7/10/2020 Get data
        DataSource dataSource = DataSource.get("Azharul Islam");

        // TODO: 7/10/2020 Assign value to element property
        // hello.setText(dataSource.getMessage());
        // TODO: 7/11/2020 Bind the data to the view
        // TODO: 7/11/2020 set once per bound variable
        // TODO: 7/11/2020 One line per attribute binding,plus a line to set the bound variable
        binding.setDataSource(dataSource);
    }
}
