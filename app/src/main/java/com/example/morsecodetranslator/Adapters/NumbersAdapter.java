package com.example.morsecodetranslator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.morsecodetranslator.Models.NumberModel;
import com.example.morsecodetranslator.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {
    Context context;
    ArrayList<NumberModel> list;

    public NumbersAdapter(Context context, ArrayList<NumberModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NumbersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersAdapter.ViewHolder holder, int position) {

        holder.number.setText(list.get(position).getNumber());
        holder.pattern.setText(list.get(position).getPattern());
    }

    @Override
    public int getItemCount() {
        //fix size
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView number,pattern;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.tvText);
            pattern = itemView.findViewById(R.id.tvCode);

        }
    }
}
