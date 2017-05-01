package com.example.laksh_pc.facapp;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class AttendanceFrag extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_attendance_frag, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Faculty").child("Student").child("S1");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
//                    Toast.makeText(getContext(), "Data to show", Toast.LENGTH_LONG).show();
                    startShowing();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

    private void startShowing() {

        FirebaseRecyclerAdapter<Student, AttendanceFrag.RequestViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Student, AttendanceFrag.RequestViewHolder>(
                Student.class,
                R.layout.custom_row,
                AttendanceFrag.RequestViewHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(AttendanceFrag.RequestViewHolder viewHolder, Student model, int position) {

                viewHolder.setName(model.getName());
                viewHolder.setAp(model.getAp());
                viewHolder.setRegno(model.getRegno());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public RequestViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String name) {
            TextView stname = (TextView) mView.findViewById(R.id.st_name);
            stname.setText(name);
        }

        public void setRegno(String regno) {
            TextView stregno = (TextView) mView.findViewById(R.id.st_regno);
            stregno.setText(regno);
        }

        public void setAp(String ap) {
            TextView stap = (TextView) mView.findViewById(R.id.st_ap);
            stap.setText(ap);
        }
    }
}