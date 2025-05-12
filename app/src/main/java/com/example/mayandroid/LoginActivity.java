package com.example.mayandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtMobile,edtPassword;
    Button btnSubmit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtMobile = findViewById(R.id.edtmobileno);
        edtPassword = findViewById(R.id.edtpassword);
        btnSubmit = findViewById(R.id.btnlogin);
        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = edtMobile.getText().toString();
                String password = edtPassword.getText().toString();
                if(mobile.isEmpty() && password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Mobile No & Password",Toast.LENGTH_LONG).show();
                  //  edtMobile.setError("Enter Mobile No");
                }
                else if (mobile.equals("9876543210") && password.equals("12345")) {
                    editor.putString("isLoggedIn", "true");
                    editor.commit();
                   // Toast.makeText(getApplicationContext(),"Move to home page",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);

                }

                Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_LONG).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}