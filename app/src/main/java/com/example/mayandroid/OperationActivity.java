package com.example.mayandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationActivity extends AppCompatActivity {
    EditText edtfirstNo,edtsecondNo;
    Button btnplus;
    TextView tvresult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operation);
        edtfirstNo=findViewById(R.id.edtfirstNo);
        edtsecondNo=findViewById(R.id.edtsecondNo);
        btnplus=findViewById(R.id.btnplus);
        tvresult=findViewById(R.id.tvresult);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNo=edtfirstNo.getText().toString();
                String secondNo=edtsecondNo.getText().toString();
                int a=Integer.parseInt(firstNo);
                int b=Integer.parseInt(secondNo);
                int result=add(a,b);
                tvresult.setText(String.valueOf(result));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private int add(int a,int b){return a+b;}
}