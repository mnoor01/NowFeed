package com.example.nowfeed;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Millochka on 11/8/16.
 */
public class WeatherFragment extends Fragment {

    private final String WDESCRIPTION = "WDESCRIPTION";
    private final String WCITY = "WCITY";
    private final String WICON = "WICON";
    private final String WPRESSURE = "WPRESSURE";
    private final String WHUMIDITY = "WHUMIDITY";
    private final String WTEMP = "WTEMP";

    private TextView mDescription;
    private TextView mCity;
    private ImageView mIcon;
    private TextView mPressure;
    private TextView mHumidity;
    private TextView mTemp;
    CardView mWeather;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.weather_details, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTextView(view);
        Picasso.with(view.getContext()).load(getArguments().getString(WICON)).resize(170, 170).centerCrop().into(mIcon);


    }

    @Override
    public void onResume() {
        super.onResume();
        mDescription.setText(getArguments().getString(WDESCRIPTION));
        mCity.setText(getArguments().getString(WCITY));
        mTemp.setText(getArguments().getString(WTEMP));
        mPressure.setText(getArguments().getString(WPRESSURE));
        mHumidity.setText(getArguments().getString(WHUMIDITY));
        //mWeather.setOnClickListener(this);

    }

    public void initTextView(View view) {


        mDescription = (TextView) view.findViewById(R.id.weather_discription);
        mCity = (TextView) view.findViewById(R.id.cityText);
        mIcon = (ImageView) view.findViewById(R.id.weather_icon);
        mTemp = (TextView) view.findViewById(R.id.temp);
        mPressure = (TextView) view.findViewById(R.id.press);
        mHumidity = (TextView) view.findViewById(R.id.hum);
        mWeather = (CardView) view.findViewById(R.id.weather_fragment);

    }


//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(view.getContext(), MainActivity.class);
//        startActivity(intent);
//
//    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

//        SharedPreferences weatherSharedPref= getActivity().getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = 
    }
}
