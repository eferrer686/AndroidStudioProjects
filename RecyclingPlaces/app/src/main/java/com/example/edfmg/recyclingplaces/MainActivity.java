package com.example.edfmg.recyclingplaces;

import com.example.edfmg.recyclingplaces.adapters.PlacesRecyclerAdapter;
import com.example.edfmg.recyclingplaces.model.PlaceCard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://data.wprdc.org/dataset/10dd50cf-bf29-4268-83e2-debcacea7885/resource/cdb6c800-3213-4190-8d39-495e36300263/download/wasterecoveryimg.geojson" ;

    private JsonObjectRequest request;
    private RequestQueue requestQueue;
    private List<PlaceCard> cards;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards  =  new ArrayList<>();
        recyclerView =  findViewById(R.id.recyclerView);
        jsonrequest();
    }

    private void jsonrequest(){
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray cardsJson = response.getJSONArray("features");
                    JSONObject jsonObject= null;

                    for (int i  = 0; i<cardsJson.length();i++){

                        jsonObject = cardsJson.getJSONObject(i);
                        PlaceCard placeCard = new PlaceCard();
                        placeCard.setId(jsonObject.getString("id"));
                        placeCard.setName(jsonObject.getJSONObject("properties").getString("name"));
                        placeCard.setCity(jsonObject.getJSONObject("properties").getString("city"));
                        placeCard.setPhoneNumber(jsonObject.getJSONObject("properties").getString("phone_number"));
                        placeCard.setSchedule(jsonObject.getJSONObject("properties").getString("hours_of_operation"));
                        placeCard.setStreet(jsonObject.getJSONObject("properties").getString("street"));
                        placeCard.setStreetNumber(jsonObject.getJSONObject("properties").getString("address_number"));
                        placeCard.setWebsite(jsonObject.getJSONObject("properties").getString("website"));



//                        Log.i("Card Info: ", placeCard.toString());

                        cards.add(placeCard);
                    }
                }catch (JSONException jsonException){
                    jsonException.printStackTrace();
                }

                setRecyclerView(cards);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de server", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setRecyclerView(List<PlaceCard>pokeCards){
        PlacesRecyclerAdapter placesRecyclerAdapter = new PlacesRecyclerAdapter(this,pokeCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(placesRecyclerAdapter);


    }
}
