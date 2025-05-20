package com.example.mayandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mayandroid.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    ActivityRecyclerViewBinding binding;
    List<MyListData> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listData=new ArrayList<>();
        listData.add(new MyListData("One","Description",R.drawable.onboardone));
        listData.add(new MyListData("Two","Description",1));
        listData.add(new MyListData("Three","Description",2));
        listData.add(new MyListData("Four","Description",3));
        listData.add(new MyListData("Five","Description",4));
        listData.add(new MyListData("Six","Description",5));
        listData.add(new MyListData("Seven","Description",6));
        listData.add(new MyListData("Eight","Description",7));
        listData.add(new MyListData("Nine","Description",8));
        listData.add(new MyListData("Ten","Description",9));
        listData.add(new MyListData("Eleven","Description",10));
        listData.add(new MyListData("Twelve","Description",11));
        listData.add(new MyListData("Thirteen","Description",12));
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listData);
        binding.rvlist.setHasFixedSize(true);
       // binding.rvlist.setLayoutManager(new LinearLayoutManager(this));
        binding.rvlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvlist.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}