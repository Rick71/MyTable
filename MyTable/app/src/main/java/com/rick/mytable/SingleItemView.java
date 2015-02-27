package com.rick.mytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Rick on 26/02/15.
 */
public class SingleItemView extends Activity {

    // Declare Variables
    TextView txtName;
    TextView txtDescription;
    TextView txtLatitude;
    TextView txtLongitude;

    String name;
    String description;
    String latitude;
    String longitude;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.singleitemview);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        description = i.getStringExtra("descripcion");
        latitude = i.getStringExtra("Latitud");
        longitude = i.getStringExtra("Longitud");


        txtName = (TextView) findViewById(R.id.name);
        txtDescription = (TextView) findViewById(R.id.description);
        txtLatitude = (TextView) findViewById(R.id.latitude);
        txtLongitude = (TextView) findViewById(R.id.longitud);

        txtName.setText(name);
        txtDescription.setText(description);
        txtLatitude.setText(latitude);
        txtLongitude.setText(longitude);
    }
}
