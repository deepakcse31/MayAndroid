package com.example.mayandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mayandroid.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {
    ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String amount=binding.edtamount.getText().toString();
               Intent intent=new Intent(PaymentActivity.this,AmountProcessActivity.class);
               intent.putExtra("amount",amount);
               startActivity(intent);

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}