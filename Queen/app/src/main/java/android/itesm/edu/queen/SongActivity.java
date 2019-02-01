package android.itesm.edu.queen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class SongActivity extends AppCompatActivity{

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        textView = (TextView) findViewById(R.id.song);

        String string = getIntent().getStringExtra("file");
        String file = "";
        if(string.equals("bohemian")){
            file = getFile("bohemian.txt");
        } else if(string.equals("dont")){
            file = getFile("dontstopmenow.txt");
        } else if(string.equals("bite")){
            file = getFile("bitethedust.txt");
        } else if(string.equals("underpressure")){
            file = getFile("underpressure.txt");
        } else if(string.equals("iwanttobreakfree")){
            file = getFile("iwanttobreakfree.txt");
        }
        textView.setText(file);


    }

    private String getFile(String assetf){
        String file = "";
        try {
            InputStream is = getAssets().open(assetf);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            file = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
