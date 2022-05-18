package com.junwei.weatherapis.service;

import com.junwei.weatherapis.model.Apikey;
import com.junwei.weatherapis.model.Weather;
import com.junwei.weatherapis.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    WeatherRepository weatherRepository;
    //get all records
    public List<Weather> getAllWeather()
    {
        List<Weather> weathers = new ArrayList<Weather>();
        weatherRepository.findAll().forEach(weather -> weathers.add(weather));
        return weathers;
    }
    //get a record by id
    public Weather getWeatherById(int id)
    {
        return weatherRepository.findById(id).get();
    }
    public void saveOrUpdate(Weather weather)
    {
        weatherRepository.save(weather);
    }
    //delete by id
    public void delete(int id)
    {
        weatherRepository.deleteById(id);
    }
    // mock a APIkey db


    public List<Apikey> getMockDB(){
        //    public Apikey(int id, String apiKey, String lastCallTime, int callCount, String realApi)
        List<Apikey> apikeys = new ArrayList<Apikey>();
        apikeys.add(new Apikey(1, "junwei001", "2022-05-18 6:40",0, "07bd6d3c6fe2dcc92e6ca9a9522c6500"));
        apikeys.add(new Apikey(2, "junwei002", "2022-05-18 7:40",0, "07bd6d3c6fe2dcc92e6ca9a9522c6500"));
        apikeys.add(new Apikey(3, "junwei003", "2022-05-18 8:40",0, "07bd6d3c6fe2dcc92e6ca9a9522c6500"));
        apikeys.add(new Apikey(4, "junwei004", "2022-05-18 9:40",0, "07bd6d3c6fe2dcc92e6ca9a9522c6500"));
        apikeys.add(new Apikey(5, "junwei005", "2022-05-18 10:40",0, "07bd6d3c6fe2dcc92e6ca9a9522c6500"));

        return apikeys;
    }

    // get time difference between two time (string)
    public int getTimeDiff(String from, String to) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//2022-05-18 20:40
        Date fromDate3 = simpleFormat.parse(from);
        Date toDate3 = simpleFormat.parse(to);
        long from3 = fromDate3.getTime();
        long to3 = toDate3.getTime();
        int minutes = (int) ((to3 - from3) / (1000 * 60));
        return minutes;
    }
}
