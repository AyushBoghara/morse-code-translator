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
import com.example.morsecodetranslator.Models.NumberModel;
import com.example.morsecodetranslator.R;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class NumberFragment extends Fragment {

    private  RecyclerView recyclerView;
    private ArrayList<NumberModel> list = new ArrayList<>();
    private NumbersAdapter adapter;

    public NumberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_number, container, false);
        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewNumber);

        list.add(new NumberModel("0","-----"));
        list.add(new NumberModel("1",".----"));
        list.add(new NumberModel("2","..---"));
        list.add(new NumberModel("3","...--"));
        list.add(new NumberModel("4","....-"));
        list.add(new NumberModel("5","....."));
        list.add(new NumberModel("6","-...."));
        list.add(new NumberModel("7","--..."));
        list.add(new NumberModel("8","---.."));
        list.add(new NumberModel("9","----."));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new NumbersAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}