package com.example.carlosjose95.kfc;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<SedeKFC> sedeKFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fbViewMap);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("numero", 0);
                intent.putExtra("bandera", true);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerview);

        sedeKFC = new ArrayList<>();

        sedeKFC.add(new SedeKFC(R.drawable.kfcflorida, 0, "KFC Florida"));
        sedeKFC.add(new SedeKFC(R.drawable.kfclaureles, 1, "KFC Laureles"));
        sedeKFC.add(new SedeKFC(R.drawable.kfcjunin, 2, "KFC Junin"));
        sedeKFC.add(new SedeKFC(R.drawable.kfcpremium, 3, "KFC Premium plaza"));
        sedeKFC.add(new SedeKFC(R.drawable.kfcsantafe, 4, "KFC Santa Fe"));

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(sedeKFC, getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);

    }
}
