package android.itesm.edu.queen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private ArrayList<String> songs;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        random = new Random();

        songs = new ArrayList<String>();

        songs.add("Bohemian Rhapsody");
        songs.add("Don't Stop Me Now");
        songs.add("Another One Bites The Dust");
        songs.add("Under Pressure");
        songs.add("I Want To Break Free");


    }

    public void done(View view){
        Intent intent = new Intent();
        String value = songs.get(random.nextInt(songs.size()));
        ((TextView) findViewById(R.id.textView)).setText(value);
        intent.putExtra("random", value);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
