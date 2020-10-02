package com.example.Shabir_Ahmad142_appdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataValidation extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter adapter;

    List<DataList> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataLists = new ArrayList<>();

        loadRecyclerViewData();

    }

    private void loadRecyclerViewData() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data ...");
        progressDialog.show();

//        FirebaseRecyclerOptions<DataList> options =
//                new FirebaseRecyclerOptions.Builder<DataList>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), DataList.class)
//                        .build();
//
//
//        adapter = new DataAdapter(options);
//        recyclerView.setAdapter(adapter);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot npSnapshot:snapshot.getChildren()){
                        DataList d  = npSnapshot.getValue(DataList.class);
                        dataLists.add(d);
                    }
                    adapter = new DataAdapter(dataLists,DataValidation.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }

}

