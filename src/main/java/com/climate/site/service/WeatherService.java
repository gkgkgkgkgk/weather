package com.climate.site.service;

import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gouri on 15/04/2016.
 */
@Component
public class WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    private String baseOwmUrl = "http://api.openweathermap.org/data/2.5/weather?appid=5ed92dce33449dc6e098806c2ea40a9a&units=metric&q=";

    private static final BigDecimal ONT_POINT_EIGHT = new BigDecimal("1.8");
    private static final BigDecimal THIRTY_TWO = new BigDecimal("32");

    /** Find current weather for city
     */
    public WeatherData currentWeatherForCity (String city) {

        try {
            JsonObject jsonObject = new JdkRequest(baseOwmUrl + city)
                    .fetch()
                    .as(JsonResponse.class)
                    .json().readObject();

            WeatherData data = new WeatherData();
            data.setCity(city);
            data.setDate(new Date(jsonObject.getJsonNumber("dt").longValue()*1000));
            data.setOutlook(jsonObject.getJsonArray("weather").getJsonObject(0).getString("description"));
            data.setSunrise(new Date(jsonObject.getJsonObject("sys").getJsonNumber("sunrise").longValue()*1000));
            data.setSunset(new Date(jsonObject.getJsonObject("sys").getJsonNumber("sunset").longValue()*1000));
            data.setTempc(jsonObject.getJsonObject("main").getJsonNumber("temp").bigDecimalValue());
            data.setTempf((data.getTempc().multiply(ONT_POINT_EIGHT)).add(THIRTY_TWO));
            return data;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
