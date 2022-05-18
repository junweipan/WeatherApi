package com.junwei.weatherapis.repository;
import com.junwei.weatherapis.model.Weather;
import org.springframework.data.repository.CrudRepository;
public interface WeatherRepository extends CrudRepository<Weather, Integer>
{
}
