package com.abjlab.abjweather.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ArrayAdapter<String> forecastAdapter;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<String> fakeData = new ArrayList<>();
        fakeData.add("Fresco");
        fakeData.add("Va a chispear un poco");
        fakeData.add("Como va a pegar el Lorenzo");
        fakeData.add("Que llueva, que llueva, ...");
        fakeData.add("Puto mordor, que mal tiempo");
        fakeData.add("Joder que frio hace hoy en Siberia");
        fakeData.add("Se me van a congelar las pelotas");
        fakeData.add("Como siga soplando el viento hasta la foca de tu madre vuela");
        fakeData.add("Hostia, que sale el sol !!!");
        fakeData.add("0º, ni frio ni calor");
        fakeData.add("Con manga corta a clase, que somos de Bilbao");
        fakeData.add("Da igual el tiempo, va a ser una puta mierda");

        forecastAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, fakeData);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(forecastAdapter);
        return rootView;
    }
}
