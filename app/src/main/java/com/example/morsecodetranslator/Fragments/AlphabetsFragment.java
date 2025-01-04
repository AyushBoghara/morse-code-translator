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

import com.example.morsecodetranslator.Adapters.AlphabetsAdapter;
import com.example.morsecodetranslator.Adapters.SymbolsAdapter;
import com.example.morsecodetranslator.Models.AlphabetsModel;
import com.example.morsecodetranslator.R;

import java.util.ArrayList;

public class AlphabetsFragment extends Fragment {


    private AlphabetsAdapter adapter;
    private ArrayList<AlphabetsModel> alphabetList = new ArrayList<>();
    private RecyclerView recyclerView;

    public AlphabetsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabets, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewAlpha);

        alphabetList.add(new AlphabetsModel("A",".-"));
        alphabetList.add(new AlphabetsModel("B","-..."));
        alphabetList.add(new AlphabetsModel("C","-.-."));
        alphabetList.add(new AlphabetsModel("D","-.."));
        alphabetList.add(new AlphabetsModel("E","."));
        alphabetList.add(new AlphabetsModel("F","..-."));
        alphabetList.add(new AlphabetsModel("G","--."));
        alphabetList.add(new AlphabetsModel("H","...."));
        alphabetList.add(new AlphabetsModel("I",".."));
        alphabetList.add(new AlphabetsModel("J",".---"));
        alphabetList.add(new AlphabetsModel("K","-.-"));
        alphabetList.add(new AlphabetsModel("L",".-.."));
        alphabetList.add(new AlphabetsModel("M","--"));

        alphabetList.add(new AlphabetsModel("N","-."));
        alphabetList.add(new AlphabetsModel("O","---"));
        alphabetList.add(new AlphabetsModel("P",".--."));
        alphabetList.add(new AlphabetsModel("Q","--.-"));
        alphabetList.add(new AlphabetsModel("R",".-."));
        alphabetList.add(new AlphabetsModel("S","..."));
        alphabetList.add(new AlphabetsModel("T","-"));
        alphabetList.add(new AlphabetsModel("U","..-"));
        alphabetList.add(new AlphabetsModel("V","...-"));
        alphabetList.add(new AlphabetsModel("W",".--"));
        alphabetList.add(new AlphabetsModel("X","-..-"));
        alphabetList.add(new AlphabetsModel("Y","-.--"));
        alphabetList.add(new AlphabetsModel("Z","--.."));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new AlphabetsAdapter(getContext(),alphabetList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}