package com.example.machinetest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<String> list;
    private int pos = 0;
    Adapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (pos < list.size()) {

            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView1.setText(list.get(pos));

        }
        if (pos + 1 < list.size()) {

            holder.textView2.setVisibility(View.VISIBLE);
            holder.textView2.setText(list.get(pos + 1));

        }
        if (pos + 2 < list.size()) {
            holder.textView3.setVisibility(View.VISIBLE);
            holder.textView3.setText(list.get(pos + 2));

        }
        if (pos + 3 < list.size()) {

            holder.textView4.setVisibility(View.VISIBLE);
            holder.textView4.setText(list.get(pos + 3));


        }
        if (pos + 4 < list.size()) {

            holder.textView5.setVisibility(View.VISIBLE);
            holder.textView5.setText(list.get(pos + 4));
            pos = pos + 5;
        }
    }


    @Override
    public int getItemCount() {
        if (list.size() % 5 == 0) {
            return list.size() / 5;
        } else {

            return (list.size() / 5) + 1;
        }

    }

     class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView textView1, textView2, textView3, textView4, textView5;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            textView1 = itemView.findViewById(R.id.show_text1);
            textView2 = itemView.findViewById(R.id.show_text2);
            textView3 = itemView.findViewById(R.id.show_text3);
            textView4 = itemView.findViewById(R.id.show_text4);
            textView5 = itemView.findViewById(R.id.show_text5);

        }
    }
}
