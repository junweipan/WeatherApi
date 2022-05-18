package com.junwei.weatherapis.controller;

import com.junwei.weatherapis.model.Weather;
import com.junwei.weatherapis.model.Apikey;
import com.junwei.weatherapis.model.openWeather.OpenWeather;
import com.junwei.weatherapis.service.ApiKeyService;
import com.junwei.weatherapis.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//creating RestController
@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/weather")
    private List<Weather> getAllStudent()
    {
        return weatherService.getAllWeather();
    }

    @GetMapping("/weather/{id}")
    private Weather getStudent(@PathVariable("id") int id)
    {
        return weatherService.getWeatherById(id);
    }

    @DeleteMapping("/weather/{id}")
    private void deleteStudent(@PathVariable("id") int id)
    {
        weatherService.delete(id);
    }


    @PostMapping("/weather")
    private Weather saveStudent(@RequestBody Weather weather) throws ParseException {
        //get mock DB from service
        List<Apikey> apikeys = weatherService.getMockDB();

        String city = weather.getCity();
        String country = weather.getCountry();
        String userKey = "junwei001";
        String apiKey = "";
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//2022-05-18 20:40
        // use mockup APIkey db to retrieve realApiKey
        for (Apikey key:apikeys) {
            if (key.getApiKey().equals(userKey)){
                // call count <=5
                if (key.getCallCount()<=5){
                    String from = key.getLastCallTime();
                    String to =simpleFormat.format(new Date());
                    int result = weatherService.getTimeDiff(from,to);
                    // gap < 1 hour, count ++
                    if (result < 60){
                        key.setCallCount(key.getCallCount()+1);
                    }else{// gap > 1 hour, reset count, update last call_time
                        key.setCallCount(0);
                        key.setLastCallTime(to);
                    }
                    apiKey = key.getRealApi();

                }
            }
        }
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                +city
                +","
                +country
                +"&appid="+apiKey;
//        System.out.println("----------------------------");
//        System.out.println(url);
        OpenWeather result = restTemplate.getForObject(url,OpenWeather.class);
        weather.setDescription(result.weather.get(0).description);

        // save the weather situation to H2
        weatherService.saveOrUpdate(weather);
        return weather;
    }
}
