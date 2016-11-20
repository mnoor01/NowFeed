package com.example.nowfeed;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.nowfeed.model.BestSeller;
import com.example.nowfeed.model.City;
import com.example.nowfeed.model.Forecast;
import com.example.nowfeed.model.ForecastFiveDays;
import com.example.nowfeed.model.Instagram;
import com.example.nowfeed.model.TopStory;
import com.example.nowfeed.model.Weather;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Millochka on 10/30/16.
 */
public class CardAdapter extends RecyclerView.Adapter implements ViewGroup.OnClickListener {

    private List<Object> items;
    static InstagramFragment instafrag = new InstagramFragment();
    static FragmentManager fragmentManager;
    static boolean isFragOpen = false;
    private Activity a;
    private RecyclerView hRecyclerView;


    public final int INSTAGRAM = 0, WEATHER = 1, NOTES = 2, TOPSTORIES = 3, BESTSELLERS = 4;

    public static final String SHARED_NAME = "mynotes";

    public CardAdapter(List<Object> items, FragmentManager fmInput, Activity aInput) {
        this.items = items;
        this.fragmentManager = fmInput;
        this.a = aInput;
    }

    private final String WDESCRIPTION = "WDESCRIPTION";
    private final String WCITY = "WCITY";
    private final String WICON = "WICON";
    private final String WPRESSURE = "WPRESSURE";
    private final String WHUMIDITY = "WHUMIDITY";
    private final String WTEMP = "WTEMP";

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case INSTAGRAM:
                viewHolder = new InstagramCardViewHolder(parent);
                break;
            case WEATHER:
                viewHolder = new SecondCardViewHolder(parent);
                break;
            case TOPSTORIES:
                viewHolder = new TopStoriesRecyclerView(parent);
                break;
            case BESTSELLERS:
                viewHolder = new BestSellersRecyclerView(parent);
                break;
            default:
                viewHolder = new ThirdCardViewHolder(parent);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case INSTAGRAM:
                InstagramCardViewHolder firstCard = (InstagramCardViewHolder) holder;
                firstCard.onBind((Instagram) items.get(position));
                ((InstagramCardViewHolder) holder).ivMedia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentManager.beginTransaction().add(R.id.idFragLayout, instafrag).commit();
                        isFragOpen = true;
                    }
                });
                break;
            case WEATHER:
                SecondCardViewHolder secondCard = (SecondCardViewHolder) holder;
                secondCard.onBind((ForecastFiveDays) items.get(position));
                initOnClick(secondCard);
                onClick(secondCard.mView);
                break;
            case TOPSTORIES:
                TopStoriesRecyclerView topviewedCard = (TopStoriesRecyclerView) holder;
                topviewedCard.onBind((TopStory) items.get(position));

                hRecyclerView = (RecyclerView) holder.itemView.findViewById(R.id.idTopStoriesRecyclerView);
                hRecyclerView.setNestedScrollingEnabled(false);
                hRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                hRecyclerView.setAdapter(new TopStoriesAdapter(items.get(position)));

                break;
            case BESTSELLERS:
                BestSellersRecyclerView bestSellersCard = (BestSellersRecyclerView) holder;
                bestSellersCard.onBind((BestSeller) items.get(position));
                Log.d("stuff", "" + ((BestSeller) items.get(position)).getResults().size());

                hRecyclerView = (RecyclerView) holder.itemView.findViewById(R.id.idBestSellerRecyclerView);
                hRecyclerView.setNestedScrollingEnabled(false);
                hRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                hRecyclerView.setAdapter(new BestSellersAdapter(items.get(position)));
                break;
            default:
                break;

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Instagram) {
            return INSTAGRAM;
        } else if (items.get(position) instanceof ForecastFiveDays) {
            return WEATHER;
        } else if (items.get(position) instanceof BestSeller) {
            return BESTSELLERS;
        } else if (items.get(position) instanceof TopStory) {
            return TOPSTORIES;
        } else if (items.get(position) instanceof String) {
            return NOTES;
        }
        return -1;
    }

    @Override
    public void onClick(View view) {

        WeatherFragment detailedWeather = new WeatherFragment();
        int itemId = view.getId();
        switch (itemId) {
            case R.id.day1:
                detailedWeather.setArguments(retrieveWeatherDetails(0, (ForecastFiveDays) items.get(1)));
                fragmentManager.beginTransaction().add(R.id.weather_CV, detailedWeather, TAG).commit();
                break;
            case R.id.day2:
                detailedWeather.setArguments(retrieveWeatherDetails(1, (ForecastFiveDays) items.get(1)));
                fragmentManager.beginTransaction().add(R.id.weather_CV, detailedWeather, TAG).commit();
                break;
            case R.id.day3:
                detailedWeather.setArguments(retrieveWeatherDetails(2, (ForecastFiveDays) items.get(1)));
                fragmentManager.beginTransaction().add(R.id.weather_CV, detailedWeather, TAG).commit();
                break;
            case R.id.day4:
                detailedWeather.setArguments(retrieveWeatherDetails(3, (ForecastFiveDays) items.get(1)));
                fragmentManager.beginTransaction().add(R.id.weather_CV, detailedWeather, TAG).commit();
                break;
            case R.id.day5:
                detailedWeather.setArguments(retrieveWeatherDetails(4, (ForecastFiveDays) items.get(1)));
                fragmentManager.beginTransaction().add(R.id.weather_CV, detailedWeather, TAG).commit();
                break;
        }
    }


    public Bundle retrieveWeatherDetails(int index, ForecastFiveDays weatherRespond) {

        City city = weatherRespond.getCity();
        List<Forecast> forecast = weatherRespond.getList();
        Bundle bundle = new Bundle();
        Weather weather = forecast.get(index).getWeather().get(0);
        bundle.putString(WDESCRIPTION, weather.getMain() + "(" + weather.getDescription() + ")");
        bundle.putString(WCITY, city.getName() + "," + city.getCountry());
        bundle.putString(WICON, "http://openweathermap.org/img/w/" + weather.getIcon() + ".png");
        double temperature = Math.round(1.8 * (forecast.get(index).getTemp().getMax() - 273) + 32);
        bundle.putString(WTEMP, Double.toString(temperature) + " ºF");
        bundle.putString(WPRESSURE, Double.toString(forecast.get(index).getPressure()) + " hPa");
        bundle.putString(WHUMIDITY, Double.toString(forecast.get(index).getHumidity()) + " %");

        return bundle;
    }

    public void initOnClick(SecondCardViewHolder holder) {
        holder.getmDay1().setOnClickListener(this);
        holder.getmDay2().setOnClickListener(this);
        holder.getmDay3().setOnClickListener(this);
        holder.getmDay4().setOnClickListener(this);
        holder.getmDay5().setOnClickListener(this);
    }

    public static InstagramFragment getInstaFrag() {
        return instafrag;
    }

    public static FragmentManager getFragMan() {
        return fragmentManager;
    }

    public static boolean getIsTrue() {
        return isFragOpen;
    }

}
