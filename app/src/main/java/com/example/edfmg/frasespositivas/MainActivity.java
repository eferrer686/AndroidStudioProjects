package com.example.edfmg.frasespositivas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Random random;
    public ArrayList<String> frases;
    public TextView fraseTextView;
    public Button siguienteButton;
    public Button dayButton;
    public Button nightButton;

    public View background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        frases =  new ArrayList<String>();
        fraseTextView = (TextView) findViewById(R.id.fraseTextView);

        siguienteButton = (Button) findViewById(R.id.siguienteButton);
        dayButton = (Button) findViewById(R.id.dayButton);
        nightButton = (Button) findViewById(R.id.nightButton);

        background = (View) findViewById(R.id.mainActivity);

        frases.add("“Si puedes soñarlo puedes hacerlo, recuerda que todo esto comenzó con un ratón.”\n" +
                "Walt Disney");
        frases.add("“Cáete siete veces y levántate ocho.”");
        frases.add("“El triunfo del verdadero hombre surge de las cenizas del error.”\n" +
                "Pablo Neruda");
        frases.add("“Todo lo que puedas imaginar, es real.”\n" +
                "Pablo Picasso");
        frases.add("“El fracaso no es una opción. Todo el mundo tiene que triunfar.”\n" +
                "Arnold Schwarzenegger");
        frases.add("“Un objetivo sin un plan es solo un deseo.”\n" +
                "Antoine de Saint-Exupéry");
        frases.add("“Lo que haces hoy puede mejorar todos tus mañanas.”\n" +
                "Ralph Marston");
        frases.add("“Si dominamos nuestra mente, vendrá la felicidad.”\n" +
                "Dalai Lama");
        frases.add("“Cuanto más hacemos, más podemos hacer.”\n" +
                "William Hazlitt");
        frases.add("“Una meta es un sueño con una fecha límite.”\n" +
                "Napoleon Hill");

        setRandomFrase();
        day();


        siguienteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setRandomFrase();
            }
        });

        dayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                day();
            }
        });

        nightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                night();
            }
        });

    }

    private void setRandomFrase(){
        fraseTextView.setText(frases.get(random.nextInt(frases.size())));
    }

    private void day(){

        background.setBackgroundColor(Color.argb(255, 255, 255, 255));
        fraseTextView.setTextColor(Color.rgb(0,0,0));

    }
    private void night(){

        background.setBackgroundColor(Color.argb(255, 0, 0, 0));
        fraseTextView.setTextColor(Color.rgb(255,255,255));

    }
}
