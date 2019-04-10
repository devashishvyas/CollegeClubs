package com.example.android.collegeclubs;

import android.content.Intent;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public  static String ClubName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void HashButton(View view)
    {
        ClubName="HashInclude";
        callClubInfo();
    }
    public void EcellButton(View view)
    {
        ClubName="ECell";
        callClubInfo();
    }
    public void OjaswaButton(View view)
    {
        ClubName="Ojaswa";
        callClubInfo();
    }
    public void TrivimButton(View view)
    {
        ClubName="Trivim";
        callClubInfo();
    }
    public void PratibimbButton(View view)
    {
        ClubName="Pratibimb";
        callClubInfo();
    }
    public void SAEButton(View view)
    {
        ClubName="SAE";
        callClubInfo();
    }
    public void callClubInfo()
    {
        Intent i = new Intent(this,ClubInfo.class);
        i.putExtra("ClubName",ClubName);
        startActivity(i);
    }
    public void AdminButton(View View)
    {
        EditText admin=(EditText)findViewById(R.id.admin_club);
        String clubname=admin.getText().toString();
        Intent intent=new Intent(this,AddEventAdmin.class);
        intent.putExtra("ClubName",clubname);
        startActivity(intent);

    }
}
