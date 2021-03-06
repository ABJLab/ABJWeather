package com.abjlab.abjweather.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        switch (id){
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_map:
                onPreferredLocation();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void onPreferredLocation(){
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        String location = shared.getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default));

        Uri locationUri = Uri.parse("geo:0,0?q="+location);
       // Toast.makeText(this.getApplicationContext(), "geo:0,0?q="+location, Toast.LENGTH_SHORT).show();
        Intent launchMap = new Intent(Intent.ACTION_VIEW, locationUri);
        if(launchMap.resolveActivity(getPackageManager()) != null){
            startActivity(launchMap);
        }else{
            Log.d("MAP", "Can't launch Map");
        }


    }
}
