package com.example.diego.androidlocationexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

public class MapsActivity extends FragmentActivity implements TravelTimeProvider.TravelTimeCallback{

    private TravelTimeProvider mTravelTimeProvider;

    TextView infoTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        String destination = "lat/lng: (-23.967434,-46.332918)"; //praça da independência - gonzaga

        infoTV = (TextView) findViewById(R.id.informationTextView);
        mTravelTimeProvider = new TravelTimeProvider(this, this, destination);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTravelTimeProvider.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mTravelTimeProvider.disconnect();
    }


    public void handleNewTravelTime(final String duration) {
        Log.d("Tempo de Percurso: ", duration.toString());
        infoTV.setText(duration);
    }
}