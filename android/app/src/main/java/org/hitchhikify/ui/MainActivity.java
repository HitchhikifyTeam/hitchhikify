package org.hitchhikify.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.hitchhikify.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private Button mStartNewTripButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartNewTripButton = (Button) findViewById(R.id.start_new_trip_button);
        mStartNewTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int distanceTravelled = 70;
                int carsTravelled = 7;
                int tripDuration = 21;
                int averageSpeed = 34;
                startActivity(WaitingActivity.buildIntent(MainActivity.this,
                        distanceTravelled, carsTravelled, tripDuration, averageSpeed, 30));
            }
        });
        TextView editProfileTextView = (TextView) findViewById(R.id.edit_profile_text_view);
        editProfileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Edit profile", Toast.LENGTH_LONG).show();
            }
        });
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        circleImageView.setImageURI(Uri.parse("https://scontent-mxp1-1.xx.fbcdn.net/v/t1.0-1/p160x160/23795485_1795370397162891_851702792683737565_n.jpg?oh=59ee48dac48f21cc37bedacc5423370c&oe=5ADB100A"));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);        toolbar.setTitle("Hi there");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
