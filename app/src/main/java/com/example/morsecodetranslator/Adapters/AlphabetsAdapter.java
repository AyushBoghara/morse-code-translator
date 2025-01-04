package com.example.morsecodetranslator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.morsecodetranslator.Models.AlphabetsModel;
import com.example.morsecodetranslator.R;

import java.util.ArrayList;

public class AlphabetsAdapter  extends RecyclerView.Adapter<AlphabetsAdapter.ViewHolder> {
    Context context;
    ArrayList<AlphabetsModel> alphabetList;

    public AlphabetsAdapter(Context context, ArrayList<AlphabetsModel> alphabetList) {
        this.context = context;
        this.alphabetList = alphabetList;
    }

    @NonNull
    @Override
    public AlphabetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetsAdapter.ViewHolder holder, int position) {

        holder.number.setText(alphabetList.get(position).getAlphabet());
        holder.pattern.setText(alphabetList.get(position).getAlphabetPattern());
    }

    @Override
    public int getItemCount() {
        return 26;
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
