package com.example.subhash.viewmodellivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.subhash.viewmodellivedata.ViewModel.HerosViewModel;
import com.example.subhash.viewmodellivedata.model.Hero;
import com.example.subhash.viewmodellivedata.model.HeroAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
HeroAdapter adapter;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        HerosViewModel model = ViewModelProviders.of(MainActivity.this).get(HerosViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
                        public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroAdapter(MainActivity.this, heroList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
