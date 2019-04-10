package com.example.android.collegeclubs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Events> {

    public EventAdapter(Context context, ArrayList<Events> pEvents)
    {
        super(context,0,pEvents);
    }




    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.events_cards, parent, false);
        }
        Events local_word = (Events) getItem(position);

        TextView eventNameTV = (TextView) listItemView.findViewById(R.id.event_name);
        eventNameTV.setText(local_word.getName());

        TextView eventVenueTV = (TextView) listItemView.findViewById(R.id.event_venue);
        eventVenueTV.setText(local_word.getVenue());

        TextView eventDateTV = (TextView) listItemView.findViewById(R.id.event_date);
        eventDateTV.setText(local_word.getName());

        TextView eventDescpTV = (TextView) listItemView.findViewById(R.id.event_description);
        eventDescpTV.setText(local_word.getDescription());


        return listItemView;
    }
}
