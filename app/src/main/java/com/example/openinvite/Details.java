package com.example.openinvite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
//import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    private TextView titleTextView;
    private TextView releaseDateView;
    private TextView descriptionView;
    private ImageView posterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // get references to the views.
        titleTextView = (TextView) findViewById(R.id.title);
        releaseDateView = (TextView) findViewById(R.id.descr);
        posterView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Event event = intent.getParcelableExtra(EventsAdapter.EVENT);

        titleTextView.setText(event.get_name());
        releaseDateView.setText("Release Date: " + event.get_descr());
        //Picasso.with(posterView.getContext()).load(movie.getPoster_path()).into(posterView);
    }
}
