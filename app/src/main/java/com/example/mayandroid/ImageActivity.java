package com.example.mayandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.mayandroid.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {

    ActivityImageBinding binding;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ivimg.setVisibility(View.VISIBLE);
            }
        });

        Glide.with(this)
                .load("https://taskmotech1b.s3.ap-south-1.amazonaws.com/refer_and_earn_banner%20%281%29.png1675927170668_refer_and_earn_banner%20%281%29.png")
                .into(binding.ivimg);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}