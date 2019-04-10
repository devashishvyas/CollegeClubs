package com.example.android.collegeclubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddEventAdmin extends AppCompatActivity {

    private String Photo_Url;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String ClubName;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_admin);
        ClubName=getIntent().getExtras().getString("ClubName");
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Clubs").child(ClubName).child("Events");
        mStorageRef = FirebaseStorage.getInstance().getReference();

    }

    public void uploadImage(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        //startActivityForResult(intent,GALLERY_INTENT);
    }

    public void AddEvent(View view)
    {
        Events event=new Events();

        EditText etEventName=(EditText)findViewById(R.id.etEventname);
        EditText etDate=(EditText)findViewById(R.id.etDate);
        EditText etDescription=(EditText)findViewById(R.id.etDescription);
        EditText etVenue=(EditText)findViewById(R.id.etVenue);

        event.setDate(etDate.getText().toString());
        event.setDescription(etDescription.getText().toString());
        event.setName(etEventName.getText().toString());
        event.setVenue(etVenue.getText().toString());
        //Event object
        myRef.child(event.getName()).setValue(event);


    }
}
