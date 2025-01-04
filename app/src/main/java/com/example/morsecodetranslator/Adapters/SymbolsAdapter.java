package com.example.morsecodetranslator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.morsecodetranslator.Models.SymbolsModel;
import com.example.morsecodetranslator.R;

import java.util.ArrayList;

public class SymbolsAdapter  extends RecyclerView.Adapter<SymbolsAdapter.ViewHolder> {

    Context context;
    ArrayList<SymbolsModel> symbolList;

    public SymbolsAdapter(Context context, ArrayList<SymbolsModel> symbolList) {
        this.context = context;
        this.symbolList = symbolList;
    }

    @NonNull
    @Override
    public SymbolsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SymbolsAdapter.ViewHolder holder, int position) {

        holder.symbol.setText(symbolList.get(position).getSymbol());
        holder.symbolPattern.setText(symbolList.get(position).getPatternSymbol());
    }

    @Override
    public int getItemCount() {
        //fix size
        return 17;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView symbol,symbolPattern;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symbol = itemView.findViewById(R.id.tvText);
            symbolPattern = itemView.findViewById(R.id.tvCode);
        }
    }
}
