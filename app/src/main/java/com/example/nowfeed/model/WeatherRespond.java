package com.example.nowfeed.model;

import java.util.List;

/**
 * Created by Millochka on 11/4/16.
 */

public class WeatherRespond {

    Coordinate coord;
    List<Weather> weather;
    WeatherMain main;
    Wind wind;
    Sys sys;
    long id;
    String name;
    int cod;

    public List<Weather> getWeather() {
        return weather;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public WeatherMain getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public class Coordinate {
        float lon;
        float lat;
    }

    public class WeatherMain {
        double temp;
        double pressure;
        double humidity;
        double temp_min;
        double temp_max;

        public double getTemp() {
            return temp;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }
    }

    public class Wind {
        double speed;
        double deg;

        public double getSpeed() {
            return speed;
        }

        public double getDeg() {
            return deg;
        }
    }

    public class Sys {
        int type;
        int id;
        double message;
        String country;
        long sunrise;
        long sunset;

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public double getMessage() {
            return message;
        }

        public String getCountry() {
            return country;
        }

        public long getSunrise() {
            return sunrise;
        }

        public long getSunset() {
            return sunset;
        }
    }
}
