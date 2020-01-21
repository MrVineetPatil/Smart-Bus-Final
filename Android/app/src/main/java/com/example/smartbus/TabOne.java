package com.example.smartbus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TabOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_one, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewRoutes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Routes[] myListData = new Routes[] {
                new Routes("Hebbal", "5/50"),
                new Routes("BEL Circle", "0/50"),
                new Routes("Gokula", "10/50"),
                new Routes("Matthikere", "15/50"),
                new Routes("Ramaiah College", "12/50"),
                new Routes("Yesvantpur", "0/50")
        };

        RoutesAdapter adapter = new RoutesAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
