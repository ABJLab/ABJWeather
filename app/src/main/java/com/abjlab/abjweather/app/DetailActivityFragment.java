package com.abjlab.abjweather.app;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private static final String LOG_TAG = DetailActivityFragment.class.getSimpleName();
    private ShareActionProvider mShareActionProvider;
    private String forecast;
    private static final String HASHTAG = "#EstoEsUnaPruebaABJ";

    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        //TODO: Gestionar el intent, si es null y esas cosas
        Bundle b1 = getActivity().getIntent().getExtras();
        Intent reqIntent = getActivity().getIntent();
        if(reqIntent != null){
            Bundle data = reqIntent.getExtras();
           forecast = (data != null)?data.getString(Intent.EXTRA_TEXT):"No se puede acceder a los datos, intentalo más tarde";
            TextView label = (TextView) rootView.findViewById(R.id.labelDetail);
            label.setText(forecast);
        }
        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.detailfragment, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if (mShareActionProvider != null ) mShareActionProvider.setShareIntent(shareInfo());
        else Log.d(LOG_TAG, "Toma, toma, toma, la que has liado!!! No, que el shareactionprovider este es nulo, arreglalo melón");

    }


    private Intent shareInfo(){
        String sendData = forecast + " " + HASHTAG;
        Intent launchShare = new Intent(Intent.ACTION_SEND);
        launchShare.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        launchShare.setType("text/plain");
        launchShare.putExtra(Intent.EXTRA_TEXT, sendData);
        return launchShare;

    }
}
