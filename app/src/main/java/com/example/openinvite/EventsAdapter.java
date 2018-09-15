package com.example.openinvite;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This fills the RecyclerView with the Movie data that we loaded.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    public static final String EVENT = "EVENT";
    ArrayList<Event> events;

    public EventsAdapter(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * This function is called only enough times to cover the screen with views.  After
     * that point, it recycles the views when scrolling is done.
     * @param parent the intended parent object (our RecyclerView)
     * @param viewType unused in our function (enables having different kinds of views in the same RecyclerView)
     * @return the new ViewHolder we allocate
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // a LayoutInflater turns a layout XML resource into a View object.
        final View eventListItem = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.event_list_item, parent, false);
        return new ViewHolder(eventListItem);
    }

    /**
     * This function gets called each time a ViewHolder needs to hold data for a different
     * position in the list.
     * @param holder the ViewHolder that knows about the Views we need to update
     * @param position the index into the array of Movies
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event event = events.get(position);

        holder.titleView.setText(event.get_name());
        holder.descrView.setText("Description: " + event.get_descr());
        //Picasso.with(holder.imageView.getContext())
        //        .load(movie.getPoster_path()).into(holder.imageView);

        // Attach a click listener that launches a new Activity
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Code for launching an Explicit Intent to go to another Activity in
                // the same App.
                Intent intent = new Intent(v.getContext(), Details.class);

                /* Pass data as a Parcelable Plain-Old Java Object (POJO) */
                intent.putExtra(EVENT ,event);

                v.getContext().startActivity(intent);
            }
        });
    }

    /**
     * RecyclerView wants to know how many list items there are, so it knows when it gets to the
     * end of the list and should stop scrolling.
     * @return the number of Movies in the array.
     */
    @Override
    public int getItemCount() {
        return events.size();
    }

    /**
     * A ViewHolder class for our adapter that 'caches' the references to the
     * subviews, so we don't have to look them up each time.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView titleView;
        public TextView descrView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            titleView = (TextView) itemView.findViewById(R.id.titleView);
            descrView = (TextView) itemView.findViewById(R.id.descrView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}