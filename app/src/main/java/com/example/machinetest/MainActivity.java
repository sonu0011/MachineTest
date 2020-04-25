package com.example.machinetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int start = 1;
    private int addition = 2;
    EditText input;
    Button result;
    RecyclerView recyclerView;
    String fifity = "50";
    String hundered = "100";
    String rows;
    private int count50 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        input = findViewById(R.id.num_rows);
        result = findViewById(R.id.show_result);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                rows = input.getText().toString().trim();


                if (rows.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter number of cells", Toast.LENGTH_SHORT).show();
                    return;
                }
                addtolist();


            }
        });


    }

    private void addtolist() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.valueOf(rows); i++) {
            if (Collections.frequency(list, "50") == count50) {
                list.add(hundered);
                start += addition;
                addition += 2;
                count50 += start;

            } else {
                list.add(fifity);
            }

        }

        start = 1;
        addition = 2;
        count50 = 1;


        Adapter adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);


    }


}
