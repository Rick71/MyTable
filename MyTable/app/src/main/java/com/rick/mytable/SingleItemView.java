package com.rick.mytable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

/**
 * Created by Rick on 26/02/15.
 */
public class SingleItemView extends Activity {

    // Declare Variables
    TextView txtName;
    TextView txtDescription;
    TextView txtLatitude;
    TextView txtLongitude;
    ImageView picBar;

    String name;
    String description;
    String latitude;
    String longitude;
    byte[] imageBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.singleitemview);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        description = i.getStringExtra("descripcion");
        latitude = i.getStringExtra("Latitud");
        longitude = i.getStringExtra("Longitud");
        imageBar = i.getByteArrayExtra("image");


        txtName = (TextView) findViewById(R.id.name);
        txtDescription = (TextView) findViewById(R.id.description);
        txtLatitude = (TextView) findViewById(R.id.latitude);
        txtLongitude = (TextView) findViewById(R.id.longitud);
        picBar = (ImageView) findViewById(R.id.imgBar);

        try {
            txtName.setText(name);
            txtDescription.setText(description);
            txtLatitude.setText(latitude);
            txtLongitude.setText(longitude);
            picBar.setImageDrawable(Drawable.createFromStream(new ByteArrayInputStream(imageBar), name));

        } catch (Exception e) {
            Log.i("Error", e.getMessage());
        }
    }
}