package com.issonet.virunga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.issonet.virunga.models.MyAdapterDonnees;
import com.issonet.virunga.models.donnees;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<donnees> dataListe;
    private MyAdapterDonnees adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.pullToRefresh);
        recyclerView = (RecyclerView)findViewById(R.id.lv);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.black)
                ,getResources().getColor(R.color.teal_200),
                getResources().getColor(R.color.black),getResources().getColor(R.color.purple_200));

        dataListe = new ArrayList<donnees>();
//        dataListe = achats.getAchatsAll(this,dataListe);//recuperation des donnees a partir de la bd sql lite
        adapter = new MyAdapterDonnees(this,dataListe);
        recyclerView.setAdapter(adapter);

        dataListe.add(new donnees(1,"Some title",getResources().getString(R.string.description),R.drawable.m1));
        dataListe.add(new donnees(2,"Some title",getResources().getString(R.string.description),R.drawable.m2));
        dataListe.add(new donnees(3,"Some title",getResources().getString(R.string.description),R.drawable.m3));
        dataListe.add(new donnees(4,"Some title",getResources().getString(R.string.description),R.drawable.m4));

        adapter.notifyDataSetChanged();

    }
}