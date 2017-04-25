package com.example.laksh_pc.facapp;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class AttendanceFrag extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_frag);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Student");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                startShowing();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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