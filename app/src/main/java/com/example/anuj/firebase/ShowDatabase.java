package com.example.anuj.firebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * Created by anuj on 25/4/18.
 */

public class ShowDatabase extends AppCompatActivity {

    private ListView listView;
    private FirebaseListAdapter<String> adapter;
    //private ArrayList<String> mUsername = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_show);

        listView = findViewById(R.id.list_view);

        //FirebaseDatabase db = FirebaseDatabase.getInstance();
        //DatabaseReference mRef = db.getReference("users");
        Query query = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-cfab5.firebaseio.com/users");

        //Log.v("\n\nQuery : ", query.toString());

        FirebaseListOptions<String> options = new FirebaseListOptions.Builder<String>()
                .setLayout(android.R.layout.simple_list_item_1)
                .setQuery(query, String.class)
                .build();

        adapter = new FirebaseListAdapter<String>(options) {
            @Override
            protected void populateView(View v, String model, int position) {
                TextView tv = v.findViewById(android.R.id.text1);
                tv.setText(model);
            }
        };

        listView.setAdapter(adapter);

/*
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsername);
        listView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String val = dataSnapshot.getValue(String.class);
                mUsername.add(val);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/
    }
}
