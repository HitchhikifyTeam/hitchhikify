package org.hitchhikify;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by hlib on 28.01.18.
 */

public class WaitingActivity extends AppCompatActivity {
    private static final String DISTANCE_TRAVELLED = "distance_travelled";
    private static final String CARS_TRAVELLED = "cars_travelled";
    private static final String TRIP_DURATION = "trip_duration";
    private static final String AVERAGE_SPEED = "average_speed";
    private static final String WAIT_UP_TO = "wait_up_to";

    public static Intent buildIntent(Context context, int distanceTravelled, int carsTravelled,
                                     int tripDuration, int averageSpeed, int waitUpTo) {
        Intent intent = new Intent(context, WaitingActivity.class);
        intent.putExtra(WAIT_UP_TO, waitUpTo);
        intent.putExtra(DISTANCE_TRAVELLED, distanceTravelled);
        intent.putExtra(CARS_TRAVELLED, carsTravelled);
        intent.putExtra(TRIP_DURATION, tripDuration);
        intent.putExtra(AVERAGE_SPEED, averageSpeed);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        Intent intent = getIntent();
        int waitUpTo = intent.getIntExtra(WAIT_UP_TO, -1);
        int distanceTravelled = intent.getIntExtra(DISTANCE_TRAVELLED, -1);
        int carsTravelled = intent.getIntExtra(CARS_TRAVELLED, -1);
        int tripDuration = intent.getIntExtra(TRIP_DURATION, -1);
        int avergeSpeed = intent.getIntExtra(AVERAGE_SPEED, -1);

        Resources resources = getResources();

        TextView mDontWorryTextView = (TextView) findViewById(R.id.dont_worry_text_view);
        mDontWorryTextView.setText(resources.getString(R.string.dont_worry, waitUpTo));

        Tile mDistanceTravelledTile = (Tile) findViewById(R.id.waiting_distance_travelled_tile);
        mDistanceTravelledTile.setText(
                        resources.getString(R.string.km_so_far, distanceTravelled));

        Tile mCarsTravelledTile = (Tile) findViewById(R.id.cars_travelled_tile);
        mCarsTravelledTile.setText(resources.getString(R.string.cars_so_far, carsTravelled));

        Tile mCurrentTripDurationTile = (Tile) findViewById(R.id.current_trip_duration_tile);
        mCurrentTripDurationTile.setText(
                resources.getString(R.string.current_trip_duration, tripDuration));

        Tile mAverageSpeedTile = (Tile) findViewById(R.id.average_speed_tile);
        mAverageSpeedTile.setText(
                resources.getString(R.string.average_speed, avergeSpeed));
    }
}
