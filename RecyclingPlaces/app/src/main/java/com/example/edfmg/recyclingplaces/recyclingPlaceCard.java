package com.example.edfmg.recyclingplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.edfmg.recyclingplaces.model.PlaceCard;

public class recyclingPlaceCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling_place_card);

        Log.i("New Card:","Change of activity");

        PlaceCard placeCard = (PlaceCard) getIntent().getSerializableExtra("place");

        Log.i("New Card:",placeCard.toString());

        loadPlace(placeCard);
    }

    private void loadPlace(PlaceCard placeCard){

        Log.i("New Card:","Loading card");

        TextView id,name,street,streetNumber,phone,web,city,schedule;

        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        street = findViewById(R.id.street);
        streetNumber = findViewById(R.id.streetNumber);
        phone = findViewById(R.id.phone);
        web = findViewById(R.id.web);
        city = findViewById(R.id.city);
        schedule = findViewById(R.id.schedule);

        Log.i("New Card:","Setting text");


        name.setText(placeCard.getName());
        id.setText(placeCard.getId());
        street.setText(placeCard.getStreet());
        streetNumber.setText(placeCard.getStreetNumber());
        phone.setText(placeCard.getPhoneNumber());
        web.setText(placeCard.getWebsite());
        city.setText(placeCard.getCity());
        schedule.setText(placeCard.getSchedule());



        Log.i("New Card:","Loaded card");

    }
}
