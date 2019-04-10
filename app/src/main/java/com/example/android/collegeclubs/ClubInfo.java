package com.example.android.collegeclubs;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClubInfo extends AppCompatActivity {

    private String ClubName;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ArrayList<Events> eventObjList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_info);
        ClubName=getIntent().getExtras().getString("ClubName");
        //Log.e("ClubName",ClubName);
        database=FirebaseDatabase.getInstance();//getting the instance of the firebase database
        myRef=database.getReference("Clubs").child(ClubName);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String aa=dataSnapshot.child("Name").getValue(String.class);
                Clubs clubs=dataSnapshot.getValue(Clubs.class);
                displayValues(clubs);
               //Log.e("info",aa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRef=myRef.child("Events");
        final EventAdapter eventAdapter=new EventAdapter(this,eventObjList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(eventAdapter);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Events events = dataSnapshot.getValue(Events.class);
                eventObjList.add(events);
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Events events = dataSnapshot.getValue(Events.class);
                eventObjList.add(events);
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot child: dataSnapshot.getChildren())
                {
                    Events events=child.getValue(Events.class);
                    eventObjList.add(events);
                    Log.e("info",events.getDate()+events.getVenue()+events.getDescription()+events.getName());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        //EventAdapter eventAdapter=new EventAdapter(this,eventObjList);
        //ListView listView=(ListView)findViewById(R.id.list_view);
        //listView.setAdapter(eventAdapter);

    }

    public void displayValues(Clubs clubs)
    {
        String contact;
        String description;
        String head;
        String name;
        String website;

        TextView nameField=(TextView)findViewById(R.id.namefield);
        TextView descriptionField=(TextView)findViewById(R.id.descriptionfield);
        TextView headField=(TextView)findViewById(R.id.headField);
        TextView contactField=(TextView)findViewById(R.id.contactField);
        TextView websiteField=(TextView)findViewById(R.id.websiteField);

        contact=clubs.getContact_No();
        description=clubs.getDescription();
        head=clubs.getHead();
        name=clubs.getName();
        website=clubs.getWebsite();//

        nameField.setText(name);
        descriptionField.setText(description);
        headField.setText(head);
        contactField.setText(contact);
        websiteField.setText(website);
        //
    }
}
