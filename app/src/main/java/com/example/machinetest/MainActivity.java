package com.example.machinetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TableLayout tableLayout;
    private int start = 1;
    private int addition = 2; ;
    private static final String TAG = "MainActivity";
    EditText input;
    Button result;
    RecyclerView recyclerView;
    String fifity = "50";
    String hundered = "100";
    List<String> list = new ArrayList<>();
    String rows;
    private int count50 =1;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        input = findViewById(R.id.num_rows);
        result  =findViewById(R.id.show_result);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                rows = input.getText().toString().trim();


                if (rows.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Number of Columns", Toast.LENGTH_SHORT).show();
                    return;
                }

                addtoList();
                adapter = new Adapter(list);
                recyclerView.setAdapter(adapter);


            }
        });



           }

    private void addtoList() {
        for (int i = 0; i < Integer.valueOf(rows) ; i++) {
            if(Collections.frequency(list, "50") == count50){
                list.add(hundered);
                start+=addition;
                addition+=2;
                count50+=start;

            }
            else{
                list.add(fifity);
            }

        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+" ");
        }

    }

}
