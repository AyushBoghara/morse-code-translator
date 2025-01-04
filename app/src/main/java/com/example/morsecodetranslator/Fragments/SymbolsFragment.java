package com.example.morsecodetranslator.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.morsecodetranslator.Adapters.NumbersAdapter;
import com.example.morsecodetranslator.Adapters.SymbolsAdapter;
import com.example.morsecodetranslator.Models.NumberModel;
import com.example.morsecodetranslator.Models.SymbolsModel;
import com.example.morsecodetranslator.R;

import java.util.ArrayList;


public class SymbolsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<SymbolsModel> symbolList = new ArrayList<>();
    private SymbolsAdapter adapter;

    public SymbolsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_symbols, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewSymbol);

        symbolList.add(new SymbolsModel("&",".-..."));
        symbolList.add(new SymbolsModel("'",".----."));
        symbolList.add(new SymbolsModel("@",".--.-."));
        symbolList.add(new SymbolsModel(")","-.--.-"));
        symbolList.add(new SymbolsModel("(","-.--."));
        symbolList.add(new SymbolsModel(":","---..."));
        symbolList.add(new SymbolsModel(";","-.-.-."));
        symbolList.add(new SymbolsModel(",","--..--"));
        symbolList.add(new SymbolsModel("=","-...-"));
        symbolList.add(new SymbolsModel("!","-.-.--"));
        symbolList.add(new SymbolsModel(".",".-.-.-"));
        symbolList.add(new SymbolsModel("-","-....-"));
        symbolList.add(new SymbolsModel("+",".-.-."));
        symbolList.add(new SymbolsModel("\"",".-..-."));
        symbolList.add(new SymbolsModel("?","..--.."));
        symbolList.add(new SymbolsModel("/","-..-."));
        symbolList.add(new SymbolsModel("Space","/"));
        symbolList.add(new SymbolsModel("New Line",".-.-"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new SymbolsAdapter(getContext(),symbolList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}