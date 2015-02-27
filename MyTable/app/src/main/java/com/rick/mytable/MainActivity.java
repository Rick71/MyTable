package com.rick.mytable;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends ActionBarActivity {

    ListView listView;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<Lugar> LugarList = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.activity_main);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Lugar BAR APP");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
// Create the array
            LugarList = new ArrayList<Lugar>();
            try {
// Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject> ("Lugar");
// Locate the column named "ranknum" in Parse.com and order list
// by ascending
                query.orderByAscending("createdAt");
                ob = query.find();

                for (ParseObject LugarBebidas : ob) {
                    Lugar LugarBar = new Lugar();
                    LugarBar.setName((String) LugarBebidas.get("name"));
                    LugarBar.setDescripcion((String) LugarBebidas.get("descripcion"));
                    LugarBar.setLatitud((String) LugarBebidas.get("Latitud"));
                    LugarBar.setLongitud((String) LugarBebidas.get("Longitud"));
                    LugarList.add(LugarBar);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
// Locate the listview in listview_main.xml
            listView = (ListView) findViewById(R.id.DataTable);
// Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(MainActivity.this ,LugarList);
// Binds the Adapter to the ListView
            listView.setAdapter(adapter);
// Close the progressdialog
            mProgressDialog.dismiss();
        }
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
