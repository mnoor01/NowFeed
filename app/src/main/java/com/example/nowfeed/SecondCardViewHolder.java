package com.example.nowfeed;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nowfeed.model.City;
import com.example.nowfeed.model.Forecast;
import com.example.nowfeed.model.ForecastFiveDays;
import com.example.nowfeed.model.Weather;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Millochka on 10/31/16.
 */

public class SecondCardViewHolder extends RecyclerView.ViewHolder {

    TextView mDescription1;
    TextView mDescription2;
    TextView mDescription3;
    TextView mDescription4;
    TextView mDescription5;
    TextView mCity;
    ImageView mIcon1;
    ImageView mIcon2;
    ImageView mIcon3;
    ImageView mIcon4;
    ImageView mIcon5;
    View mView;
    TextView mTemp1;
    TextView mTemp2;
    TextView mTemp3;
    TextView mTemp4;
    TextView mTemp5;
    TextView mPress;
    TextView mHum;
    TextView mWindSpeed;
    LinearLayout mDay1;
    LinearLayout mDay2;
    LinearLayout mDay3;
    LinearLayout mDay4;
    LinearLayout mDay5;

    public LinearLayout getmDay1() {
        return mDay1;
    }

    public LinearLayout getmDay2() {
        return mDay2;
    }

    public LinearLayout getmDay3() {
        return mDay3;
    }

    public LinearLayout getmDay4() {
        return mDay4;
    }

    public LinearLayout getmDay5() {
        return mDay5;
    }

    AppCompatActivity activity = new AppCompatActivity();


    public SecondCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        mView = itemView;
        //mTitle=(TextView)mView.findViewById(R.id.weather_title);
        mDescription1 = (TextView) mView.findViewById(R.id.weather_discription1);
        mDescription2 = (TextView) mView.findViewById(R.id.weather_discription2);
        mDescription3 = (TextView) mView.findViewById(R.id.weather_discription3);
        mDescription4 = (TextView) mView.findViewById(R.id.weather_discription4);
        mDescription5 = (TextView) mView.findViewById(R.id.weather_discription5);
        mIcon1 = (ImageView) mView.findViewById(R.id.weather_icon1);
        mIcon2 = (ImageView) mView.findViewById(R.id.weather_icon2);
        mIcon3 = (ImageView) mView.findViewById(R.id.weather_icon3);
        mIcon4 = (ImageView) mView.findViewById(R.id.weather_icon4);
        mIcon5 = (ImageView) mView.findViewById(R.id.weather_icon5);
        mCity = (TextView) mView.findViewById(R.id.cityText);
        mTemp1 = (TextView) mView.findViewById(R.id.temp1);
        mTemp2 = (TextView) mView.findViewById(R.id.temp2);
        mTemp3 = (TextView) mView.findViewById(R.id.temp3);
        mTemp4 = (TextView) mView.findViewById(R.id.temp4);
        mTemp5 = (TextView) mView.findViewById(R.id.temp5);
        mPress = (TextView) mView.findViewById(R.id.press);
        mHum = (TextView) mView.findViewById(R.id.hum);
        mWindSpeed = (TextView) mView.findViewById(R.id.windSpeed);
        mDay1 = (LinearLayout) mView.findViewById(R.id.day1);
        mDay2 = (LinearLayout) mView.findViewById(R.id.day2);
        mDay3 = (LinearLayout) mView.findViewById(R.id.day3);
        mDay4 = (LinearLayout) mView.findViewById(R.id.day4);
        mDay5 = (LinearLayout) mView.findViewById(R.id.day5);
    }


    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.second_card, parent, false);
    }


    protected void onBind(ForecastFiveDays weatherRespond) {

        City city = weatherRespond.getCity();
        mCity.setText(city.getName() + "," + city.getCountry());

        List<Forecast> forecast = weatherRespond.getList();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd ");
        Calendar cal = Calendar.getInstance();
        Log.d(TAG, cal.getTime().toString());
        Date date= new Date();



        Weather weather1 = forecast.get(0).getWeather().get(0);
        Picasso.with(mView.getContext()).load("http://openweathermap.org/img/w/" + weather1.getIcon() + ".png").resize(170, 170).centerCrop().into(mIcon1);
        double temperature1 = Math.round(1.8 * (forecast.get(0).getTemp().getMax() - 273) + 32);
        mTemp1.setText(Double.toString(temperature1) + " ºF");
        mDescription1.setText(String.valueOf(date.getMonth()+1)+"/"+String.valueOf(date.getDate()));
        Weather weather2 = forecast.get(1).getWeather().get(0);
        Picasso.with(mView.getContext()).load("http://openweathermap.org/img/w/" + weather2.getIcon() + ".png").resize(170, 170).centerCrop().into(mIcon2);
        double temperature2 = Math.round(1.8 * (forecast.get(1).getTemp().getMax() - 273) + 32);
        mDescription2.setText(String.valueOf(date.getMonth()+1)+"/"+String.valueOf(date.getDate()+1));
        mTemp2.setText(Double.toString(temperature2) + " ºF");
        Weather weather3 = forecast.get(2).getWeather().get(0);
        Picasso.with(mView.getContext()).load("http://openweathermap.org/img/w/" + weather3.getIcon() + ".png").resize(170, 170).centerCrop().into(mIcon3);
        double temperature3 = Math.round(1.8 * (forecast.get(2).getTemp().getMax() - 273) + 32);
        mTemp3.setText(Double.toString(temperature3) + " ºF");
        mDescription3.setText(String.valueOf(date.getMonth()+1)+"/"+String.valueOf(date.getDate()+2));
        Weather weather4 = forecast.get(3).getWeather().get(0);
        Picasso.with(mView.getContext()).load("http://openweathermap.org/img/w/" + weather4.getIcon() + ".png").resize(170, 170).centerCrop().into(mIcon4);
        double temperature4 = Math.round(1.8 * (forecast.get(3).getTemp().getMax() - 273) + 32);
        mTemp4.setText(Double.toString(temperature4) + " ºF");
        mDescription4.setText(String.valueOf(date.getMonth()+1)+"/"+String.valueOf(date.getDate()+3));
        Weather weather5 = forecast.get(4).getWeather().get(0);
        Picasso.with(mView.getContext()).load("http://openweathermap.org/img/w/" + weather5.getIcon() + ".png").resize(170, 170).centerCrop().into(mIcon5);
        double temperature5 = Math.round(1.8 * (forecast.get(4).getTemp().getMax() - 273) + 32);
        mTemp5.setText(Double.toString(temperature5) + " ºF");
        mDescription5.setText(String.valueOf(date.getMonth()+1)+"/"+String.valueOf(date.getDate()+4));
    }
}

