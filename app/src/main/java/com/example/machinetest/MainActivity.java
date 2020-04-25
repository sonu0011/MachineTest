package com.example.machinetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TableLayout tableLayout;
    private int flag = 3;
    private int count = 3;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fifity = "50";
        String hundered = "100";
        setContentView(R.layout.activity_main);
        tableLayout = findViewById(R.id.my_tableLayout);
        for (int i = 1; i <=10 ; i++) {
            TableRow newRow = new TableRow(this);
            newRow.setLayoutParams(getLayoutParams());
            TextView dynamicCOlumn = null;
            TextView column = null;
            for (int j = 1; j <= 5 ; j++) {



               if(flag >= i) {

                   if(i%2 == 0){
                       if(i == j*2){
                          dynamicCOlumn = new TextView(this);
                          dynamicCOlumn.setText(hundered);
                          setAnotherParms(dynamicCOlumn);
                          newRow.addView(dynamicCOlumn);

                       }
                       else {
                           column = new TextView(this);
                           column.setText(fifity);
                           setParms(column);
                           newRow.addView(column);


                       }


                   }
                   else if (i%2 ==1){
                       if(j ==i+1){

                           dynamicCOlumn = new TextView(this);
                           dynamicCOlumn.setText(hundered);
                           setAnotherParms(dynamicCOlumn);
                           newRow.addView(dynamicCOlumn);

                       }
                       else {
                           column = new TextView(this);
                           column.setText(fifity);
                           setParms(column);
                           newRow.addView(column);
                       }
                   }

               }
               else {
                   Log.d(TAG, "onCreate: else part"+i);

                   if (i == flag+count) {
                       Log.d(TAG, "onCreate: else " + flag + "  " + count + " "+i);
                       if (flag+count  == j * 2) {
                           dynamicCOlumn = new TextView(this);
                           dynamicCOlumn.setText(hundered);
                           setAnotherParms(dynamicCOlumn);
                           newRow.addView(dynamicCOlumn);
                           flag = flag + count;
                           count++;

                       }
                       else {
                           column = new TextView(this);
                           column.setText(fifity);
                           setParms(column);

                           newRow.addView(column);
                       }

                   }
                   else {
                       column = new TextView(this);
                       column.setText(fifity);
                       setParms(column);
                       newRow.addView(column);
                   }
               }




            }


            tableLayout.addView(newRow,getTblLayoutParams());

        }
    }
    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(8, 8, 8, 8);
        return params;
    }
    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    private void setAnotherParms(TextView column) {

        column.setGravity(Gravity.CENTER);
        column.setBackgroundColor(Color.BLACK);
        column.setTextColor(Color.WHITE);
        column.setTextSize(16);
        column.setPadding(50, 50, 50, 50);
        //tv.setBackgroundColor(getResources().getColor(R.color.nice_color));
        column.setLayoutParams(getLayoutParams());

        //column.setWidth(100);
        //column.setHeight(100);
//    }
    }

    private void setParms(TextView column) {
        column.setGravity(Gravity.CENTER);
        column.setBackgroundColor(Color.BLACK);
        column.setTextColor(Color.WHITE);
        column.setTextSize(16);
        column.setPadding(30, 30, 30, 30);
        column.setLayoutParams(getLayoutParams());

        //column.setWidth(50);
        //column.setHeight(50);
    }
}
