package com.example.mayandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mayandroid.databinding.ActivityMovieBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    ApiService apiService;
    ActivityMovieBinding binding;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService=ApiClient.getClient().create(ApiService.class);
        getMovieList();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void getMovieList(){

        Call<Movie> call=apiService.getMovieList("abc","c8d30391");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful())
                {
                    Movie movie=response.body();
                    adapter=new MovieAdapter(movie.getSearch());
                    binding.rvmovie.setHasFixedSize(true);
                    binding.rvmovie.setLayoutManager(new LinearLayoutManager(MovieActivity.this));
                    binding.rvmovie.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}